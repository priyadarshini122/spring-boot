/*
 *
 * You can use the following import statemets
 *
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */
package com.example.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.school.model.Student;
import com.example.school.service.StudentH2Service;

@RestController
public class StudentController {
    @Autowired
    private StudentH2Service studentService;

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMappping("/students/(studentId)")
    public Student getStudentById(@PathVariable("studentId") int studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/students/bulk")
    public String addMultipleStudents(@RequestBody ArrayList<Student> studentsList) {
        return studentService.addMultipleStudents(studentsList);
    }

    @GetMapping("/students(studentId)")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    @GetMapping("/students/(studentId)")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
    }
}
