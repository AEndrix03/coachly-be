package it.coachly.api.enums.tag;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TagTypeEnum implements IEnum {
    SKILL_LEVEL("SKL"),
    LOCATION("LOC"),
    EQUIPMENT_REQUIREMENT("EQP"),
    CHARACTERISTIC("CHR"),
    TRAINING_GOAL("TRG"),
    BODY_FOCUS("BDY");

    private final String symbol;

    @Converter(autoApply = true)
    public static class TagTypeEnumConverter extends AbstractEnumConverter<TagTypeEnum> {
        public TagTypeEnumConverter() {
            super(TagTypeEnum.class);
        }
    }
}