package it.coachly.api.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JsonMapper {

    private final ObjectMapper objectMapper;

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