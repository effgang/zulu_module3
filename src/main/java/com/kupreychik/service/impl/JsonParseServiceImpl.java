package com.kupreychik.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kupreychik.exception.JsonParseException;
import com.kupreychik.service.JsonParseService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class JsonParseServiceImpl implements JsonParseService {

    private final ObjectMapper objectMapper;

    public JsonParseServiceImpl() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String writeToJson(Object object) throws JsonParseException {
        try {
            log.info("Trying to convert object {} to string", object);
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Cannot parse object to string");
            throw new JsonParseException();
        }
    }

    @Override
    public Object readObject(InputStream json, Class object) throws JsonParseException {
        try {
            log.info("Trying to json {} to object", object);
            return objectMapper.readValue(json, object);
        } catch (IOException e) {
            log.error("Cannot parse string to object");
            throw new JsonParseException();
        }
    }
}
