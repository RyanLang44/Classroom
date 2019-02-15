package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;

import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	
	
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee newtrainee = util.getObjectForJSON(trainee, Trainee.class);
		return"{\"message\": \" trainee created successfully\"}";
	}
	
	
	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM trainee a");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}
	@Transactional(REQUIRED)
	public String getATrainee(Long id) {
		return util.getJSONForObject(manager.find(Trainee.class, id));
	}
	@Transactional(REQUIRED)
	public String updateTrainee(String trainee, Long id) {
		Trainee temp = new Trainee();
		temp = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(temp);
		deleteTrainee(id);
		
		return "{\"message\": \"trainee updated\"}";
	}
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Trainee traineeInDB = util.getObjectForJSON(getATrainee(id), Trainee.class);
		
		if (manager.contains((manager.find(Trainee.class, id)))){
			manager.remove((manager.find(Trainee.class, id)));
		}
		
		return"{\"message\": \"trainee successfully deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}



}
