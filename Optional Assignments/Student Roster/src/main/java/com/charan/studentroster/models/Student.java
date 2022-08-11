package com.charan.studentroster.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="students")
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min = 1, max = 200)
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dorm_id")
    private Dorm dorm;
	
// constructor
	public Student() {}

	
// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dorm getDorm() {
		return dorm;
	}

	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}
}
