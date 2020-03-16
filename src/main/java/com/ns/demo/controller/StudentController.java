package com.ns.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ns.demo.model.Student;
import com.ns.demo.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/{id}", produces = "application/json")
	public Student getStudentById(@PathVariable String id) {
		return studentService.getStudentById(id);
	}

}
