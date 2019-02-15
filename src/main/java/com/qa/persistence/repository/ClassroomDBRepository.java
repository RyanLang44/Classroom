package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

import javax.persistence.EntityManager;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	public ClassroomDBRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom newClassroom = util.getObjectForJSON(classroom, Classroom.class);
		return"{\"message\": \" classroom created successfully\"}";
	}
	
	
	public String getAllClassrooms() {
		Query query = manager.createQuery("Select a FROM Classroom a");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	@Transactional(REQUIRED)
	public String getAClassroom(Long id) {
		return util.getJSONForObject(manager.find(Classroom.class, id));
	}

	@Transactional(REQUIRED)
	public String updateClassroom(String classroom, Long id) {
		Classroom temp = new Classroom();
		temp = util.getObjectForJSON(classroom, Classroom.class);
		manager.persist(temp);
		deleteClassroom(id);
		
		return "{\"message\": \"classroom updated\"}";
	}

	public String deleteClassroom(Long id) {
		Classroom classroomInDB = util.getObjectForJSON(getAClassroom(id), Classroom.class);
		
		if (manager.contains((manager.find(Classroom.class, id)))){
			manager.remove((manager.find(Classroom.class, id)));
		}
		
		return"{\"message\": \"classroom successfully deleted\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
