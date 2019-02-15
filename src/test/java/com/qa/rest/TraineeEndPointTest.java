package com.qa.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.TraineeService;

@RunWith(MockitoJUnitRunner.class)
public class TraineeEndPointTest {


	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";
	
	@InjectMocks
	private TraineeEndPoint endpoint;
	
	@Mock
	private TraineeService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}
	
	@Test
	public void testGetAllTrainees() {
		Mockito.when(service.getAllTrainees()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAllTrainees());
	}
	
	@Test
	public void testGetATrainee() {
		Mockito.when(service.getATrainee(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getATrainee(1L));
	}
	
	@Test 
	public void testCreateTrainee() {
		Mockito.when(service.addTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.addTrainee(MOCK_VALUE2));
		Mockito.verify(service).addTrainee(MOCK_VALUE2);
	}
	
	@Test
	public void testDeleteTrainee() {
		Mockito.when(service.deleteTrainee(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteTrainee(1L));
		Mockito.verify(service).deleteTrainee(1L);
	}
	
	@Test
	public void testUpdateTrainee() {
		Mockito.when(service.updateTrainee(MOCK_VALUE2, 1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.updateTrainee(1L, MOCK_VALUE2));
		Mockito.verify(service).updateTrainee(MOCK_VALUE2, 1L);
	}


}
