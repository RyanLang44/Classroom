package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository repo;
	@Inject
	JSONUtil util;

	public String addTrainee(String trainee) {
		// TODO Auto-generated method stub
		return repo.createTrainee(trainee);
	}

	public String getAllTrainees() {
		// TODO Auto-generated method stub
		return repo.getAllTrainees();
	}

	public String getATrainee(Long id) {
		// TODO Auto-generated method stub
		return repo.getATrainee(id);
	}

	public String updateTrainee(String trainee, Long id) {
		// TODO Auto-generated method stub
		return repo.updateTrainee(trainee, id);
	}

	public String deleteTrainee(Long id) {
		// TODO Auto-generated method stub
		return repo.deleteTrainee(id);
	}
	
	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	

}
