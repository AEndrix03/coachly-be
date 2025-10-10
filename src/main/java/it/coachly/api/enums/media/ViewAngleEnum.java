package it.coachly.api.enums.media;

import it.coachly.api.util.enums.AbstractEnumConverter;
import it.coachly.api.util.enums.IEnum;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ViewAngleEnum implements IEnum {
    FRONT("FRT"),
    SIDE("SID"),
    BACK("BCK"),
    OVERHEAD("OVH"),
    DIAGONAL("DIA");

    private final String symbol;

    @Converter(autoApply = true)
    public static class ViewAngleEnumConverter extends AbstractEnumConverter<ViewAngleEnum> {
        public ViewAngleEnumConverter() {
            super(ViewAngleEnum.class);
        }
    }
}