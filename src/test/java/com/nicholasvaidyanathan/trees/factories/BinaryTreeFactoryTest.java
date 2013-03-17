package com.nicholasvaidyanathan.trees.factories;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nicholasvaidyanathan.trees.domain.BinaryTree;

public class BinaryTreeFactoryTest {
	BinaryTreeFactory<Integer> toTest;
	@Test
	public void testCreate() {
		toTest = new BinaryTreeFactory<Integer>();
		int expected = 5;
		BinaryTree<Integer> result = toTest.create(expected);
		int number = result.getData();
		assertEquals(expected, number);
	}

}
