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

	public String createClassroom(String recipe) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(REQUIRED)
	public String getAllClassrooms() {
		Query query = manager.createQuery("Select a FROM Classroom a");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	public String getAClassroom(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateClassroom(String classroom, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteClassroom(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
