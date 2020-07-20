package com.patel.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import com.patel.actions.ProcessLogin;

public class ProcessLoginTest {

	@Test
	public void testMultiply() {
		assertEquals(12, new ProcessLogin().multiply(4,3));
	}

	@Test
	public void testMultiply1() {
		assertEquals(123, new ProcessLogin().multiply(41,3));
	}
}
