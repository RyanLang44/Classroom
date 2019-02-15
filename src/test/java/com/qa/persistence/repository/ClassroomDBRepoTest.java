package com.qa.persistence.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.qa.persistence.domain.Classroom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomDBRepoTest {
	
	@InjectMocks
	private ClassroomDBRepository repo;
	
	@Mock
	private EntityManager manager;
	
	
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private static final String MOCK_DATA_ARRAY ="[{\"classroomID\":1,\"trainer\":\"Frank\"}]";
	private static final String MOCK_OBJECT ="{\"classroomID\":1,\"trainer\":\"Frank\"}"; 

	@Before
	public void setup() {
		repo.setManager(manager); 
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@Test
	public void testGetAllClassrooms() {
		Classroom test1 = new Classroom();
		test1.setClassroomID((long) 1);
		test1.setTrainer("Frank");
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Classroom> classrooms = new ArrayList<Classroom>();
		classrooms.add(test1);
		Mockito.when(query.getResultList()).thenReturn(classrooms);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllClassrooms());
	}
	
	@Test
	public void testGetAClassroom() {
		Mockito.when(manager.find(Classroom.class, 1L)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Classroom.class));
		assertEquals(MOCK_OBJECT, repo.getAClassroom(1L));
	}
	
	@Test
	public void testCreateClassroom() {
		String reply = repo.createClassroom(MOCK_OBJECT);
		assertEquals(reply,"{\"message\": \" classroom created successfully\"}");
	}
	
	@Test
	public void testDeleteClassroom() {
		String reply = repo.deleteClassroom(1L);
		assertEquals(reply,"{\"message\": \"classroom successfully deleted\"}");
	}
	
	@Test
	public void testUpdateClassroom() {
		
		assertEquals("{\"message\": \"classroom updated\"}", repo.updateClassroom(MOCK_OBJECT, 1L));
	}
	

}
