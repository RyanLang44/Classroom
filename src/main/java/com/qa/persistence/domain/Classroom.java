package com.qa.persistence.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSROOM")
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private Long classroomID;
	private String trainer;

	@OneToMany(mappedBy = "classroom")
	private Set<Trainee> trainees;

	public Classroom() {
	
	}

	public Classroom(Long id, Long classroomID, String trainer, Set<Trainee> trainees) {
		super();
		this.id = id;
		this.classroomID = classroomID;
		this.trainer = trainer;
		this.trainees = trainees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}

}
