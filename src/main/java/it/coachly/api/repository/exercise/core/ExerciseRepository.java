package it.coachly.api.repository.exercise.core;

import it.coachly.api.model.exercise.core.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, UUID>, QuerydslPredicateExecutor<Exercise> {

    @Query(value = """
            SELECT 
                e.id, e.name_i18n, e.description_i18n, e.tips_i18n,
                e.difficulty_level, e.mechanics_type, e.force_type,
                e.is_unilateral, e.is_bodyweight,
                jsonb_build_object(
                    'id', ee.exercise_id,
                    'canDoAtHome', ee.can_do_at_home,
                    'canDoInGym', ee.can_do_in_gym,
                    'equipmentSetupRequired', ee.equipment_setup_required
                ) as environment,
                jsonb_build_object(
                    'id', emp.exercise_id,
                    'movementPlane', emp.movement_plane,
                    'movementPattern', emp.movement_pattern,
                    'powerGenerationLevel', emp.power_generation_level
                ) as movement_pattern,
                jsonb_build_object(
                    'id', es.exercise_id,
                    'overallRiskLevel', es.overall_risk_level,
                    'spotterRequired', es.spotter_required,
                    'safetyNotesI18n', es.safety_notes_i18n
                ) as safety,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', ei.id,
                    'instructionType', ei.instruction_type,
                    'stepNumber', ei.step_number,
                    'instructionTextI18n', ei.instruction_text_i18n,
                    'isCritical', ei.is_critical
                )) FILTER (WHERE ei.id IS NOT NULL), '[]') as instructions,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', ev.variant_exercise_id,
                    'namei18n', ve.name_i18n,
                    'descriptioni18n', ve.description_i18n,
                    'tipsi18n', ve.tips_i18n,
                    'difficultyLevel', ve.difficulty_level,
                    'mechanicsType', ve.mechanics_type,
                    'forceType', ve.force_type,
                    'isUnilateral', ve.is_unilateral,
                    'isBodyweight', ve.is_bodyweight,
                    'variationType', ev.variation_type,
                    'difficultyDelta', ev.difficulty_delta
                )) FILTER (WHERE ev.id IS NOT NULL), '[]') as variants,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', emed.id,
                    'mediaType', emed.media_type,
                    'mediaUrl', emed.media_url,
                    'thumbnailUrl', emed.thumbnail_url,
                    'mediaPurpose', emed.media_purpose,
                    'viewAngle', emed.view_angle,
                    'isPrimary', emed.is_primary,
                    'isPublic', emed.is_public
                )) FILTER (WHERE emed.id IS NOT NULL), '[]') as media,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', esc.id,
                    'contraindicationType', esc.contraindication_type,
                    'conditionName', esc.condition_name,
                    'warningTextI18n', esc.warning_text_i18n
                )) FILTER (WHERE esc.id IS NOT NULL), '[]') as safety_contraindications,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', ec.id,
                    'code', ec.code,
                    'nameI18n', ec.name_i18n,
                    'descriptionI18n', ec.description_i18n,
                    'categoryLevel', ec.category_level,
                    'isPrimary', ecm2.is_primary_category
                )) FILTER (WHERE ec.id IS NOT NULL), '[]') as categories,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'muscle', jsonb_build_object(
                        'id', m.id,
                        'code', m.code,
                        'nameI18n', m.name_i18n,
                        'descriptionI18n', m.description_i18n,
                        'muscleGroup', m.muscle_group,
                        'muscleSubgroup', m.muscle_subgroup
                    ),
                    'involvementLevel', em2.involvement_level,
                    'primaryContractionType', CASE 
                        WHEN ct.id IS NOT NULL THEN jsonb_build_object(
                            'id', ct.id,
                            'code', ct.code,
                            'nameI18n', ct.name_i18n,
                            'descriptionI18n', ct.description_i18n
                        )
                        ELSE NULL
                    END,
                    'activationPercentage', em2.activation_percentage
                )) FILTER (WHERE em2.id IS NOT NULL), '[]') as muscles,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'equipment', jsonb_build_object(
                        'id', eq.id,
                        'code', eq.code,
                        'nameI18n', eq.name_i18n,
                        'descriptionI18n', eq.description_i18n,
                        'category', eq.category,
                        'equipmentType', eq.equipment_type
                    ),
                    'isRequired', eeq.is_required,
                    'isPrimary', eeq.is_primary,
                    'quantityNeeded', eeq.quantity_needed
                )) FILTER (WHERE eeq.id IS NOT NULL), '[]') as equipments,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', t.id,
                    'code', t.code,
                    'nameI18n', t.name_i18n,
                    'descriptionI18n', t.description_i18n,
                    'tagType', t.tag_type
                )) FILTER (WHERE t.id IS NOT NULL), '[]') as tags
            FROM exercises e
            LEFT JOIN exercise_environment ee ON ee.exercise_id = e.id
            LEFT JOIN exercise_movement_patterns emp ON emp.exercise_id = e.id
            LEFT JOIN exercise_instructions ei ON ei.exercise_id = e.id
            LEFT JOIN exercise_variations ev ON ev.base_exercise_id = e.id
            LEFT JOIN exercises ve ON ve.id = ev.variant_exercise_id
            LEFT JOIN exercise_media emed ON emed.exercise_id = e.id
            LEFT JOIN exercise_safety es ON es.exercise_id = e.id
            LEFT JOIN exercise_safety_contraindications esc ON esc.exercise_id = e.id
            LEFT JOIN exercise_category_mapping ecm2 ON ecm2.exercise_id = e.id
            LEFT JOIN exercise_categories ec ON ec.id = ecm2.category_id AND ec.is_active = true
            LEFT JOIN exercise_muscles em2 ON em2.exercise_id = e.id
            LEFT JOIN muscles m ON m.id = em2.muscle_id
            LEFT JOIN contraction_types ct ON ct.id = em2.primary_contraction_type_id
            LEFT JOIN exercise_equipment eeq ON eeq.exercise_id = e.id
            LEFT JOIN equipment eq ON eq.id = eeq.equipment_id
            LEFT JOIN exercise_tags et ON et.exercise_id = e.id
            LEFT JOIN tags t ON t.id = et.tag_id AND t.is_active = true
            WHERE e.id = :exerciseId
            GROUP BY e.id, ee.exercise_id, emp.exercise_id, es.exercise_id
            """, nativeQuery = true)
    Object[] findDetailById(@Param("exerciseId") UUID exerciseId);

    @Query(value = """
            WITH filtered_exercises AS (
                SELECT e.id
                FROM exercises e
                LEFT JOIN exercise_category_mapping ecm ON e.id = ecm.exercise_id
                LEFT JOIN exercise_muscles em ON e.id = em.exercise_id
                WHERE (:textFilter IS NULL OR :langFilter IS NULL
                       OR LOWER(e.name_i18n->>:langFilter) LIKE LOWER(CONCAT('%', :textFilter, '%')))
                  AND (:difficultyLevel IS NULL OR e.difficulty_level = CAST(:difficultyLevel AS VARCHAR))
                  AND (:mechanicsType IS NULL OR e.mechanics_type = CAST(:mechanicsType AS VARCHAR))
                  AND (:forceType IS NULL OR e.force_type = CAST(:forceType AS VARCHAR))
                  AND (:isUnilateral IS NULL OR e.is_unilateral = :isUnilateral)
                  AND (:isBodyweight IS NULL OR e.is_bodyweight = :isBodyweight)
                  AND (cardinality(:categoryIds) = 0 OR ecm.category_id = ANY(:categoryIds))
                  AND (cardinality(:muscleIds) = 0 OR em.muscle_id = ANY(:muscleIds))
                GROUP BY e.id
                OFFSET :offset LIMIT :limit
            )
            SELECT 
                e.id, e.name_i18n, e.description_i18n, e.tips_i18n,
                e.difficulty_level, e.mechanics_type, e.force_type,
                e.is_unilateral, e.is_bodyweight,
                jsonb_build_object(
                    'id', ee.exercise_id,
                    'canDoAtHome', ee.can_do_at_home,
                    'canDoInGym', ee.can_do_in_gym,
                    'equipmentSetupRequired', ee.equipment_setup_required
                ) as environment,
                jsonb_build_object(
                    'id', emp.exercise_id,
                    'movementPlane', emp.movement_plane,
                    'movementPattern', emp.movement_pattern,
                    'powerGenerationLevel', emp.power_generation_level
                ) as movement_pattern,
                jsonb_build_object(
                    'id', es.exercise_id,
                    'overallRiskLevel', es.overall_risk_level,
                    'spotterRequired', es.spotter_required,
                    'safetyNotesI18n', es.safety_notes_i18n
                ) as safety,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', ei.id,
                    'instructionType', ei.instruction_type,
                    'stepNumber', ei.step_number,
                    'instructionTextI18n', ei.instruction_text_i18n,
                    'isCritical', ei.is_critical
                )) FILTER (WHERE ei.id IS NOT NULL), '[]') as instructions,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', ev.variant_exercise_id,
                    'namei18n', ve.name_i18n,
                    'descriptioni18n', ve.description_i18n,
                    'tipsi18n', ve.tips_i18n,
                    'difficultyLevel', ve.difficulty_level,
                    'mechanicsType', ve.mechanics_type,
                    'forceType', ve.force_type,
                    'isUnilateral', ve.is_unilateral,
                    'isBodyweight', ve.is_bodyweight,
                    'variationType', ev.variation_type,
                    'difficultyDelta', ev.difficulty_delta
                )) FILTER (WHERE ev.id IS NOT NULL), '[]') as variants,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', emed.id,
                    'mediaType', emed.media_type,
                    'mediaUrl', emed.media_url,
                    'thumbnailUrl', emed.thumbnail_url,
                    'mediaPurpose', emed.media_purpose,
                    'viewAngle', emed.view_angle,
                    'isPrimary', emed.is_primary,
                    'isPublic', emed.is_public
                )) FILTER (WHERE emed.id IS NOT NULL), '[]') as media,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', esc.id,
                    'contraindicationType', esc.contraindication_type,
                    'conditionName', esc.condition_name,
                    'warningTextI18n', esc.warning_text_i18n
                )) FILTER (WHERE esc.id IS NOT NULL), '[]') as safety_contraindications,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', ec.id,
                    'code', ec.code,
                    'nameI18n', ec.name_i18n,
                    'descriptionI18n', ec.description_i18n,
                    'categoryLevel', ec.category_level,
                    'isPrimary', ecm2.is_primary_category
                )) FILTER (WHERE ec.id IS NOT NULL), '[]') as categories,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'muscle', jsonb_build_object(
                        'id', m.id,
                        'code', m.code,
                        'nameI18n', m.name_i18n,
                        'descriptionI18n', m.description_i18n,
                        'muscleGroup', m.muscle_group,
                        'muscleSubgroup', m.muscle_subgroup
                    ),
                    'involvementLevel', em2.involvement_level,
                    'primaryContractionType', CASE 
                        WHEN ct.id IS NOT NULL THEN jsonb_build_object(
                            'id', ct.id,
                            'code', ct.code,
                            'nameI18n', ct.name_i18n,
                            'descriptionI18n', ct.description_i18n
                        )
                        ELSE NULL
                    END,
                    'activationPercentage', em2.activation_percentage
                )) FILTER (WHERE em2.id IS NOT NULL), '[]') as muscles,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'equipment', jsonb_build_object(
                        'id', eq.id,
                        'code', eq.code,
                        'nameI18n', eq.name_i18n,
                        'descriptionI18n', eq.description_i18n,
                        'category', eq.category,
                        'equipmentType', eq.equipment_type
                    ),
                    'isRequired', eeq.is_required,
                    'isPrimary', eeq.is_primary,
                    'quantityNeeded', eeq.quantity_needed
                )) FILTER (WHERE eeq.id IS NOT NULL), '[]') as equipments,
                COALESCE(json_agg(DISTINCT jsonb_build_object(
                    'id', t.id,
                    'code', t.code,
                    'nameI18n', t.name_i18n,
                    'descriptionI18n', t.description_i18n,
                    'tagType', t.tag_type
                )) FILTER (WHERE t.id IS NOT NULL), '[]') as tags
            FROM filtered_exercises fe
            JOIN exercises e ON e.id = fe.id
            LEFT JOIN exercise_environment ee ON ee.exercise_id = e.id
            LEFT JOIN exercise_movement_patterns emp ON emp.exercise_id = e.id
            LEFT JOIN exercise_instructions ei ON ei.exercise_id = e.id
            LEFT JOIN exercise_variations ev ON ev.base_exercise_id = e.id
            LEFT JOIN exercises ve ON ve.id = ev.variant_exercise_id
            LEFT JOIN exercise_media emed ON emed.exercise_id = e.id
            LEFT JOIN exercise_safety es ON es.exercise_id = e.id
            LEFT JOIN exercise_safety_contraindications esc ON esc.exercise_id = e.id
            LEFT JOIN exercise_category_mapping ecm2 ON ecm2.exercise_id = e.id
            LEFT JOIN exercise_categories ec ON ec.id = ecm2.category_id AND ec.is_active = true
            LEFT JOIN exercise_muscles em2 ON em2.exercise_id = e.id
            LEFT JOIN muscles m ON m.id = em2.muscle_id
            LEFT JOIN contraction_types ct ON ct.id = em2.primary_contraction_type_id
            LEFT JOIN exercise_equipment eeq ON eeq.exercise_id = e.id
            LEFT JOIN equipment eq ON eq.id = eeq.equipment_id
            LEFT JOIN exercise_tags et ON et.exercise_id = e.id
            LEFT JOIN tags t ON t.id = et.tag_id AND t.is_active = true
            GROUP BY e.id, ee.exercise_id, emp.exercise_id, es.exercise_id
            """, nativeQuery = true)
    List<Object[]> findDetailsByFilter(
            @Param("textFilter") String textFilter,
            @Param("langFilter") String langFilter,
            @Param("difficultyLevel") String difficultyLevel,
            @Param("mechanicsType") String mechanicsType,
            @Param("forceType") String forceType,
            @Param("isUnilateral") Boolean isUnilateral,
            @Param("isBodyweight") Boolean isBodyweight,
            @Param("categoryIds") UUID[] categoryIds,
            @Param("muscleIds") UUID[] muscleIds,
            @Param("offset") Integer offset,
            @Param("limit") Integer limit
    );
}