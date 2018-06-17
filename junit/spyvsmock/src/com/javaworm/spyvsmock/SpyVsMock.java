package com.javaworm.spyvsmock;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SpyVsMock {

	@Mock
	private Person mockedPerson;

	@Spy
	private Person spyPerson = new Person();

	@Test
	public void verifyZeroInteractionWithPerson() {
		verifyZeroInteractions(spyPerson);
	}

	@Test
	public void verifySetFirstNameMethodCalledWithMockedPerson() {
		mockedPerson.setFirstName("Abir");
		assertThat(mockedPerson.getFirstName(), equalTo(null));
    }

	@Test
	public void verifySetFirstNameMethodCalledWithSpiedPerson() {
		spyPerson.setFirstName("Abir");
		assertThat(spyPerson.getFirstName(), equalTo("Abir"));
	}

	@Test
	public void stubgetLastNameWithMock() {
		String expected = "Khan";
		// take note of using doReturn instead of when
		when(mockedPerson.getLastName()).thenReturn("Khan");
		assertEquals(expected, mockedPerson.getLastName());
	}

	@Test
	public void stubgetFirstNameWithSpy() {
		String expected = "Abir";
		// take note of using doReturn instead of when
		doReturn(expected).when(spyPerson).getFirstName();
		assertEquals(expected, spyPerson.getFirstName());
	}

}