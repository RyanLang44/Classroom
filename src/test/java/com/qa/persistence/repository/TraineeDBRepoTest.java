package com.qa.persistence.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeDBRepoTest {

	@InjectMocks
	private TraineeDBRepository repo;
	
	@Mock
	private EntityManager manager;
	
	
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private static final String MOCK_DATA_ARRAY ="[{\"TraineeID\":1,\"traineeName\":\"Frank\"}]";
	private static final String MOCK_OBJECT ="{\"TraineeID\":1,\"traineeName\":\"Frank\"}"; 

	@Before
	public void setup() {
		repo.setManager(manager); 
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@Test
	public void testGetAllTrainees() {
		Trainee test1 = new Trainee();
		test1.setTraineeID((long) 1);
		test1.setTraineeName("Frank");
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> trainees = new ArrayList<Trainee>();
		trainees.add(test1);
		Mockito.when(query.getResultList()).thenReturn(trainees);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllTrainees());
	}
	
	@Test
	public void testGetATrainee() {
		Mockito.when(manager.find(Trainee.class, 1L)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Trainee.class));
		assertEquals(MOCK_OBJECT, repo.getATrainee(1L));
	}
	
	@Test
	public void testCreateTrainee() {
		String reply = repo.createTrainee(MOCK_OBJECT);
		assertEquals(reply,"{\"message\": \" trainee created successfully\"}");
	}
	
	@Test
	public void testDeleteTrainee() {
		String reply = repo.deleteTrainee(1L);
		assertEquals(reply,"{\"message\": \"trainee successfully deleted\"}");
	}
	
	@Test
	public void testUpdateTrainee() {
		
		assertEquals("{\"message\": \"trainee updated\"}", repo.updateTrainee(MOCK_OBJECT, 1L));
	}
	

}
