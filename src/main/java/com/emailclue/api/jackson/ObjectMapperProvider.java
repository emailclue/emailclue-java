package com.emailclue.api.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_COMMENTS;
import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES;
import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_YAML_COMMENTS;
import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;
import static com.fasterxml.jackson.databind.SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_EMPTY_JSON_ARRAYS;

@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public ObjectMapperProvider() {
        objectMapper = createDefaultMapper();
    }

    @Override
    public ObjectMapper getContext(final Class<?> type) {
        return objectMapper;
    }

    private static ObjectMapper createDefaultMapper() {
        return new ObjectMapper()
                .setSerializationInclusion(NON_NULL)
                .enable(INDENT_OUTPUT)
                .enable(ALLOW_COMMENTS)
                .enable(ALLOW_SINGLE_QUOTES)
                .enable(ALLOW_YAML_COMMENTS)
                .enable(ORDER_MAP_ENTRIES_BY_KEYS)
                .enable(WRITE_EMPTY_JSON_ARRAYS);
    }

}