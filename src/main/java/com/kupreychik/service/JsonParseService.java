package com.kupreychik.service;

import com.kupreychik.exception.JsonParseException;

import java.io.InputStream;

public interface JsonParseService {

    String writeToJson(Object object) throws JsonParseException;

    Object readObject(InputStream json, Class object) throws JsonParseException;
}
