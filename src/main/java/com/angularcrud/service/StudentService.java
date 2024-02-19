package com.angularcrud.service;

import com.angularcrud.entity.Student;
import com.angularcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).get();
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAddress(student.getAddress());
        return studentRepository.save(existingStudent);
    }
}
