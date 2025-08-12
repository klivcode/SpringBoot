package com.kliv.spring.springprof.controller;

import com.kliv.spring.springprof.dto.StudentDto;
import com.kliv.spring.springprof.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
    @RequestMapping("/student")
public class StudentController {
        List<StudentDto> students= new ArrayList<>();

        @PostMapping
    public ResponseEntity<ApiResponse> addStudent(@RequestBody StudentDto studentDto){
                ApiResponse response = new ApiResponse();
            if(studentDto !=null){
                students.add(studentDto);
                response.setData(studentDto);
                response.setMessage("Added Successfully");
                response.setSuccess(Boolean.TRUE);
                return ResponseEntity.ok(response);
            }

            response.setMessage("Added Failed");
            response.setSuccess(Boolean.FALSE);
            return ResponseEntity.ok(response);

    }
}
