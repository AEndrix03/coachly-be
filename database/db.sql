-- ============================================================================
-- COACHLY - DATABASE SCHEMA MVP (JSONB i18n)
-- ============================================================================

-- ============================================================================
-- ESERCIZI - CORE
-- ============================================================================

CREATE TABLE exercises (
                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                           code VARCHAR(150) UNIQUE NOT NULL,

    -- Campi tradotti JSONB
                           name_i18n JSONB NOT NULL,
                           description_i18n JSONB,
                           tips_i18n JSONB,

                           difficulty_level VARCHAR(20) NOT NULL,
                           mechanics_type VARCHAR(20) NOT NULL,
                           force_type VARCHAR(20),
                           is_unilateral BOOLEAN DEFAULT false,
                           is_bodyweight BOOLEAN DEFAULT false,
                           is_custom BOOLEAN DEFAULT false,
                           created_by UUID,
                           is_active BOOLEAN DEFAULT true,
                           created_at TIMESTAMP DEFAULT NOW(),
                           updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_exercises_name_i18n ON exercises USING GIN (name_i18n);
CREATE INDEX idx_exercises_code ON exercises(code);
CREATE INDEX idx_exercises_difficulty ON exercises(difficulty_level);
CREATE INDEX idx_exercises_mechanics ON exercises(mechanics_type);

-- ============================================================================
-- ESERCIZI - CARATTERISTICHE BASE
-- ============================================================================

CREATE TABLE exercise_movement_patterns (
                                            exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
                                            movement_plane VARCHAR(30),
                                            movement_pattern VARCHAR(100),
                                            power_generation_level VARCHAR(20),
                                            created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_environment (
                                      exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
                                      can_do_at_home BOOLEAN DEFAULT false,
                                      can_do_in_gym BOOLEAN DEFAULT true,
                                      equipment_setup_required BOOLEAN DEFAULT false,
                                      created_at TIMESTAMP DEFAULT NOW()
);

-- ============================================================================
-- MUSCOLI
-- ============================================================================

CREATE TABLE muscles (
                         id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                         code VARCHAR(150) UNIQUE NOT NULL,

    -- Campi tradotti JSONB
                         name_i18n JSONB NOT NULL,
                         description_i18n JSONB,

                         muscle_group VARCHAR(50) NOT NULL,
                         muscle_subgroup VARCHAR(100),
                         anatomical_name VARCHAR(255),
                         is_active BOOLEAN DEFAULT true,
                         created_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_muscles_name_i18n ON muscles USING GIN (name_i18n);
CREATE INDEX idx_muscles_code ON muscles(code);
CREATE INDEX idx_muscles_group ON muscles(muscle_group);

-- ============================================================================
-- TIPI DI CONTRAZIONE
-- ============================================================================

CREATE TABLE contraction_types (
                                   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                   code VARCHAR(50) UNIQUE NOT NULL,

    -- Campi tradotti JSONB
                                   name_i18n JSONB NOT NULL,
                                   description_i18n JSONB,

                                   created_at TIMESTAMP DEFAULT NOW()
);

INSERT INTO contraction_types (code, name_i18n) VALUES
                                                    ('concentric', '{"en": "Concentric", "it": "Concentrica"}'),
                                                    ('eccentric', '{"en": "Eccentric", "it": "Eccentrica"}'),
                                                    ('isometric', '{"en": "Isometric", "it": "Isometrica"}'),
                                                    ('isotonic', '{"en": "Isotonic", "it": "Isotonica"}'),
                                                    ('plyometric', '{"en": "Plyometric", "it": "Pliometrica"}');

-- ============================================================================
-- EXERCISE-MUSCLE RELATIONSHIP
-- ============================================================================

CREATE TABLE exercise_muscles (
                                  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                  exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
                                  muscle_id UUID NOT NULL REFERENCES muscles(id) ON DELETE CASCADE,
                                  involvement_level VARCHAR(30) NOT NULL,
                                  primary_contraction_type_id UUID REFERENCES contraction_types(id),
                                  activation_percentage INTEGER CHECK (activation_percentage BETWEEN 0 AND 100),
                                  created_at TIMESTAMP DEFAULT NOW(),

                                  UNIQUE(exercise_id, muscle_id, involvement_level)
);

CREATE INDEX idx_exercise_muscles_exercise ON exercise_muscles(exercise_id);
CREATE INDEX idx_exercise_muscles_muscle ON exercise_muscles(muscle_id);

-- ============================================================================
-- ATTREZZATURA
-- ============================================================================

CREATE TABLE equipment (
                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                           code VARCHAR(150) UNIQUE NOT NULL,

    -- Campi tradotti JSONB
                           name_i18n JSONB NOT NULL,
                           description_i18n JSONB,

                           category VARCHAR(50) NOT NULL,
                           equipment_type VARCHAR(50),
                           is_active BOOLEAN DEFAULT true,
                           created_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_equipment_name_i18n ON equipment USING GIN (name_i18n);
CREATE INDEX idx_equipment_code ON equipment(code);
CREATE INDEX idx_equipment_category ON equipment(category);

-- ============================================================================
-- EXERCISE-EQUIPMENT RELATIONSHIP
-- ============================================================================

CREATE TABLE exercise_equipment (
                                    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                    exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
                                    equipment_id UUID NOT NULL REFERENCES equipment(id) ON DELETE CASCADE,
                                    is_required BOOLEAN DEFAULT true,
                                    is_primary BOOLEAN DEFAULT true,
                                    quantity_needed INTEGER DEFAULT 1,
                                    created_at TIMESTAMP DEFAULT NOW(),

                                    UNIQUE(exercise_id, equipment_id)
);

CREATE INDEX idx_exercise_equipment_exercise ON exercise_equipment(exercise_id);
CREATE INDEX idx_exercise_equipment_equipment ON exercise_equipment(equipment_id);

-- ============================================================================
-- CATEGORIE
-- ============================================================================

CREATE TABLE exercise_categories (
                                     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                     code VARCHAR(150) UNIQUE NOT NULL,

    -- Campi tradotti JSONB
                                     name_i18n JSONB NOT NULL,
                                     description_i18n JSONB,

                                     parent_category_id UUID REFERENCES exercise_categories(id),
                                     category_level INTEGER DEFAULT 1,
                                     display_order INTEGER DEFAULT 0,
                                     is_active BOOLEAN DEFAULT true,
                                     created_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_exercise_categories_name_i18n ON exercise_categories USING GIN (name_i18n);
CREATE INDEX idx_exercise_categories_parent ON exercise_categories(parent_category_id);
CREATE INDEX idx_exercise_categories_level ON exercise_categories(category_level);

CREATE TABLE exercise_category_mapping (
                                           exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
                                           category_id UUID NOT NULL REFERENCES exercise_categories(id) ON DELETE CASCADE,
                                           is_primary_category BOOLEAN DEFAULT false,
                                           created_at TIMESTAMP DEFAULT NOW(),

                                           PRIMARY KEY (exercise_id, category_id)
);

CREATE INDEX idx_exercise_category_mapping_exercise ON exercise_category_mapping(exercise_id);
CREATE INDEX idx_exercise_category_mapping_category ON exercise_category_mapping(category_id);

-- ============================================================================
-- TAGS (per filtri flessibili)
-- ============================================================================

CREATE TABLE tags (
                      id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                      code VARCHAR(150) UNIQUE NOT NULL,

    -- Campi tradotti JSONB
                      name_i18n JSONB NOT NULL,
                      description_i18n JSONB,

                      tag_type VARCHAR(50),
                      is_active BOOLEAN DEFAULT true,
                      created_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_tags_name_i18n ON tags USING GIN (name_i18n);
CREATE INDEX idx_tags_type ON tags(tag_type);

CREATE TABLE exercise_tags (
                               exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
                               tag_id UUID NOT NULL REFERENCES tags(id) ON DELETE CASCADE,
                               created_at TIMESTAMP DEFAULT NOW(),

                               PRIMARY KEY (exercise_id, tag_id)
);

CREATE INDEX idx_exercise_tags_exercise ON exercise_tags(exercise_id);
CREATE INDEX idx_exercise_tags_tag ON exercise_tags(tag_id);

-- ============================================================================
-- MEDIA (Video e Immagini)
-- ============================================================================

CREATE TABLE exercise_media (
                                id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
                                media_type VARCHAR(30) NOT NULL,
                                media_url VARCHAR(500) NOT NULL,
                                thumbnail_url VARCHAR(500),
                                media_purpose VARCHAR(50) NOT NULL,
                                view_angle VARCHAR(50),
                                display_order INTEGER DEFAULT 0,
                                is_primary BOOLEAN DEFAULT false,
                                is_public BOOLEAN DEFAULT true,
                                created_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_exercise_media_exercise ON exercise_media(exercise_id);
CREATE INDEX idx_exercise_media_type ON exercise_media(media_type);

-- ============================================================================
-- ISTRUZIONI STEP-BY-STEP
-- ============================================================================

CREATE TABLE exercise_instructions (
                                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                       exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
                                       instruction_type VARCHAR(30) NOT NULL,
                                       step_number INTEGER NOT NULL,

    -- Campo tradotto JSONB
                                       instruction_text_i18n JSONB NOT NULL,

                                       is_critical BOOLEAN DEFAULT false,
                                       created_at TIMESTAMP DEFAULT NOW(),

                                       UNIQUE(exercise_id, instruction_type, step_number)
);

CREATE INDEX idx_exercise_instructions_exercise ON exercise_instructions(exercise_id);
CREATE INDEX idx_exercise_instructions_type ON exercise_instructions(instruction_type);

-- ============================================================================
-- SICUREZZA
-- ============================================================================

CREATE TABLE exercise_safety (
                                 exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
                                 overall_risk_level VARCHAR(20) NOT NULL,
                                 spotter_required BOOLEAN DEFAULT false,

    -- Campo tradotto JSONB
                                 safety_notes_i18n JSONB,

                                 created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE exercise_safety_contraindications (
                                                   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                                   exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
                                                   contraindication_type VARCHAR(20) NOT NULL,
                                                   condition_name VARCHAR(100) NOT NULL,

    -- Campo tradotto JSONB
                                                   warning_text_i18n JSONB,

                                                   created_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_safety_contraindications_exercise ON exercise_safety_contraindications(exercise_id);

-- ============================================================================
-- VARIAZIONI
-- ============================================================================

CREATE TABLE exercise_variations (
                                     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                     base_exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
                                     variant_exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,
                                     variation_type VARCHAR(50) NOT NULL,
                                     difficulty_delta INTEGER,
                                     created_at TIMESTAMP DEFAULT NOW(),

                                     UNIQUE(base_exercise_id, variant_exercise_id, variation_type),
                                     CHECK (base_exercise_id != variant_exercise_id)
    );

CREATE INDEX idx_exercise_variations_base ON exercise_variations(base_exercise_id);
CREATE INDEX idx_exercise_variations_variant ON exercise_variations(variant_exercise_id);

-- ============================================================================
-- METRICHE
-- ============================================================================

CREATE TABLE exercise_metrics (
                                  exercise_id UUID PRIMARY KEY REFERENCES exercises(id) ON DELETE CASCADE,
                                  popularity_score INTEGER DEFAULT 0,
                                  usage_count INTEGER DEFAULT 0,
                                  created_at TIMESTAMP DEFAULT NOW(),
                                  updated_at TIMESTAMP DEFAULT NOW()
);