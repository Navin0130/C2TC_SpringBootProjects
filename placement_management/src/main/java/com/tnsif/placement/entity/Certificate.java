package com.tnsif.placement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String year;
    private String reg_no;
    private String description;
    private String certificate_number;
    private String degree;
    private String year_of_passing;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public String getCertificate_number() {
		return certificate_number;
	}
	public void setCertificate_number(String certificate_number) {
		this.certificate_number = certificate_number;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getYear_of_passing() {
		return year_of_passing;
	}
	public void setYear_of_passing(String year_of_passing) {
		this.year_of_passing = year_of_passing;
	}
	

    
}