package com.harxsh.spring.basics.springin5steps.cdi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

	// Inject mock
	@InjectMocks
	SomeCdiBusiness business;

	// Create mock
	@Mock
	SomeCdiDao daoMock;

	@Test
	public void testBasicScenario() {
		// When daoMock.getData() method is call return int[] {2, 4}
		Mockito.when(daoMock.getData()).thenReturn(new int[] { 2, 4 });

		assertEquals(4, business.findGreatest());
	}

	@Test
	public void testBasicScenario_NoElements() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { });

		assertEquals(Integer.MIN_VALUE, business.findGreatest());
	}
	
	@Test
	public void testBasicScenario_EqualElements() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { 2, 2 });

		assertEquals(2, business.findGreatest());
	}
}