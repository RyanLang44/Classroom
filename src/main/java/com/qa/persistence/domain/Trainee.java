package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRAINEES")
public class Trainee {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long Id;
	private Long TraineeID;
	private String traineeName;
	
	@ManyToOne
	@JoinColumn(name="classroomID", nullable=false)
	private Classroom classroom;
	
	public Trainee() {
		// TODO Auto-generated constructor stub
	}

	public Trainee(Long id, Long traineeID, String traineeName, Classroom classroom) {
		Id = id;
		TraineeID = traineeID;
		this.traineeName = traineeName;
		this.classroom = classroom;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getTraineeID() {
		return TraineeID;
	}

	public void setTraineeID(Long traineeID) {
		TraineeID = traineeID;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

}
