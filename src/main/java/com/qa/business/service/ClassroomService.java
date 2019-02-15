package com.qa.business.service;

public interface ClassroomService {
	
	String addClassroom(String classroom);
	
	String getAllClassrooms();
	
	String getAClassroom(Long id);
	
	String updateClassroom(String classroom, Long id);
	
	String deleteClassroom(Long id);

}
