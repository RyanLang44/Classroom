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
	
	private static final String MOCK_DATA_ARRAY ="[{\"classroomID\": 1,\"trainer\":\"Frank\"}]";
	private static final String MOCK_OBJECT ="{\"classroomID\": 1,\"trainer\":\"Frank\"}"; 

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
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn((Query) util.getObjectForJSON(MOCK_OBJECT, Classroom.class));
		List<Classroom> classrooms = new ArrayList<Classroom>();
		classrooms.add(test1);
		Mockito.when(query.getResultList()).thenReturn(classrooms);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllClassrooms());
	}
	

}
