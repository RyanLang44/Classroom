package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceImpl implements ClassroomService {
	
	@Inject
	private ClassroomRepository repo;
	@Inject
	JSONUtil util;

	public String addClassroom(String classroom) {
		// TODO Auto-generated method stub
		return repo.createClassroom(classroom);
	}

	public String getAllClassrooms() {
		// TODO Auto-generated method stub
		return repo.getAllClassrooms();
	}

	public String getAClassroom(Long id) {
		// TODO Auto-generated method stub
		return repo.getAClassroom(id);
	}

	public String updateClassroom(String classroom, Long id) {
		// TODO Auto-generated method stub
		return repo.updateClassroom(classroom, id);
	}

	public String deleteClassroom(Long id) {
		// TODO Auto-generated method stub
		return repo.deleteClassroom(id);
	}
	
	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
