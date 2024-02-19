package com.angularcrud.controller;

import com.angularcrud.entity.Student;
import com.angularcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateById(@PathVariable Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
