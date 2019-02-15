package com.qa.persistence.repository;

public interface ClassroomRepository {
	
	String createClassroom(String classroom);
	
	String getAllClassrooms();
	
	String getAClassroom(Long id);
	
	String updateClassroom(String classroom, Long id);
	
	String deleteClassroom(Long id);

}
