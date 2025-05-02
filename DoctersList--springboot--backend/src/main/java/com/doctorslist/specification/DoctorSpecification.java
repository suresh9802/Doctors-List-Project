package com.doctorslist.specification;

import org.springframework.data.jpa.domain.Specification;

import com.doctorslist.entity.Doctor;

public class DoctorSpecification {
	
	public static Specification<Doctor> hasGender(String gender) {
        return (root, query, cb) -> gender == null ? null : cb.equal(root.get("gender"), gender);
    }

    public static Specification<Doctor> hasMinExperience(Integer min) {
        return (root, query, cb) -> min == null ? null : cb.greaterThanOrEqualTo(root.get("experience"), min);
    }

    public static Specification<Doctor> hasMaxFee(Double max) {
        return (root, query, cb) -> max == null ? null : cb.lessThanOrEqualTo(root.get("fee"), max);
    }

    public static Specification<Doctor> hasMinRating(Double min) {
        return (root, query, cb) -> min == null ? null : cb.greaterThanOrEqualTo(root.get("rating"), min);
    }

    public static Specification<Doctor> hasAvailability(String availability) {
        return (root, query, cb) -> availability == null ? null : cb.equal(root.get("availability"), availability);
    }

    public static Specification<Doctor> hasLanguage(String language) {
        return (root, query, cb) -> language == null ? null : cb.equal(root.get("language"), language);
    }
    
    public static Specification<Doctor> hasConsultMode(String consultMode) {
        return (root, query, cb) ->
            consultMode == null ? null : cb.equal(root.get("consultMode"), consultMode);
    }
    
    public static Specification<Doctor> hasFacility(String facility) {
        return (root, query, cb) ->
            facility == null ? null : cb.equal(root.get("facility"), facility);
    }



}
