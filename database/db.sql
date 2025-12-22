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

-- ============================================================================
-- COACHLY - WORKOUT & ACTIVITY TRACKING SCHEMA
-- Solo nuove entità per il sistema di allenamento
-- ============================================================================

-- ============================================================================
-- TIPOLOGIE DI SERIE (normalizzate)
-- ============================================================================

CREATE TABLE set_types (
                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                           code VARCHAR(50) UNIQUE NOT NULL,

                           name_i18n JSONB NOT NULL,
                           description_i18n JSONB,

                           category VARCHAR(30) NOT NULL, -- 'intensity', 'technique', 'volume'
                           typical_rpe_range VARCHAR(20), -- es. "8-10", "6-7"

                           is_active BOOLEAN DEFAULT true,
                           created_at TIMESTAMP DEFAULT NOW()
);

COMMENT ON TABLE set_types IS 'Catalogo tipologie di serie: cedimento, buffer, avvicinamento, rest-pause, drop set, cluster, etc.';

CREATE INDEX idx_set_types_code ON set_types(code);
CREATE INDEX idx_set_types_category ON set_types(category);

-- Seed data comuni
INSERT INTO set_types (code, name_i18n, description_i18n, category, typical_rpe_range) VALUES
                                                                                           ('failure',
                                                                                            '{"en": "Failure", "it": "Cedimento"}',
                                                                                            '{"en": "Set performed until muscular failure", "it": "Serie eseguita fino al cedimento muscolare"}',
                                                                                            'intensity', '10'),

                                                                                           ('buffer',
                                                                                            '{"en": "Buffer", "it": "Buffer"}',
                                                                                            '{"en": "Set with 2-3 reps left in reserve", "it": "Serie con 2-3 ripetizioni di riserva"}',
                                                                                            'intensity', '7-8'),

                                                                                           ('approach',
                                                                                            '{"en": "Near Failure", "it": "Avvicinamento"}',
                                                                                            '{"en": "Set with 1 rep left in reserve", "it": "Serie con 1 ripetizione di riserva"}',
                                                                                            'intensity', '9'),

                                                                                           ('warmup',
                                                                                            '{"en": "Warmup", "it": "Riscaldamento"}',
                                                                                            '{"en": "Preparatory set with light weight", "it": "Serie preparatoria con carico leggero"}',
                                                                                            'volume', '3-5'),

                                                                                           ('drop_set',
                                                                                            '{"en": "Drop Set", "it": "Serie a Scalare"}',
                                                                                            '{"en": "Continue set with reduced weight after failure", "it": "Continuazione serie con peso ridotto dopo cedimento"}',
                                                                                            'technique', '9-10'),

                                                                                           ('rest_pause',
                                                                                            '{"en": "Rest-Pause", "it": "Rest-Pause"}',
                                                                                            '{"en": "Brief rest periods during single set", "it": "Brevi pause durante la stessa serie"}',
                                                                                            'technique', '9-10'),

                                                                                           ('cluster',
                                                                                            '{"en": "Cluster Set", "it": "Serie a Cluster"}',
                                                                                            '{"en": "Multiple mini-sets with short rests", "it": "Mini-serie multiple con pause brevi"}',
                                                                                            'technique', '8-9'),

                                                                                           ('amrap',
                                                                                            '{"en": "AMRAP", "it": "Massime Ripetizioni"}',
                                                                                            '{"en": "As Many Reps As Possible", "it": "Massime ripetizioni possibili"}',
                                                                                            'volume', '9-10'),

                                                                                           ('tempo',
                                                                                            '{"en": "Tempo", "it": "Tempo Controllato"}',
                                                                                            '{"en": "Controlled tempo execution", "it": "Esecuzione con tempo controllato"}',
                                                                                            'technique', '7-8'),

                                                                                           ('eccentric',
                                                                                            '{"en": "Eccentric Focus", "it": "Focus Eccentrico"}',
                                                                                            '{"en": "Emphasized eccentric phase", "it": "Enfasi sulla fase eccentrica"}',
                                                                                            'technique', '7-9'),

                                                                                           ('isometric',
                                                                                            '{"en": "Isometric Hold", "it": "Tenuta Isometrica"}',
                                                                                            '{"en": "Static hold at specific position", "it": "Tenuta statica in posizione specifica"}',
                                                                                            'technique', '7-8'),

                                                                                           ('pyramid',
                                                                                            '{"en": "Pyramid", "it": "Piramidale"}',
                                                                                            '{"en": "Progressive weight increase/decrease", "it": "Aumento/diminuzione progressiva del peso"}',
                                                                                            'volume', '7-9'),

                                                                                           ('myo_reps',
                                                                                            '{"en": "Myo-Reps", "it": "Myo-Reps"}',
                                                                                            '{"en": "Activation set + mini-sets", "it": "Serie di attivazione + mini-serie"}',
                                                                                            'technique', '8-9');

-- ============================================================================
-- WORKOUT PLANS - CORE
-- ============================================================================

CREATE TABLE workout_plans (
                               id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                               title_i18n JSONB NOT NULL,
                               description_i18n JSONB,
                               notes_i18n JSONB,

                               created_by_user_id UUID NOT NULL, -- FK a users
                               plan_type VARCHAR(30) NOT NULL, -- 'template', 'active', 'archived'
                               difficulty_level VARCHAR(20),
                               duration_weeks INTEGER,
                               workouts_per_week INTEGER,

                               target_goal VARCHAR(50), -- 'hypertrophy', 'strength', 'endurance', 'power'

                               is_public BOOLEAN DEFAULT false,
                               is_featured BOOLEAN DEFAULT false,
                               is_active BOOLEAN DEFAULT true,

                               created_at TIMESTAMP DEFAULT NOW(),
                               updated_at TIMESTAMP DEFAULT NOW()
);

COMMENT ON TABLE workout_plans IS 'Schede di allenamento: template riutilizzabili o schede attive assegnate agli utenti';
COMMENT ON COLUMN workout_plans.plan_type IS 'template: modello riutilizzabile | active: scheda in uso | archived: storico';
COMMENT ON COLUMN workout_plans.target_goal IS 'Obiettivo principale della scheda';

CREATE INDEX idx_workout_plans_created_by ON workout_plans(created_by_user_id);
CREATE INDEX idx_workout_plans_type ON workout_plans(plan_type);
CREATE INDEX idx_workout_plans_public ON workout_plans(is_public) WHERE is_public = true;
CREATE INDEX idx_workout_plans_goal ON workout_plans(target_goal);

-- ============================================================================
-- PLAN TAGS
-- ============================================================================

CREATE TABLE workout_plan_tags (
                                   workout_plan_id UUID NOT NULL REFERENCES workout_plans(id) ON DELETE CASCADE,
                                   tag_id UUID NOT NULL REFERENCES tags(id) ON DELETE CASCADE,
                                   created_at TIMESTAMP DEFAULT NOW(),

                                   PRIMARY KEY (workout_plan_id, tag_id)
);

COMMENT ON TABLE workout_plan_tags IS 'Tag associati alle schede (ipertrofia, forza, fullbody, push-pull-legs, etc.)';

CREATE INDEX idx_workout_plan_tags_plan ON workout_plan_tags(workout_plan_id);
CREATE INDEX idx_workout_plan_tags_tag ON workout_plan_tags(tag_id);

-- ============================================================================
-- PLAN SHARES
-- ============================================================================

CREATE TABLE workout_plan_shares (
                                     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                     workout_plan_id UUID NOT NULL REFERENCES workout_plans(id) ON DELETE CASCADE,
                                     shared_with_user_id UUID NOT NULL, -- FK a users
                                     shared_by_user_id UUID NOT NULL, -- FK a users

                                     access_level VARCHAR(20) DEFAULT 'view', -- 'view', 'edit', 'own'
                                     is_active BOOLEAN DEFAULT true,

                                     shared_at TIMESTAMP DEFAULT NOW(),
                                     expires_at TIMESTAMP,

                                     UNIQUE(workout_plan_id, shared_with_user_id)
);

COMMENT ON TABLE workout_plan_shares IS 'Condivisione schede tra utenti (coach che assegna scheda a cliente, condivisione tra amici)';
COMMENT ON COLUMN workout_plan_shares.access_level IS 'view: solo visualizzazione | edit: può modificare | own: proprietario';

CREATE INDEX idx_workout_plan_shares_plan ON workout_plan_shares(workout_plan_id);
CREATE INDEX idx_workout_plan_shares_user ON workout_plan_shares(shared_with_user_id);

-- ============================================================================
-- PLAN STRUCTURE - WEEKS
-- ============================================================================

CREATE TABLE workout_plan_weeks (
                                    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                    workout_plan_id UUID NOT NULL REFERENCES workout_plans(id) ON DELETE CASCADE,
                                    week_number INTEGER NOT NULL,

                                    title_i18n JSONB,
                                    notes_i18n JSONB,

                                    deload_week BOOLEAN DEFAULT false,
                                    intensity_percentage INTEGER DEFAULT 100, -- % intensità rispetto al baseline
                                    volume_percentage INTEGER DEFAULT 100, -- % volume rispetto al baseline

                                    created_at TIMESTAMP DEFAULT NOW(),

                                    UNIQUE(workout_plan_id, week_number)
);

COMMENT ON TABLE workout_plan_weeks IS 'Struttura settimanale delle schede per periodizzazione (accumulo, intensificazione, deload)';
COMMENT ON COLUMN workout_plan_weeks.deload_week IS 'Settimana di scarico con volume/intensità ridotti';

CREATE INDEX idx_workout_plan_weeks_plan ON workout_plan_weeks(workout_plan_id);

-- ============================================================================
-- PLAN STRUCTURE - DAYS
-- ============================================================================

CREATE TABLE workout_plan_days (
                                   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                   workout_plan_week_id UUID NOT NULL REFERENCES workout_plan_weeks(id) ON DELETE CASCADE,
                                   day_number INTEGER NOT NULL, -- 1-7

                                   title_i18n JSONB NOT NULL,
                                   description_i18n JSONB,
                                   notes_i18n JSONB,

                                   is_rest_day BOOLEAN DEFAULT false,
                                   estimated_duration_minutes INTEGER,
                                   display_order INTEGER DEFAULT 0,

                                   focus_muscle_groups TEXT[], -- array di gruppi muscolari principali

                                   created_at TIMESTAMP DEFAULT NOW(),

                                   UNIQUE(workout_plan_week_id, day_number)
);

COMMENT ON TABLE workout_plan_days IS 'Giorni di allenamento specifici (es. "Petto e Tricipiti", "Giorno di Riposo")';
COMMENT ON COLUMN workout_plan_days.focus_muscle_groups IS 'Gruppi muscolari target del giorno (per filtri e visualizzazioni)';

CREATE INDEX idx_workout_plan_days_week ON workout_plan_days(workout_plan_week_id);

-- ============================================================================
-- EXERCISE GROUPS (Superset/Circuit)
-- ============================================================================

CREATE TABLE workout_exercise_groups (
                                         id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                         workout_plan_day_id UUID NOT NULL REFERENCES workout_plan_days(id) ON DELETE CASCADE,

                                         group_type VARCHAR(30) NOT NULL, -- 'single', 'superset', 'triset', 'giant_set', 'circuit'
                                         group_order INTEGER NOT NULL,

                                         title_i18n JSONB,
                                         notes_i18n JSONB,

                                         rest_between_exercises_seconds INTEGER DEFAULT 0,
                                         rest_after_group_seconds INTEGER DEFAULT 90,
                                         rounds INTEGER DEFAULT 1, -- per circuit

                                         is_antagonist_pair BOOLEAN DEFAULT false, -- superset agonista-antagonista

                                         created_at TIMESTAMP DEFAULT NOW(),

                                         UNIQUE(workout_plan_day_id, group_order)
);

COMMENT ON TABLE workout_exercise_groups IS 'Raggruppamenti di esercizi: singoli, superset, triset, giant set, circuit';
COMMENT ON COLUMN workout_exercise_groups.group_type IS 'single: esercizio isolato | superset: 2 esercizi | triset: 3 | giant_set: 4+ | circuit: circuito';
COMMENT ON COLUMN workout_exercise_groups.is_antagonist_pair IS 'Superset di gruppi muscolari antagonisti (es. bicipiti-tricipiti)';

CREATE INDEX idx_workout_exercise_groups_day ON workout_exercise_groups(workout_plan_day_id);

-- ============================================================================
-- PLAN EXERCISES
-- ============================================================================

CREATE TABLE workout_plan_exercises (
                                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                        workout_exercise_group_id UUID NOT NULL REFERENCES workout_exercise_groups(id) ON DELETE CASCADE,
                                        exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE RESTRICT,

                                        exercise_order INTEGER NOT NULL,

    -- Set configuration
                                        sets INTEGER,
                                        reps_min INTEGER,
                                        reps_max INTEGER,
                                        reps_type VARCHAR(30) DEFAULT 'fixed', -- 'fixed', 'range', 'amrap', 'time_based'

    -- Set type
                                        set_type_id UUID REFERENCES set_types(id),

    -- Weight/Load
                                        weight_kg DECIMAL(6,2),
                                        weight_percentage INTEGER, -- % of 1RM
                                        rpe_target INTEGER CHECK (rpe_target BETWEEN 1 AND 10),
                                        rir_target INTEGER CHECK (rir_target BETWEEN 0 AND 10),

    -- Tempo (formato: eccentric-pause-concentric-pause, es. "3010")
                                        tempo_eccentric INTEGER,
                                        tempo_bottom_pause INTEGER,
                                        tempo_concentric INTEGER,
                                        tempo_top_pause INTEGER,

    -- Rest
                                        rest_seconds INTEGER DEFAULT 90,

    -- Duration
                                        duration_seconds INTEGER,

    -- Special instructions
                                        notes_i18n JSONB,
                                        coaching_cues_i18n JSONB,

                                        is_warmup BOOLEAN DEFAULT false,
                                        is_cooldown BOOLEAN DEFAULT false,
                                        is_optional BOOLEAN DEFAULT false,

                                        created_at TIMESTAMP DEFAULT NOW(),
                                        updated_at TIMESTAMP DEFAULT NOW(),

                                        UNIQUE(workout_exercise_group_id, exercise_order)
);

COMMENT ON TABLE workout_plan_exercises IS 'Esercizi configurati nelle schede con parametri specifici (serie, reps, carico, tempo)';
COMMENT ON COLUMN workout_plan_exercises.reps_type IS 'fixed: numero fisso | range: range ripetizioni | amrap: massime possibili | time_based: durata temporale';
COMMENT ON COLUMN workout_plan_exercises.weight_percentage IS 'Percentuale del massimale (1RM) per auto-calcolo carico';
COMMENT ON COLUMN workout_plan_exercises.rpe_target IS 'Rate of Perceived Exertion target (scala 1-10)';
COMMENT ON COLUMN workout_plan_exercises.rir_target IS 'Reps In Reserve target (ripetizioni da lasciare in riserva)';
COMMENT ON COLUMN workout_plan_exercises.tempo_eccentric IS 'Secondi fase eccentrica (esempio: 3 in "3010")';

CREATE INDEX idx_workout_plan_exercises_group ON workout_plan_exercises(workout_exercise_group_id);
CREATE INDEX idx_workout_plan_exercises_exercise ON workout_plan_exercises(exercise_id);
CREATE INDEX idx_workout_plan_exercises_set_type ON workout_plan_exercises(set_type_id);

-- ============================================================================
-- ALTERNATIVE EXERCISES
-- ============================================================================

CREATE TABLE workout_exercise_alternatives (
                                               id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                               workout_plan_exercise_id UUID NOT NULL REFERENCES workout_plan_exercises(id) ON DELETE CASCADE,
                                               alternative_exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,

                                               reason_i18n JSONB,
                                               priority INTEGER DEFAULT 1,

                                               auto_adjust_parameters BOOLEAN DEFAULT true, -- mantieni stessi parametri o adatta

                                               created_at TIMESTAMP DEFAULT NOW(),

                                               UNIQUE(workout_plan_exercise_id, alternative_exercise_id)
);

COMMENT ON TABLE workout_exercise_alternatives IS 'Esercizi alternativi suggeriti (per limitazioni, preferenze, attrezzatura)';
COMMENT ON COLUMN workout_exercise_alternatives.priority IS 'Ordine di preferenza (1 = prima scelta alternativa)';
COMMENT ON COLUMN workout_exercise_alternatives.auto_adjust_parameters IS 'Se mantenere parametri originali o adattare alla sostituzione';

CREATE INDEX idx_workout_exercise_alternatives_plan_ex ON workout_exercise_alternatives(workout_plan_exercise_id);

-- ============================================================================
-- WORKOUT SESSIONS
-- ============================================================================

CREATE TABLE workout_sessions (
                                  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                  user_id UUID NOT NULL, -- FK a users
                                  workout_plan_id UUID REFERENCES workout_plans(id) ON DELETE SET NULL,
                                  workout_plan_day_id UUID REFERENCES workout_plan_days(id) ON DELETE SET NULL,

                                  session_date DATE NOT NULL,
                                  started_at TIMESTAMP,
                                  completed_at TIMESTAMP,

                                  status VARCHAR(30) DEFAULT 'planned', -- 'planned', 'in_progress', 'completed', 'skipped', 'cancelled'

                                  notes_i18n JSONB,
                                  rating INTEGER CHECK (rating BETWEEN 1 AND 5), -- soddisfazione allenamento
                                  perceived_difficulty INTEGER CHECK (perceived_difficulty BETWEEN 1 AND 10),

                                  total_volume_kg DECIMAL(12,2),
                                  total_reps INTEGER,
                                  total_sets INTEGER,
                                  duration_minutes INTEGER,

    -- Tracking automatico
                                  device_type VARCHAR(50), -- 'mobile', 'watch', 'web'
                                  location_type VARCHAR(30), -- 'gym', 'home', 'outdoor'

                                  created_at TIMESTAMP DEFAULT NOW(),
                                  updated_at TIMESTAMP DEFAULT NOW()
);

COMMENT ON TABLE workout_sessions IS 'Sessioni di allenamento effettive eseguite dagli utenti';
COMMENT ON COLUMN workout_sessions.status IS 'planned: da fare | in_progress: in corso | completed: completato | skipped: saltato | cancelled: annullato';
COMMENT ON COLUMN workout_sessions.perceived_difficulty IS 'Difficoltà percepita complessiva della sessione (1-10)';

CREATE INDEX idx_workout_sessions_user ON workout_sessions(user_id);
CREATE INDEX idx_workout_sessions_plan ON workout_sessions(workout_plan_id);
CREATE INDEX idx_workout_sessions_date ON workout_sessions(user_id, session_date DESC);
CREATE INDEX idx_workout_sessions_status ON workout_sessions(status);

-- ============================================================================
-- SESSION EXERCISE LOGS
-- ============================================================================

CREATE TABLE workout_session_exercise_logs (
                                               id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                               workout_session_id UUID NOT NULL REFERENCES workout_sessions(id) ON DELETE CASCADE,
                                               workout_plan_exercise_id UUID REFERENCES workout_plan_exercises(id) ON DELETE SET NULL,
                                               exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE RESTRICT,

                                               set_number INTEGER NOT NULL,

    -- Execution data
                                               reps INTEGER,
                                               weight_kg DECIMAL(6,2),
                                               distance_meters DECIMAL(8,2), -- per cardio
                                               duration_seconds INTEGER,

    -- Perceived metrics
                                               rpe INTEGER CHECK (rpe BETWEEN 1 AND 10),
                                               rir INTEGER CHECK (rir BETWEEN 0 AND 10),

    -- Set type used
                                               set_type_id UUID REFERENCES set_types(id),

    -- Quality
                                               completed BOOLEAN DEFAULT true,
                                               form_rating INTEGER CHECK (form_rating BETWEEN 1 AND 5),
                                               tempo_adherence INTEGER CHECK (tempo_adherence BETWEEN 1 AND 5), -- quanto rispettato il tempo

    -- Media
                                               notes TEXT,
                                               video_url VARCHAR(500),

    -- Tracking
                                               logged_at TIMESTAMP DEFAULT NOW(),
                                               created_at TIMESTAMP DEFAULT NOW(),

                                               UNIQUE(workout_session_id, workout_plan_exercise_id, set_number)
);

COMMENT ON TABLE workout_session_exercise_logs IS 'Log dettagliato di ogni singola serie eseguita durante le sessioni';
COMMENT ON COLUMN workout_session_exercise_logs.form_rating IS 'Valutazione esecuzione tecnica (1=pessima, 5=perfetta)';
COMMENT ON COLUMN workout_session_exercise_logs.tempo_adherence IS 'Aderenza al tempo prescritto (1=non rispettato, 5=perfetto)';

CREATE INDEX idx_session_exercise_logs_session ON workout_session_exercise_logs(workout_session_id);
CREATE INDEX idx_session_exercise_logs_exercise ON workout_session_exercise_logs(exercise_id);
CREATE INDEX idx_session_exercise_logs_set_type ON workout_session_exercise_logs(set_type_id);

-- ============================================================================
-- SESSION CARDIO LOGS
-- ============================================================================

CREATE TABLE workout_session_cardio_logs (
                                             id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                             workout_session_id UUID NOT NULL REFERENCES workout_sessions(id) ON DELETE CASCADE,

                                             cardio_type VARCHAR(50) NOT NULL, -- 'running', 'cycling', 'rowing', 'swimming', 'elliptical'

                                             duration_minutes INTEGER,
                                             distance_meters DECIMAL(10,2),
                                             average_heart_rate INTEGER,
                                             max_heart_rate INTEGER,
                                             calories_burned INTEGER,

                                             intensity_zone VARCHAR(20), -- 'recovery', 'aerobic', 'threshold', 'vo2max', 'anaerobic'

                                             notes TEXT,

                                             created_at TIMESTAMP DEFAULT NOW()
);

COMMENT ON TABLE workout_session_cardio_logs IS 'Log specifico per attività cardiovascolari con metriche dedicate';
COMMENT ON COLUMN workout_session_cardio_logs.intensity_zone IS 'Zona di intensità cardiovascolare';

CREATE INDEX idx_session_cardio_logs_session ON workout_session_cardio_logs(workout_session_id);

-- ============================================================================
-- PLAN METRICS
-- ============================================================================

CREATE TABLE workout_plan_metrics (
                                      workout_plan_id UUID PRIMARY KEY REFERENCES workout_plans(id) ON DELETE CASCADE,

                                      total_uses INTEGER DEFAULT 0,
                                      active_users INTEGER DEFAULT 0,
                                      completed_sessions INTEGER DEFAULT 0,
                                      average_completion_rate DECIMAL(5,2),
                                      average_rating DECIMAL(3,2),
                                      total_ratings INTEGER DEFAULT 0,

                                      last_used_at TIMESTAMP,

                                      created_at TIMESTAMP DEFAULT NOW(),
                                      updated_at TIMESTAMP DEFAULT NOW()
);

COMMENT ON TABLE workout_plan_metrics IS 'Metriche aggregate per popolarità e performance delle schede';
COMMENT ON COLUMN workout_plan_metrics.average_completion_rate IS 'Percentuale media di completamento delle sessioni';

-- ============================================================================
-- USER SESSION ANALYTICS
-- ============================================================================

CREATE TABLE user_workout_analytics (
                                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                        user_id UUID NOT NULL, -- FK a users
                                        analysis_date DATE NOT NULL,

    -- Volume metrics
                                        total_volume_kg DECIMAL(12,2),
                                        total_reps INTEGER,
                                        total_sets INTEGER,
                                        sessions_completed INTEGER,

    -- Time metrics
                                        total_training_minutes INTEGER,
                                        average_session_duration INTEGER,

    -- Intensity metrics
                                        average_rpe DECIMAL(3,2),
                                        average_intensity DECIMAL(5,2), -- % 1RM medio

    -- Consistency
                                        scheduled_sessions INTEGER,
                                        adherence_rate DECIMAL(5,2), -- % sessioni completate vs programmate

    -- PRs
                                        personal_records_count INTEGER DEFAULT 0,

                                        created_at TIMESTAMP DEFAULT NOW(),

                                        UNIQUE(user_id, analysis_date)
);

COMMENT ON TABLE user_workout_analytics IS 'Analytics giornaliere aggregate per utente con metriche di volume, intensità e consistenza';
COMMENT ON COLUMN user_workout_analytics.adherence_rate IS 'Percentuale aderenza al programma (sessioni fatte / sessioni programmate)';

CREATE INDEX idx_user_workout_analytics_user ON user_workout_analytics(user_id);
CREATE INDEX idx_user_workout_analytics_date ON user_workout_analytics(analysis_date DESC);

-- ============================================================================
-- PERSONAL RECORDS TRACKING
-- ============================================================================

CREATE TABLE user_personal_records (
                                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                       user_id UUID NOT NULL, -- FK a users
                                       exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE RESTRICT,

                                       record_type VARCHAR(30) NOT NULL, -- '1rm', 'volume', 'reps', 'endurance'

                                       value_kg DECIMAL(8,2), -- per 1RM, peso massimo
                                       value_reps INTEGER, -- per record ripetizioni
                                       value_seconds INTEGER, -- per record durata

                                       achieved_at TIMESTAMP NOT NULL,
                                       workout_session_id UUID REFERENCES workout_sessions(id) ON DELETE SET NULL,

                                       previous_record_id UUID REFERENCES user_personal_records(id), -- record precedente battuto
                                       improvement_percentage DECIMAL(6,2),

                                       is_current_record BOOLEAN DEFAULT true,

                                       notes TEXT,

                                       created_at TIMESTAMP DEFAULT NOW()
);

COMMENT ON TABLE user_personal_records IS 'Storico record personali utenti per esercizio (1RM, volume, ripetizioni, durata)';
COMMENT ON COLUMN user_personal_records.record_type IS '1rm: massimale | volume: volume totale | reps: max ripetizioni | endurance: durata massima';
COMMENT ON COLUMN user_personal_records.is_current_record IS 'Flag per identificare il record corrente (ultimo ottenuto)';

CREATE INDEX idx_user_prs_user ON user_personal_records(user_id);
CREATE INDEX idx_user_prs_exercise ON user_personal_records(exercise_id);
CREATE INDEX idx_user_prs_current ON user_personal_records(user_id, exercise_id, is_current_record) WHERE is_current_record = true;

-- ============================================================================
-- PLAN PROGRESSION RULES
-- ============================================================================

CREATE TABLE workout_plan_progression_rules (
                                                id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                                workout_plan_id UUID NOT NULL REFERENCES workout_plans(id) ON DELETE CASCADE,

                                                rule_type VARCHAR(50) NOT NULL, -- 'linear', 'double_progression', 'wave', 'step_loading'
                                                progression_frequency VARCHAR(30) NOT NULL, -- 'weekly', 'session', 'when_target_met'

                                                applies_to_exercises JSONB, -- array exercise_id o null per tutti

    -- Weight progression
                                                weight_increase_kg DECIMAL(4,2),
                                                weight_increase_percentage DECIMAL(4,2),

    -- Reps progression
                                                reps_increase INTEGER,

    -- Set progression
                                                sets_increase INTEGER,

    -- Trigger conditions
                                                trigger_condition JSONB, -- {"type": "reps_target_met", "min_reps": 12, "sets": 3}

    -- Deload rules
                                                deload_every_n_weeks INTEGER,
                                                deload_percentage DECIMAL(4,2),

                                                is_active BOOLEAN DEFAULT true,
                                                created_at TIMESTAMP DEFAULT NOW()
);

COMMENT ON TABLE workout_plan_progression_rules IS 'Regole di progressione automatica del carico/volume nelle schede';
COMMENT ON COLUMN workout_plan_progression_rules.rule_type IS 'linear: incremento fisso | double_progression: reps poi peso | wave: ondulato | step_loading: gradini';
COMMENT ON COLUMN workout_plan_progression_rules.trigger_condition IS 'Condizioni JSON per attivare la progressione';

CREATE INDEX idx_progression_rules_plan ON workout_plan_progression_rules(workout_plan_id);

-- ============================================================================
-- USER EXERCISE PREFERENCES
-- ============================================================================

CREATE TABLE user_exercise_preferences (
                                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                           user_id UUID NOT NULL, -- FK a users
                                           exercise_id UUID NOT NULL REFERENCES exercises(id) ON DELETE CASCADE,

                                           preference_type VARCHAR(30) NOT NULL, -- 'favorite', 'dislike', 'avoid', 'substitution_preferred'

                                           reason TEXT,
                                           notes TEXT,

                                           created_at TIMESTAMP DEFAULT NOW(),

                                           UNIQUE(user_id, exercise_id, preference_type)
);

COMMENT ON TABLE user_exercise_preferences IS 'Preferenze utente su esercizi specifici (preferiti, da evitare, sostituzioni)';
COMMENT ON COLUMN user_exercise_preferences.preference_type IS 'favorite: preferito | dislike: non gradito | avoid: da evitare | substitution_preferred: sostituire con altro';

CREATE INDEX idx_user_exercise_prefs_user ON user_exercise_preferences(user_id);
CREATE INDEX idx_user_exercise_prefs_exercise ON user_exercise_preferences(exercise_id);

-- ============================================================================
-- WORKOUT TEMPLATES LIBRARY
-- ============================================================================

CREATE TABLE workout_template_library (
                                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                          workout_plan_id UUID NOT NULL REFERENCES workout_plans(id) ON DELETE CASCADE,

                                          category VARCHAR(50) NOT NULL, -- 'beginner', 'intermediate', 'advanced', 'sport_specific'
                                          subcategory VARCHAR(50),

                                          author_name VARCHAR(255),
                                          author_credentials TEXT,

                                          popularity_score INTEGER DEFAULT 0,
                                          times_used INTEGER DEFAULT 0,

                                          is_verified BOOLEAN DEFAULT false, -- verificato da Coachly
                                          is_premium BOOLEAN DEFAULT false,

                                          price_cents INTEGER DEFAULT 0, -- 0 = gratis

                                          created_at TIMESTAMP DEFAULT NOW()
);

COMMENT ON TABLE workout_template_library IS 'Libreria pubblica di template di allenamento preconfigurati e verificati';
COMMENT ON COLUMN workout_template_library.is_verified IS 'Template verificato/approvato dal team Coachly';
COMMENT ON COLUMN workout_template_library.is_premium IS 'Template premium a pagamento';

CREATE INDEX idx_template_library_category ON workout_template_library(category);
CREATE INDEX idx_template_library_popularity ON workout_template_library(popularity_score DESC);