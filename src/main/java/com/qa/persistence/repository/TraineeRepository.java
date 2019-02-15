package com.qa.persistence.repository;

public interface TraineeRepository {

	String createTrainee(String trainee);

	String getAllTrainees();

	String getATrainee(Long id);

	String updateTrainee(String trainee, Long id);

	String deleteTrainee(Long id);

}
