package com.ns.demo.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ns.demo.model.Student;

@Service
@CacheConfig(cacheNames = { "student" })
public class StudentServiceImpl implements StudentService {

	@Override
	@Cacheable
	public Student getStudentById(String id) {
		return getStudent(id);
	}

	private Student getStudent(String id) {
		return new Student(id, String.format("studentname%s", id), String.format("student%s@gmail.com", id));
	}

}
