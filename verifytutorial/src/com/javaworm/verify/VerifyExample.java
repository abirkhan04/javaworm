package com.javaworm.verify;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

public class VerifyExample {

	@Test
	public void verifyZeroInteractionWithPerson() {
		Person mockedPerson = mock(Person.class);
		verifyZeroInteractions(mockedPerson);
	}

	@Test
	public void verifySetFirstNameMethodCalledWithExactArgument() {
		Person mockedPerson = mock(Person.class);

		mockedPerson.setFirstName("Abir");

		verify(mockedPerson).setFirstName("Abir");

	}

	@Test
	public void verifySetFirstNameMethodCalledWithAnyArgument() {
		Person mockedPerson = mock(Person.class);

		mockedPerson.setFirstName("Abir");

		verify(mockedPerson).setFirstName(anyString());

	}

	@Test
	public void verifygetFirstNameMethodCalledatMostSeveralTimes() {
		Person mockedPerson = mock(Person.class);
		// when(mockedPerson.getFirstName()).thenReturn("Abir");
		mockedPerson.setFirstName("Abir");
		mockedPerson.getFirstName();
		mockedPerson.getFirstName();
		mockedPerson.getFirstName();
		verify(mockedPerson, atMost(3)).getFirstName();

	}

	@Test
	public void verifyTestUsingArgumentCaptor() {

		Person mockedPerson = mock(Person.class);
		mockedPerson.setFirstName("Abir");
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor
				.forClass(String.class);
		verify(mockedPerson).setFirstName(argumentCaptor.capture());
		String capturedArgument = argumentCaptor.getValue();
		System.out.println(capturedArgument);
		assertThat(capturedArgument, equalTo("Abir"));
	}

}