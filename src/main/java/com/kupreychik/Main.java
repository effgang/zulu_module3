package com.kupreychik;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kupreychik.controller.StudentController;
import com.kupreychik.mapper.StudentMapper;
import com.kupreychik.repository.StudentRepository;
import com.kupreychik.service.JsonParseService;
import com.kupreychik.service.StudentService;
import com.kupreychik.service.impl.JsonParseServiceImpl;
import com.kupreychik.service.impl.StudentServiceImpl;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import static com.kupreychik.consts.WebConsts.STUDENTS_URL;

public class Main {


    public static void main(String[] args) {

        JsonParseService jsonParseService = new JsonParseServiceImpl();

        StudentMapper studentMapper = StudentMapper.INSTANCE;
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentServiceImpl(studentRepository, jsonParseService, studentMapper);
        StudentController studentController = new StudentController(studentService, jsonParseService);

        HttpServer server;
        try {
            System.out.println("Service start");
            server = HttpServer.create();
            server.bind(new InetSocketAddress(8080), 0);
        } catch (IOException ex) {
            //LOGGER.error("Server can't start! Reason: {}", ex.getMessage(), ex);
            return;
        }

        server.createContext(STUDENTS_URL, studentController);

        server.start();
    }
}
