package com.nicholasvaidyanathan.trees;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.nicholasvaidyanathan.trees.domain.BinarySearchTree;
import com.nicholasvaidyanathan.trees.domain.BinaryTree;

public class BinarySearchTreeTest {
	BinarySearchTree<String> toTest;
	String data;
	
	@Before
	public void setup() {
		data = "foo";
		toTest = new BinarySearchTree<String>(data);
	}
	
	@Test
	public void createsInConsistentState() {
		toTest = new BinarySearchTree<String>("foo");
		assertNotNull(toTest);
		assertNull(toTest.getLeft());
		assertNull(toTest.getRight());
	}

	@Test
	public void canGetData() {
		assertEquals(data, toTest.getData());
	}

	@Test
	public void canWorkWithLeftChild() {
		String bar = "bar";
		BinaryTree<String> tree = new BinarySearchTree<String>(bar);
		toTest.setLeft(tree);
		assertEquals(tree, toTest.getLeft());
	}

	@Test
	public void canWorkWithRightChild() {
		String bar = "bar";
		BinaryTree<String> tree = new BinarySearchTree<String>(bar);
		toTest.setRight(tree);
		assertEquals(tree, toTest.getRight());
	}

	@Test
	public void canIterate() {
		Iterator<BinaryTree<String>> it = toTest.iterator();
		assertTrue(it.hasNext());
		assertEquals(toTest, it.next());
		assertFalse(it.hasNext());
		String bar = "bar";
		BinaryTree<String> tree = new BinarySearchTree<String>(bar);
		toTest.setRight(tree);
		it = toTest.iterator();
		int nodes = 0;
		while(it.hasNext()) {
			it.next();
			nodes++;
		}
		assertEquals(2, nodes);
		
		
	}

}
