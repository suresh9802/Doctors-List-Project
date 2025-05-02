package com.doctorslist.serviceimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import com.doctorslist.dto.DoctorRequest;
import com.doctorslist.entity.Doctor;
import com.doctorslist.repository.DoctorRepository;
import com.doctorslist.service.DoctorService;
import com.doctorslist.specification.DoctorSpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(DoctorRequest req) {
	    Doctor doctor = Doctor.builder()
	            .name(req.getName())
	            .gender(req.getGender())
	            .specialty(req.getSpecialty())
	            .experience(req.getExperience())
	            .fee(req.getFee())
	            .rating(req.getRating())
	            .availability(req.getAvailability())
	            .language(req.getLanguage())
	            .consultMode(req.getConsultMode())
	            .facility(req.getFacility())
	            .build();
	    return doctorRepository.save(doctor);
	}


	 @Override
	    public Page<Doctor> listDoctors(Map<String, String> filters, int page, int size) {
	        Specification<Doctor> spec = Specification.where(null);

	        spec = spec.and(DoctorSpecification.hasGender(filters.get("gender")))
	                   .and(DoctorSpecification.hasMinExperience(parseInt(filters.get("minExperience"))))
	                   .and(DoctorSpecification.hasMaxFee(parseDouble(filters.get("maxFee"))))
	                   .and(DoctorSpecification.hasMinRating(parseDouble(filters.get("minRating"))))
	                   .and(DoctorSpecification.hasAvailability(filters.get("availability")))
	                   .and(DoctorSpecification.hasLanguage(filters.get("language")))
	                   .and(DoctorSpecification.hasConsultMode(filters.get("cunsultMode")))
	                   .and(DoctorSpecification.hasFacility(filters.get("facility")));

	        Pageable pageable = PageRequest.of(page, size);
	        return doctorRepository.findAll(spec, pageable);
	    }

	    private Integer parseInt(String val) {
	        try { return val == null ? null : Integer.parseInt(val); } catch (Exception e) { return null; }
	    }

	    private Double parseDouble(String val) {
	        try { return val == null ? null : Double.parseDouble(val); } catch (Exception e) { return null; }
	    }
		

	

	

}
