package com.doctorslist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequest {
	
	private Long id;

    private String name;
    private String gender;
    private String specialty;
    private int experience;      // in years
    private double fee;          // consultation fee
    private double rating;       // 0.0 - 5.0
    private String availability; // e.g., "Morning", "Evening"
    private String language;
	private String consultMode;      // e.g., "Hospital Visit", "Online Visit"
	private String facility; 

}
