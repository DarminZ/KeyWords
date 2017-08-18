package com.keywords;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GetSistringTest {

	@Test
	public void testGetSistring() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStrings() {
		String str = "test,string��split";
		ArrayList<String> list = new ArrayList<String>();
		list.add("test");
		list.add("string");
		list.add("split");
		ArrayList<String> listCase  = GetSistring.GetStrings(str);
		assertEquals(listCase, list);
		System.out.println(listCase);
	}

	@Test
	public void testContainsAny() {
		String str = "�Ұ����";
		String searchChars1 = "����";
		String searchChars2 = "���";
		assertEquals(GetSistring.containsAny(str, searchChars1), false);
		assertEquals(GetSistring.containsAny(str, searchChars2), true);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
