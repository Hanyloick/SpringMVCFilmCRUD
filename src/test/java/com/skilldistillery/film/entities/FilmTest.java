package com.skilldistillery.film.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.film.data.DatabaseAccessorObject;

class FilmTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	void test() {
		DatabaseAccessorObject test = new DatabaseAccessorObject();
		List<Film> output = test.findFilmsByKeyword("sumo");
		assertEquals(82, output.size());
	}
	
	@Test
	void test2() {
		DatabaseAccessorObject test = new DatabaseAccessorObject();
		Actor output = test.findActorById(4);
		assertEquals("Jennifer", output.getFirstName());
	}
	
	@Test
	void test3() {
		DatabaseAccessorObject test = new DatabaseAccessorObject();
		Film output = test.findFilmById(5);
		assertEquals("AFRICAN EGG", output.getTitle());
	}
	
	@Test
	void test4() {
		DatabaseAccessorObject test = new DatabaseAccessorObject();
		String output = test.getCategory(7);
		assertEquals("Comedy", output);	
	}	
}


