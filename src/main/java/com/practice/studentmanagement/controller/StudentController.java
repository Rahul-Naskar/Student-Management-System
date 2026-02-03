package com.practice.studentmanagement.controller;

import com.practice.studentmanagement.dto.StudentDto;
import com.practice.studentmanagement.entity.Student;
import com.practice.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class StudentController
{
    private final StudentService studentService;

    @PostMapping("/save")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto)
    {
        return studentService.save(studentDto);
    }

    @GetMapping("/fetchAll")
    public List<StudentDto> fetchAll()
    {
       return studentService.getAll();
    }

    @GetMapping("/findById/{id}")
    public StudentDto getById(@PathVariable long id)
    {
        return studentService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable long id)
    {
        return studentService.deleteById(id);
    }

    @PatchMapping("/smallUpdate/{id}")
    public StudentDto patchUpdate(@PathVariable long id, @RequestBody StudentDto studentDto)
    {
        return studentService.updatePatch(id, studentDto);
    }

    @PutMapping("/bigUpdate/{id}")
    public StudentDto putUpdate(@PathVariable long id, @RequestBody StudentDto studentDto)
    {
        return studentService.putUpdate(id,studentDto);
    }

}
