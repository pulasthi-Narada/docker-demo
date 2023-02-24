package com.example.dockerdemo.service.impl;


import com.example.dockerdemo.DTO.Request;
import com.example.dockerdemo.DTO.Response;
import com.example.dockerdemo.entity.Student;
import com.example.dockerdemo.repository.StudentRepository;
import com.example.dockerdemo.service.RegisterService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    StudentRepository studentRepository;

    /**
     * @param request
     * @return Response
     * @description register a student
     */
    @Override
    public Response register(Request request) {
        log.info("RegisterServiceImpl.register Method accessed.");
        Response response = new Response();
        Student student = new Student();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            student =objectMapper.convertValue(request,Student.class);
            studentRepository.save(student);
            response.setMessage(HttpStatus.CREATED.toString());
            response.setStatus(HttpStatus.CREATED.value());
        } catch (Exception e) {
            log.error("Error in RegisterServiceImpl.register Method. -> {}",e.getMessage());
            response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        }
        return response;
    }
}
