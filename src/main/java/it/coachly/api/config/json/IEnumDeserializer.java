package it.coachly.api.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import it.coachly.api.util.enums.IEnum;

import java.io.IOException;

public class IEnumDeserializer<T extends Enum<T> & IEnum> extends JsonDeserializer<T> {

    private final Class<T> enumClass;

    public IEnumDeserializer(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String symbol = p.getText();
        return IEnum.decode(enumClass, symbol);
    }
}