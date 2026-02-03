package com.practice.studentmanagement.service;

import com.practice.studentmanagement.dto.StudentDto;
import com.practice.studentmanagement.entity.Student;
import com.practice.studentmanagement.exception.CustomException;
import com.practice.studentmanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentService
{
    private final StudentRepository studentRepository;


    public StudentDto save(StudentDto studentDto)
    {
        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setName(studentDto.getName());

        studentRepository.save(student);
        return studentDto;
    }

    public List<StudentDto> getAll()
    {
        List<StudentDto> studentsDto = studentRepository.findAll().
                                        stream().map(student -> new StudentDto
                                                                                    (student.getName(),student.getEmail())).toList();
        return studentsDto;
    }

    public StudentDto getById(long id)
    {
        Student student = studentRepository.findById(id).orElseThrow(()->new CustomException("student not found by id " + id));
        return new StudentDto(student.getName(), student.getEmail());
    }

    public String deleteById(long id)
    {
        Student student = studentRepository.findById(id).orElseThrow(()-> new CustomException("Id " + id + " is not present in Data Base"));
        studentRepository.delete(student);
        return "Deleted Successfully";
    }

    // for patch(small update) -> where we will check first if the data is not null or not
    public StudentDto updatePatch(long id, StudentDto studentDto)
    {
        Student student = studentRepository.findById(id).orElseThrow(()-> new CustomException(id + " Id not found"));
        if (studentDto.getName() != null)
        {
            student.setName(studentDto.getName());
        }
        if (studentDto.getEmail() != null)
        {
            student.setEmail(studentDto.getEmail());
        }
        Student student1 = studentRepository.save(student);

        StudentDto studentDto1 = new StudentDto();
        studentDto1.setName(student1.getName());
        studentDto1.setEmail(student1.getEmail());

        return studentDto1;
    }

    // for put(big update) -> where we will not check that the data is present or not
    public StudentDto putUpdate(long id, StudentDto studentDto)
    {
        Student student = studentRepository.findById(id).orElseThrow(()-> new CustomException(id + " Id not found"));

        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());

        Student student1 = studentRepository.save(student);

        StudentDto studentDto1 = new StudentDto();
        studentDto1.setName(student1.getName());
        studentDto1.setEmail(student1.getEmail());

        return studentDto1;
    }
}
