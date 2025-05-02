package com.doctorslist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "doctors")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String facility;   		 // e.g., "Apollo Hospital", "other Clinic"
    
    
	

}
