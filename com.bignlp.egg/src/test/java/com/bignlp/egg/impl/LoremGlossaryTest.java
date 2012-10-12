package com.bignlp.egg.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bignlp.egg.Glossary;

public class LoremGlossaryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNext() {
		LoremGlossary<Integer> loremGlossary = new LoremGlossary<Integer>(100);
		for (Glossary.Entry<Integer> entry : loremGlossary) {
			System.out.println(entry);
		}
	}

}
