package com.example.dockerdemo.service;


import com.example.dockerdemo.DTO.Request;
import com.example.dockerdemo.DTO.Response;

public interface RegisterService {
    /**
     *
     * @param request
     * @return Response
     */
    Response register(Request request);
}
