package io.swagger.api;

import io.swagger.DataBase.models.Student;
import io.swagger.DataBase.models.StudentDTO;
import io.swagger.DataBase.servises.StudentService;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.configuration.MapperUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-17T13:54:44.727808364Z[GMT]")
@RestController
public class StudentsApiController implements StudentsApi {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ModelMapper modelMapper;
    private static final Logger log = LoggerFactory.getLogger(StudentsApiController.class);

    private final ObjectMapper objectMapper;



    private final HttpServletRequest request;
    private StudentDTO convertToUserDto(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }
    @org.springframework.beans.factory.annotation.Autowired
    public StudentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<StudentDTO>> studentsGet() {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.status(200).body(MapperUtil.convertList(students, this::convertToUserDto));
    }

    public ResponseEntity<StudentDTO> studentsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody StudentDTO body) {
        Student student = modelMapper.map(body, Student.class);
        studentService.insert(student);
        return ResponseEntity.status(201).body(body);
    }

    public ResponseEntity<String> studentsStudentNameDelete(@Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return (studentService.remove(id)) ?
                ResponseEntity.status(200).body(" { \"status\":\"deleted\"}") :
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<StudentDTO> studentsStudentNameGet(@Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("id") Long id)
    {
        Optional<Student> student = studentService.find(id);
        return (student.isPresent()) ?
                ResponseEntity.status(200).body(convertToUserDto(student.get())) :
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<StudentDTO> studentsStudentNamePut(@Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("id") Long id, @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody StudentDTO body) {

        Optional<Student> student = studentService.find(id);
        if (student.isPresent()) {
            studentService.edit(modelMapper.map(body, Student.class));
            return ResponseEntity.status(200).body(body);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
