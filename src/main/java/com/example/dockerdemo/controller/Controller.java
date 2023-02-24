package com.example.dockerdemo.controller;

import com.example.dockerdemo.DTO.Request;
import com.example.dockerdemo.DTO.Response;
import com.example.dockerdemo.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {
    @Autowired
    RegisterService registerService;

    /**
     * @param request
     * @return
     * @description Register a student
     */
    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody Request request) {
        log.info("Controller.register Method accessed.");
        Response response = new Response();
        response = registerService.register(request);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
