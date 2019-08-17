package com.javaworm;

import java.util.Optional;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestOptional {

	@Test
	public void whenCreatesEmptyOptional_thenCorrect() {
		Optional<String> empty = Optional.empty();
		assertTrue(empty.isEmpty());
	}

	@Test(expected = NullPointerException.class)
	public void whenOptionOfNullValues_thenThrowException() {
		String name = null;
		Optional.of(name);
	}

	@Test
	public void givenNonNull_whenCreatesNullable_thenCorrect() {
		String name = "Javaworm";
		Optional<String> opt = Optional.ofNullable(name);
		assertTrue(opt.isPresent());
	}

	@Test
	public void givenNull_whenCreatesNullable_thenCorrect() {
		String name = null;
		Optional<String> opt = Optional.ofNullable(name);
		assertFalse(opt.isPresent());
	}

	@Test
	public void givenOptinal_checkingIsPresentWorks_thenCorrect() {
		String name = null;
		Optional<String> opt = Optional.ofNullable(name);
		assertFalse(opt.isPresent());
	}

	@Test
	public void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
		Optional<String> opt = Optional.of("Javaworm");
		assertFalse(opt.isEmpty());

		opt = Optional.ofNullable(null);
		assertTrue(opt.isEmpty());
	}

	@Test
	public void givenOptional_whenIfPresentWorks_thenCorrect() {
		Optional<String> opt = Optional.of("javaworm");
		opt.ifPresent(name -> System.out.println(name.length()));
	}

	@Test
	public void whenOrElseWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("javaworm");
		assertEquals("javaworm", name);
	}

	@Test
	public void whenOrElseGetWorks_thenCorrect() {
		String name = (String) Optional.ofNullable(null).orElseGet(() -> "javaworm");
		assertEquals("javaworm", name);
	}

	@Test
	public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
		String text = null;

		String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		assertEquals("Default Value", defaultText);

		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		assertEquals("Default Value", defaultText);
	}

	@Test
	public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
		String text = "With Text";

		String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		assertEquals("With Text", defaultText);

		System.out.println("Using orElse:");
		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		assertEquals("With Text", defaultText);
	}

	public String getMyDefault() {
		System.out.println("Invoked");
		return "Default Value";
	}

}