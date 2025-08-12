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


        // PathVaribale
        // RequestParam
        @GetMapping("/firstName/{firstName}/lastName/{lastName}")
    public ResponseEntity<ApiResponse> findStudentByFirstName(@PathVariable("firstName") String firstName,
                                                              @PathVariable("lastName") String lastName
                                                              )
        {
            ApiResponse response = new ApiResponse();
            response.setData(firstName+lastName);
            response.setMessage("Successfully Find Student by First Name");
            response.setSuccess(Boolean.TRUE);
            return ResponseEntity.ok(response);

        }


    @PostMapping("/doc")
    public ResponseEntity<ApiResponse>doc(@ModelAttribute StudentDto studentDto){
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
