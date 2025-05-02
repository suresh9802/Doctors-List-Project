package com.doctorslist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctorslist.dto.DoctorRequest;
import com.doctorslist.entity.Doctor;
import com.doctorslist.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping
    public Doctor addDoctor(@RequestBody DoctorRequest request) {
        return doctorService.addDoctor(request);
	}
	
	 @GetMapping
	    public Page<Doctor> listDoctors(
	            @RequestParam Map<String, String> filters,
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        return doctorService.listDoctors(filters, page, size);
	    }
}
