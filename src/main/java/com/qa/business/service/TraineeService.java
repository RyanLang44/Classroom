package com.qa.business.service;

public interface TraineeService {
	
	String addTrainee(String trainee);
	
	String getAllTrainees();
	
	String getATrainee(Long id);
	
	String updateTrainee(String trainee, Long id);
	
	String deleteTrainee(Long id);

}
