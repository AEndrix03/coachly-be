package it.coachly.api.config.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import it.coachly.api.enums.DifficultyLevelEnum;
import it.coachly.api.enums.equipment.EquipmentCategoryEnum;
import it.coachly.api.enums.equipment.EquipmentTypeEnum;
import it.coachly.api.enums.exercise.*;
import it.coachly.api.enums.instruction.InstructionTypeEnum;
import it.coachly.api.enums.media.MediaPurposeEnum;
import it.coachly.api.enums.media.MediaTypeEnum;
import it.coachly.api.enums.media.ViewAngleEnum;
import it.coachly.api.enums.muscle.InvolvementLevelEnum;
import it.coachly.api.enums.muscle.MuscleGroupEnum;
import it.coachly.api.enums.muscle.MuscleSubgroupEnum;
import it.coachly.api.enums.safety.ContraindicationTypeEnum;
import it.coachly.api.enums.safety.RiskLevelEnum;
import it.coachly.api.enums.tag.TagTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonMapper {

    private final ObjectMapper objectMapper;

    @Autowired
    public JsonMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper.copy();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(DifficultyLevelEnum.class, new IEnumDeserializer<>(DifficultyLevelEnum.class));
        module.addDeserializer(MechanicsTypeEnum.class, new IEnumDeserializer<>(MechanicsTypeEnum.class));
        module.addDeserializer(ForceTypeEnum.class, new IEnumDeserializer<>(ForceTypeEnum.class));
        module.addDeserializer(MovementPlaneEnum.class, new IEnumDeserializer<>(MovementPlaneEnum.class));
        module.addDeserializer(MovementPatternEnum.class, new IEnumDeserializer<>(MovementPatternEnum.class));
        module.addDeserializer(PowerGenerationLevelEnum.class, new IEnumDeserializer<>(PowerGenerationLevelEnum.class));
        module.addDeserializer(InstructionTypeEnum.class, new IEnumDeserializer<>(InstructionTypeEnum.class));
        module.addDeserializer(VariationTypeEnum.class, new IEnumDeserializer<>(VariationTypeEnum.class));
        module.addDeserializer(MediaTypeEnum.class, new IEnumDeserializer<>(MediaTypeEnum.class));
        module.addDeserializer(MediaPurposeEnum.class, new IEnumDeserializer<>(MediaPurposeEnum.class));
        module.addDeserializer(ViewAngleEnum.class, new IEnumDeserializer<>(ViewAngleEnum.class));
        module.addDeserializer(RiskLevelEnum.class, new IEnumDeserializer<>(RiskLevelEnum.class));
        module.addDeserializer(ContraindicationTypeEnum.class, new IEnumDeserializer<>(ContraindicationTypeEnum.class));
        module.addDeserializer(MuscleGroupEnum.class, new IEnumDeserializer<>(MuscleGroupEnum.class));
        module.addDeserializer(MuscleSubgroupEnum.class, new IEnumDeserializer<>(MuscleSubgroupEnum.class));
        module.addDeserializer(InvolvementLevelEnum.class, new IEnumDeserializer<>(InvolvementLevelEnum.class));
        module.addDeserializer(EquipmentCategoryEnum.class, new IEnumDeserializer<>(EquipmentCategoryEnum.class));
        module.addDeserializer(EquipmentTypeEnum.class, new IEnumDeserializer<>(EquipmentTypeEnum.class));
        module.addDeserializer(TagTypeEnum.class, new IEnumDeserializer<>(TagTypeEnum.class));

        this.objectMapper.registerModule(module);
    }

    public <T> T parse(Object jsonObj, TypeReference<T> typeRef) {
        if (jsonObj == null) return null;
        try {
            String json = jsonObj instanceof String ? (String) jsonObj
                    : objectMapper.writeValueAsString(jsonObj);
            return objectMapper.readValue(json, typeRef);
        } catch (Exception e) {
            throw new RuntimeException("JSON parse error", e);
        }
    }

    public <T> T parse(Object jsonObj, Class<T> clazz) {
        if (jsonObj == null) return null;
        try {
            String json = jsonObj instanceof String ? (String) jsonObj
                    : objectMapper.writeValueAsString(jsonObj);
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("JSON parse error", e);
        }
    }

    public <T> List<T> parseList(Object jsonObj, Class<T> clazz) {
        if (jsonObj == null) return List.of();
        try {
            String json = jsonObj instanceof String ? (String) jsonObj
                    : objectMapper.writeValueAsString(jsonObj);
            return objectMapper.readValue(json,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            throw new RuntimeException("JSON parse error", e);
        }
    }
}