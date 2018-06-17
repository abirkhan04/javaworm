package com.javaworm;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Utils.class })
public class MockStatic {

	int value = 100;

	@Before
	public void setUp() {

		PowerMockito.mockStatic(Utils.class);
		when(Utils.generateUUID()).thenReturn(value);

	}

	@Test
	public void testGenerateUUIDbyMockedStatic() {
		assertThat(Utils.generateUUID(), equalTo(100));
	}
}
