-- ============================================================================
-- COACHLY - DATABASE SCHEMA - FASE 2 (TODO)
-- Tabelle da implementare dopo MVP
-- ============================================================================

-- ============================================================================
-- GRUPPO 1: BIOMECCANICA AVANZATA
-- Descrizione: Dettagli biomeccanici approfonditi per analisi tecnica
-- Priorità: MEDIA
-- Quando: Dopo aver popolato esercizi base e prima di implementare AI coach
-- ============================================================================

-- Dettagli articolazioni e ROM
CREATE TABLE exercise_biomechanics (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    primary_joint VARCHAR(50) NOT NULL,
    joint_action VARCHAR(100),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_secondary_joints (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    joint_name VARCHAR(50) NOT NULL,
    involvement_level VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE(exercise_id, joint_name)
);

CREATE TABLE exercise_rom (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    rom_start_degrees INTEGER,
    rom_end_degrees INTEGER,
    optimal_rom_min_degrees INTEGER,
    optimal_rom_max_degrees INTEGER,
    rom_limiting_factor VARCHAR(100),
    created_at TIMESTAMP DEFAULT NOW()
);

-- Tempo di esecuzione
CREATE TABLE exercise_tempo (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    tempo_eccentric_seconds DECIMAL(3,1),
    tempo_pause_bottom_seconds DECIMAL(3,1),
    tempo_concentric_seconds DECIMAL(3,1),
    tempo_pause_top_seconds DECIMAL(3,1),
    tempo_notation VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

-- Range di ripetizioni per obiettivo
CREATE TABLE exercise_rep_ranges (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    goal_type VARCHAR(30) NOT NULL,
    rep_min INTEGER NOT NULL,
    rep_max INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE(exercise_id, goal_type)
);

-- Intensità e volume consigliati
CREATE TABLE exercise_intensity (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    recommended_rpe_min INTEGER,
    recommended_rpe_max INTEGER,
    recommended_rir_min INTEGER,
    recommended_rir_max INTEGER,
    optimal_sets_min INTEGER,
    optimal_sets_max INTEGER,
    max_effective_sets_per_week INTEGER,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_rest_times (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    goal_type VARCHAR(30) NOT NULL,
    rest_seconds INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE(exercise_id, goal_type)
);

-- Biomeccanica avanzata (leve, curve di forza)
CREATE TABLE exercise_biomech_advanced (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    moment_arm_length VARCHAR(20),
    leverage_advantage VARCHAR(30),
    force_curve_type VARCHAR(30),
    sticking_point_exists BOOLEAN DEFAULT false,
    sticking_point_location VARCHAR(50),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_spine_loading (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    spine_position VARCHAR(30),
    spine_load_level VARCHAR(20),
    shear_forces_level VARCHAR(20),
    compressive_forces_level VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 2: DETTAGLI MUSCOLI
-- Descrizione: Anatomia e caratteristiche muscolari dettagliate
-- Priorità: MEDIA
-- Quando: Dopo popolamento muscoli base, utile per contenuti educativi
-- ============================================================================

CREATE TABLE muscle_anatomy (
    muscle_id UUID PRIMARY KEY REFERENCES muscles(id) ON DELETE CASCADE,
    origin_bone VARCHAR(100),
    origin_point TEXT,
    insertion_bone VARCHAR(100),
    insertion_point TEXT,
    nerve_supply VARCHAR(100),
    nerve_root_level VARCHAR(50),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE muscle_actions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    muscle_id UUID NOT NULL REFERENCES muscles(id) ON DELETE CASCADE,
    action_type VARCHAR(20) NOT NULL,
    action_description TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE muscle_characteristics (
    muscle_id UUID PRIMARY KEY REFERENCES muscles(id) ON DELETE CASCADE,
    muscle_size VARCHAR(30),
    recovery_time_hours INTEGER,
    injury_susceptibility VARCHAR(20),
    is_superficial BOOLEAN DEFAULT true,
    is_visible_when_contracted BOOLEAN DEFAULT false,
    palpation_difficulty VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE muscle_training_response (
    muscle_id UUID PRIMARY KEY REFERENCES muscles(id) ON DELETE CASCADE,
    responds_well_to_volume BOOLEAN DEFAULT true,
    responds_well_to_intensity BOOLEAN DEFAULT true,
    isolation_possible BOOLEAN DEFAULT true,
    stretch_importance VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE muscle_synergies (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    primary_muscle_id UUID NOT NULL REFERENCES muscles(id) ON DELETE CASCADE,
    synergist_muscle_id UUID NOT NULL REFERENCES muscles(id) ON DELETE CASCADE,
    synergy_type VARCHAR(30) NOT NULL,
    synergy_strength VARCHAR(20),
    movement_context TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE(primary_muscle_id, synergist_muscle_id, synergy_type),
    CHECK (primary_muscle_id != synergist_muscle_id)
);

-- ============================================================================
-- GRUPPO 3: DETTAGLI EXERCISE-MUSCLE
-- Descrizione: Attivazione muscolare dettagliata (EMG, stretch, stimolo)
-- Priorità: BASSA
-- Quando: Dopo aver implementato AI e quando si hanno dati scientifici
-- ============================================================================

CREATE TABLE exercise_muscle_activation (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_muscle_id UUID NOT NULL REFERENCES exercise_muscles(id) ON DELETE CASCADE UNIQUE,
    activation_phase VARCHAR(50),
    time_under_tension_percentage INTEGER,
    rom_involvement VARCHAR(30),
    rom_degrees_start INTEGER,
    rom_degrees_end INTEGER,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_muscle_stretch (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_muscle_id UUID NOT NULL REFERENCES exercise_muscles(id) ON DELETE CASCADE UNIQUE,
    stretch_level VARCHAR(20),
    muscle_length_at_peak VARCHAR(30),
    peak_force_angle_degrees INTEGER,
    weakest_angle_degrees INTEGER,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_muscle_training_effect (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_muscle_id UUID NOT NULL REFERENCES exercise_muscles(id) ON DELETE CASCADE UNIQUE,
    hypertrophy_stimulus VARCHAR(20),
    strength_development VARCHAR(20),
    power_development VARCHAR(20),
    endurance_stimulus VARCHAR(20),
    fatigue_contribution VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_muscle_emg (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_muscle_id UUID NOT NULL REFERENCES exercise_muscles(id) ON DELETE CASCADE UNIQUE,
    emg_activation_mean DECIMAL(5,2),
    emg_activation_peak DECIMAL(5,2),
    study_reference TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 4: DETTAGLI ATTREZZATURA
-- Descrizione: Specifiche tecniche, costi, dimensioni attrezzatura
-- Priorità: BASSA
-- Quando: Per marketplace attrezzatura o filtri avanzati (Fase 3)
-- ============================================================================

CREATE TABLE equipment_specifications (
    equipment_id UUID PRIMARY KEY REFERENCES equipment(id) ON DELETE CASCADE,
    is_adjustable BOOLEAN DEFAULT false,
    weight_increments_kg DECIMAL(5,2),
    min_weight_kg DECIMAL(7,2),
    max_weight_kg DECIMAL(7,2),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE equipment_dimensions (
    equipment_id UUID PRIMARY KEY REFERENCES equipment(id) ON DELETE CASCADE,
    length_cm INTEGER,
    width_cm INTEGER,
    height_cm INTEGER,
    weight_kg DECIMAL(7,2),
    space_required_sqm DECIMAL(6,2),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE equipment_usability (
    equipment_id UUID PRIMARY KEY REFERENCES equipment(id) ON DELETE CASCADE,
    setup_difficulty VARCHAR(20),
    setup_time_seconds INTEGER,
    adjustment_complexity VARCHAR(20),
    user_friendliness VARCHAR(20),
    requires_supervision BOOLEAN DEFAULT false,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE equipment_cost_availability (
    equipment_id UUID PRIMARY KEY REFERENCES equipment(id) ON DELETE CASCADE,
    approximate_cost_eur INTEGER,
    availability VARCHAR(30),
    home_gym_suitable BOOLEAN DEFAULT false,
    maintenance_required VARCHAR(20),
    durability_rating VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE equipment_versatility (
    equipment_id UUID PRIMARY KEY REFERENCES equipment(id) ON DELETE CASCADE,
    versatility_score INTEGER CHECK (versatility_score BETWEEN 1 AND 10),
    primary_use_case VARCHAR(100),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE equipment_metadata (
    equipment_id UUID PRIMARY KEY REFERENCES equipment(id) ON DELETE CASCADE,
    manufacturer VARCHAR(255),
    model VARCHAR(255),
    release_year INTEGER,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE equipment_safety_features (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    equipment_id UUID NOT NULL REFERENCES equipment(id) ON DELETE CASCADE,
    feature_name VARCHAR(100) NOT NULL,
    feature_description TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE equipment_alternatives (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    original_equipment_id UUID NOT NULL REFERENCES equipment(id) ON DELETE CASCADE,
    alternative_equipment_id UUID NOT NULL REFERENCES equipment(id) ON DELETE CASCADE,
    substitution_quality VARCHAR(20) NOT NULL,
    effectiveness_percentage INTEGER CHECK (effectiveness_percentage BETWEEN 0 AND 100),
    notes TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE(original_equipment_id, alternative_equipment_id),
    CHECK (original_equipment_id != alternative_equipment_id)
);

-- ============================================================================
-- GRUPPO 5: DETTAGLI EXERCISE-EQUIPMENT
-- Descrizione: Setup specifico attrezzatura per esercizio (grip, stance, etc)
-- Priorità: MEDIA
-- Quando: Dopo MVP, per istruzioni tecniche dettagliate
-- ============================================================================

CREATE TABLE exercise_equipment_setup (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_equipment_id UUID NOT NULL REFERENCES exercise_equipment(id) ON DELETE CASCADE UNIQUE,
    typical_weight_range_min_kg DECIMAL(7,2),
    typical_weight_range_max_kg DECIMAL(7,2),
    position_relative_to_body VARCHAR(50),
    grip_type VARCHAR(50),
    grip_width VARCHAR(30),
    stance_width VARCHAR(30),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_equipment_adjustments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_equipment_id UUID NOT NULL REFERENCES exercise_equipment(id) ON DELETE CASCADE,
    adjustment_description TEXT NOT NULL,
    is_critical BOOLEAN DEFAULT false,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_equipment_safety (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_equipment_id UUID NOT NULL REFERENCES exercise_equipment(id) ON DELETE CASCADE UNIQUE,
    safety_concerns TEXT,
    spotter_needed BOOLEAN DEFAULT false,
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 6: PROGRESSIONI DETTAGLIATE
-- Descrizione: Catene di progressione strutturate per principianti
-- Priorità: MEDIA
-- Quando: Fase 2, per programmi automatici progressivi
-- ============================================================================

CREATE TABLE exercise_progressions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    progression_name VARCHAR(255) NOT NULL,
    progression_type VARCHAR(50),
    total_steps INTEGER NOT NULL,
    estimated_total_weeks INTEGER,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_progression_steps (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    progression_id UUID NOT NULL REFERENCES exercise_progressions(id) ON DELETE CASCADE,
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    step_number INTEGER NOT NULL,
    duration_weeks INTEGER,
    mastery_criteria TEXT,
    recommended_volume TEXT,
    coaching_notes TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE(progression_id, step_number),
    UNIQUE(progression_id, exercise_id)
);

CREATE TABLE exercise_variation_details (
    variation_id UUID PRIMARY KEY REFERENCES exercise_variations(id) ON DELETE CASCADE,
    key_differences TEXT,
    muscle_emphasis_change TEXT,
    biomechanical_differences TEXT,
    recommended_transition_criteria TEXT,
    programming_notes TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 7: DETTAGLI MEDIA
-- Descrizione: Metadati video, sottotitoli, qualità
-- Priorità: BASSA
-- Quando: Quando si hanno molti video e serve gestione avanzata
-- ============================================================================

CREATE TABLE exercise_media_video_details (
    media_id UUID PRIMARY KEY REFERENCES exercise_media(id) ON DELETE CASCADE,
    duration_seconds INTEGER,
    fps INTEGER,
    resolution VARCHAR(20),
    has_audio BOOLEAN DEFAULT true,
    has_subtitles BOOLEAN DEFAULT false,
    has_overlays BOOLEAN DEFAULT false,
    has_slow_motion_sections BOOLEAN DEFAULT false,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_media_subtitle_languages (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    media_id UUID NOT NULL REFERENCES exercise_media(id) ON DELETE CASCADE,
    locale VARCHAR(10) NOT NULL,
    subtitle_url VARCHAR(500),
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE(media_id, locale)
);

CREATE TABLE exercise_media_metadata (
    media_id UUID PRIMARY KEY REFERENCES exercise_media(id) ON DELETE CASCADE,
    quality_rating VARCHAR(20),
    camera_movement VARCHAR(30),
    includes_coaching_cues BOOLEAN DEFAULT false,
    includes_safety_warnings BOOLEAN DEFAULT false,
    file_size_mb DECIMAL(10,2),
    upload_date TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_media_engagement (
    media_id UUID PRIMARY KEY REFERENCES exercise_media(id) ON DELETE CASCADE,
    view_count INTEGER DEFAULT 0,
    like_count INTEGER DEFAULT 0,
    last_viewed_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 8: COACHING E CUES
-- Descrizione: Cues tecnici per coaching (interni, esterni, visivi)
-- Priorità: MEDIA
-- Quando: Per AI coaching e contenuti educativi avanzati
-- ============================================================================

CREATE TABLE exercise_coaching_cues (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    cue_type VARCHAR(50) NOT NULL,
    exercise_phase VARCHAR(30),
    target_aspect VARCHAR(50),
    effectiveness_rating VARCHAR(20),
    works_best_for_level VARCHAR(30),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_coaching_cue_details (
    cue_id UUID PRIMARY KEY REFERENCES exercise_coaching_cues(id) ON DELETE CASCADE,
    use_when TEXT,
    avoid_when TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 9: SICUREZZA AVANZATA
-- Descrizione: Dettagli sicurezza approfonditi (controindicazioni, warmup)
-- Priorità: ALTA (ma dopo MVP base)
-- Quando: Subito dopo MVP, prima del lancio pubblico
-- ============================================================================

CREATE TABLE exercise_safety_high_risk_body_parts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    body_part VARCHAR(50) NOT NULL,
    risk_level VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_safety_specific_conditions (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    contraindicated_for_pregnancy BOOLEAN DEFAULT false,
    contraindicated_for_lower_back_pain BOOLEAN DEFAULT false,
    contraindicated_for_shoulder_issues BOOLEAN DEFAULT false,
    contraindicated_for_knee_issues BOOLEAN DEFAULT false,
    contraindicated_for_hip_issues BOOLEAN DEFAULT false,
    contraindicated_for_neck_issues BOOLEAN DEFAULT false,
    contraindicated_for_wrist_issues BOOLEAN DEFAULT false,
    contraindicated_for_ankle_issues BOOLEAN DEFAULT false,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_safety_age_fitness (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    minimum_recommended_age INTEGER,
    requires_baseline_strength BOOLEAN DEFAULT false,
    requires_baseline_mobility BOOLEAN DEFAULT false,
    requires_baseline_stability BOOLEAN DEFAULT false,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_safety_equipment_recommendations (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    safety_gear VARCHAR(100) NOT NULL,
    importance_level VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_safety_warmup (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    specific_warmup_required BOOLEAN DEFAULT true,
    warmup_duration_minutes INTEGER,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_safety_warmup_areas (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    body_area VARCHAR(50) NOT NULL,
    priority_level VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_safety_dangerous_mistakes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    mistake_description TEXT NOT NULL,
    severity VARCHAR(20),
    injury_mechanism TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_safety_common_injuries (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    injury_name VARCHAR(100) NOT NULL,
    frequency VARCHAR(20),
    warning_signs TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_safety_progressive_loading (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    load_progression_caution_level VARCHAR(20),
    max_recommended_weight_increase_pct INTEGER,
    deload_frequency_weeks INTEGER,
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 10: PREREQUISITI
-- Descrizione: Requisiti di forza, mobilità, skill per eseguire esercizio
-- Priorità: MEDIA
-- Quando: Per sistema di progressioni e raccomandazioni personalizzate
-- ============================================================================

CREATE TABLE exercise_prerequisites (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    prerequisite_type VARCHAR(50) NOT NULL,
    prerequisite_exercise_id UUID REFERENCES exercises(id),
    importance_level VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_prerequisite_details (
    prerequisite_id UUID PRIMARY KEY REFERENCES exercise_prerequisites(id) ON DELETE CASCADE,
    strength_requirement_description TEXT,
    mobility_requirement_description TEXT,
    required_rom_degrees INTEGER,
    assessment_method TEXT,
    passing_criteria TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 11: PROGRAMMAZIONE
-- Descrizione: Linee guida per inserire esercizio in programma allenamento
-- Priorità: ALTA (dopo MVP)
-- Quando: Fase 2, per AI plan generator coach
-- ============================================================================

CREATE TABLE exercise_programming_guidelines (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    workout_placement VARCHAR(50),
    fatigue_sensitivity VARCHAR(20),
    suitable_for_superset BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_programming_frequency (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    min_frequency_per_week INTEGER,
    max_frequency_per_week INTEGER,
    optimal_frequency_per_week INTEGER,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_programming_volume (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    min_sets_per_week INTEGER,
    max_sets_per_week INTEGER,
    maximum_adaptive_volume INTEGER,
    maintenance_volume INTEGER,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_programming_intensity (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    optimal_intensity_pct_1rm_min INTEGER,
    optimal_intensity_pct_1rm_max INTEGER,
    effective_intensity_range TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_programming_combinations (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    combination_type VARCHAR(20) NOT NULL,
    other_exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    notes TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    CHECK (exercise_id != other_exercise_id)
);

CREATE TABLE exercise_programming_superset (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    superset_recommendations TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_programming_deload (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    deload_strategy VARCHAR(50),
    deload_modification_notes TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_programming_periodization (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    works_in_accumulation_phase BOOLEAN DEFAULT true,
    works_in_intensification_phase BOOLEAN DEFAULT true,
    works_in_realization_phase BOOLEAN DEFAULT true,
    works_in_deload_phase BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_programming_notes_by_level (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    skill_level VARCHAR(30) NOT NULL,
    programming_notes TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE(exercise_id, skill_level)
);

-- ============================================================================
-- GRUPPO 12: MODIFICHE PER POPOLAZIONI SPECIALI
-- Descrizione: Adattamenti esercizi per gravidanza, infortuni, età
-- Priorità: MEDIA-BASSA
-- Quando: Fase 3, per espansione target utenti
-- ============================================================================

CREATE TABLE exercise_modifications (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    target_population VARCHAR(50) NOT NULL,
    modification_description TEXT NOT NULL,
    alternative_exercise_id UUID REFERENCES exercises(id),
    effectiveness_vs_standard INTEGER CHECK (effectiveness_vs_standard BETWEEN 0 AND 100),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_modification_changes (
    modification_id UUID PRIMARY KEY REFERENCES exercise_modifications(id) ON DELETE CASCADE,
    setup_changes TEXT,
    rom_changes TEXT,
    load_recommendations TEXT,
    tempo_changes TEXT,
    volume_recommendations TEXT,
    additional_safety_notes TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 13: RIFERIMENTI SCIENTIFICI
-- Descrizione: Studi, paper, ricerche su esercizio
-- Priorità: BASSA
-- Quando: Per contenuti educativi premium o certificazioni
-- ============================================================================

CREATE TABLE exercise_scientific_references (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    reference_type VARCHAR(50),
    title TEXT NOT NULL,
    authors TEXT,
    journal VARCHAR(255),
    publication_year INTEGER,
    doi VARCHAR(255),
    pubmed_id VARCHAR(50),
    url VARCHAR(500),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_scientific_reference_details (
    reference_id UUID PRIMARY KEY REFERENCES exercise_scientific_references(id) ON DELETE CASCADE,
    relevance_to_exercise TEXT,
    key_findings TEXT,
    evidence_level VARCHAR(20),
    study_quality_rating INTEGER CHECK (study_quality_rating BETWEEN 1 AND 10),
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 14: FEEDBACK UTENTI
-- Descrizione: Metriche aggregate da feedback utenti (ratings, completion)
-- Priorità: MEDIA
-- Quando: Dopo lancio, quando si hanno utenti attivi
-- Note: Si popolano automaticamente via app, non servono subito
-- ============================================================================

CREATE TABLE exercise_feedback_metrics (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    perceived_difficulty_avg DECIMAL(3,2),
    perceived_difficulty_count INTEGER DEFAULT 0,
    effectiveness_rating_avg DECIMAL(3,2),
    effectiveness_rating_count INTEGER DEFAULT 0,
    muscle_activation_rating_avg DECIMAL(3,2),
    enjoyment_rating_avg DECIMAL(3,2),
    safety_rating_avg DECIMAL(3,2),
    form_difficulty_avg DECIMAL(3,2),
    overall_satisfaction_avg DECIMAL(3,2),
    total_feedback_responses INTEGER DEFAULT 0,
    last_updated TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_feedback_completion (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    completion_rate DECIMAL(5,2),
    dropout_rate DECIMAL(5,2),
    would_recommend_percentage DECIMAL(5,2),
    last_updated TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_feedback_injury_reports (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    injury_report_count INTEGER DEFAULT 0,
    injury_rate DECIMAL(5,4),
    last_updated TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 15: AI E EMBEDDINGS
-- Descrizione: Embeddings vettoriali, keywords, RAG context per AI
-- Priorità: ALTA (ma dopo avere dati)
-- Quando: Sprint 5 (AI Motivation), quando si implementa RAG
-- Note: Richiede PostgreSQL con estensione pgvector
-- ============================================================================

CREATE TABLE exercise_ai_embeddings (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    description_embedding VECTOR(384),
    biomechanics_embedding VECTOR(384),
    combined_embedding VECTOR(384),
    embedding_model_version VARCHAR(50),
    embeddings_generated_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

-- Richiede: CREATE EXTENSION IF NOT EXISTS vector;
-- CREATE INDEX idx_exercise_ai_combined_embedding ON exercise_ai_embeddings 
-- USING ivfflat (combined_embedding vector_cosine_ops) WITH (lists = 100);

CREATE TABLE exercise_ai_keywords (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    keyword_type VARCHAR(30) NOT NULL,
    keyword VARCHAR(100) NOT NULL,
    relevance_score DECIMAL(3,2),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_ai_coaching_tone (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    coaching_tone VARCHAR(30),
    complexity_for_explanation VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_ai_analogies (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    analogy_type VARCHAR(30),
    analogy_text TEXT NOT NULL,
    effectiveness_rating VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_ai_rag_context (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    rag_context_summary TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_ai_important_facts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    fact_text TEXT NOT NULL,
    priority_level INTEGER DEFAULT 1,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_ai_common_questions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    question_text TEXT NOT NULL,
    frequency_score INTEGER DEFAULT 1,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_ai_search_queries (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    search_query TEXT NOT NULL,
    frequency INTEGER DEFAULT 1,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_ai_cue_suggestions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    cue_text TEXT NOT NULL,
    context VARCHAR(100),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_ai_form_check_prompts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
    prompt_text TEXT NOT NULL,
    check_type VARCHAR(50),
    created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- GRUPPO 16: CARATTERISTICHE ESERCIZIO (dettagli minori)
-- Descrizione: Requisiti coordinazione, setup, stabilità, velocità
-- Priorità: BASSA
-- Quando: Per filtri avanzati e raccomandazioni personalizzate
-- ============================================================================

CREATE TABLE exercise_requirements (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    coordination_level VARCHAR(20),
    balance_level VARCHAR(20),
    flexibility_level VARCHAR(20),
    core_stability_level VARCHAR(20),
    requires_spotter BOOLEAN DEFAULT false,
    requires_warmup BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_setup (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    setup_complexity VARCHAR(20),
    setup_time_seconds INTEGER,
    space_requirement VARCHAR(30),
    noise_level VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_velocity (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    bar_speed_requirement VARCHAR(30),
    acceleration_phase_importance VARCHAR(20),
    deceleration_control_needed BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_stability (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    stability_demand VARCHAR(20),
    proprioceptive_demand VARCHAR(20),
    neuromuscular_coordination_level VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_ratings (
    exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
    average_rating DECIMAL(3,2),
    total_ratings INTEGER DEFAULT 0,
    is_verified BOOLEAN DEFAULT false,
    verified_by UUID,
    verified_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- FINE SCHEMA FASE 2
-- ============================================================================

-- ============================================================================
-- NOTE IMPLEMENTAZIONE:
-- ============================================================================
-- 1. Implementare questi gruppi progressivamente in base alle priorità
-- 2. GRUPPO 9 (Sicurezza Avanzata) e GRUPPO 11 (Programmazione) sono 
--    i più importanti dopo MVP
-- 3. GRUPPO 15 (AI) va implementato prima dello Sprint 5 (AI Motivation)
-- 4. GRUPPO 14 (Feedback) si popola automaticamente, implementare quando 
--    si hanno utenti reali
-- 5. GRUPPO 13 (Riferimenti Scientifici) e GRUPPO 12 (Modifiche) sono 
--    nice-to-have per contenuti premium
-- ============================================================================