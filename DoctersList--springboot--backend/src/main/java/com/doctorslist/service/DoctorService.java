package com.doctorslist.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.doctorslist.dto.DoctorRequest;
import com.doctorslist.entity.Doctor;

public interface DoctorService {
	
	 Doctor addDoctor(DoctorRequest request);
	 Page<Doctor> listDoctors(Map<String, String> filters, int page, int size);

}
