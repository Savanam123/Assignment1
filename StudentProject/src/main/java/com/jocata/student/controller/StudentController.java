package com.jocata.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.student.entity.Student;
import com.jocata.student.request.StudentRequest;
import com.jocata.student.response.StudentDelete;
import com.jocata.student.response.StudentResponse;
import com.jocata.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<?> saveStudent(@RequestBody StudentRequest request ){
		
		Student studentDetails=new Student();
		studentDetails.setStuName(request.getStuName());
		studentDetails.setStuLname(request.getStuLname());
		studentDetails.setStuCourse(request.getStuCourse());
		studentDetails.setStuEmail(request.getStuEmail());
		studentDetails.setStuMobile(request.getStuMobile());
		studentDetails.setStuEntryDate(request.getStuEntryDate());
		
		studentService.save(studentDetails);
		StudentResponse response=new StudentResponse();
		response.setStuId(studentDetails.getStuId());
		response.setStuName(studentDetails.getStuName());
		response.setStuLname(studentDetails.getStuLname());
		response.setStuCourse(studentDetails.getStuCourse());
		response.setStuEmail(studentDetails.getStuEmail());
		response.setStuMobile(studentDetails.getStuMobile());
		response.setStuEntryDate(studentDetails.getStuEntryDate());
		response.setMessage("Student Details Saved Successfully "+studentDetails.getStuId());
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteStudent")
	public ResponseEntity<?> deleteStudent(@RequestBody StudentRequest request){
		
		Student student=new Student();
		student.setStuId(request.getStuId());
		
		studentService.delete(request.getStuId());
		
		StudentDelete delete=new StudentDelete();
		delete.setStuId(student.getStuId());
		delete.setMessage("Record Deleted Successfully "+student.getStuId());
		
		return new  ResponseEntity<>(delete,HttpStatus.OK);
	}
	@PutMapping("/updateStudent")
	public ResponseEntity<?> updateStudent(@RequestBody StudentRequest request){
		Student studentDetails=new Student();
		studentDetails.setStuId(request.getStuId());
		studentDetails.setStuName(request.getStuName());
		studentDetails.setStuLname(request.getStuLname());
		studentDetails.setStuCourse(request.getStuCourse());
		studentDetails.setStuMobile(request.getStuMobile());
		studentDetails.setStuEmail(request.getStuEmail());
		studentDetails.setStuEntryDate(request.getStuEntryDate());
		
		studentService.update(studentDetails);
		
		StudentResponse response=new StudentResponse();
		response.setStuId(studentDetails.getStuId());
		response.setStuName(studentDetails.getStuName());
		response.setStuLname(studentDetails.getStuLname());
		response.setStuCourse(studentDetails.getStuCourse());
		response.setStuMobile(studentDetails.getStuMobile());
		response.setStuEmail(studentDetails.getStuEmail());
		response.setStuEntryDate(studentDetails.getStuEntryDate());
		response.setMessage("Successfully Update" +studentDetails.getStuId());
		
		return new  ResponseEntity<>(response, HttpStatus.OK);
	}

}
