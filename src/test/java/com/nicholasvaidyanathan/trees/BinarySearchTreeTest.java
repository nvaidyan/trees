package com.nicholasvaidyanathan.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.nicholasvaidyanathan.trees.domain.BinarySearchTree;
import com.nicholasvaidyanathan.trees.domain.BinaryTree;
import com.nicholasvaidyanathan.trees.domain.TraversalMode;
import com.nicholasvaidyanathan.trees.domain.iterators.LevelorderIterator;
import com.nicholasvaidyanathan.trees.domain.iterators.PreorderIterator;

public class BinarySearchTreeTest {
	BinaryTree<String> toTest;
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
	
	@Test
	public void canSetMode() {
		assertTrue(toTest.iterator() instanceof PreorderIterator);
		toTest.setMode(TraversalMode.LEVEL);
		assertTrue(toTest.iterator() instanceof LevelorderIterator);
	}
	
	@Test
	public void canPrint() {
		String expected = String.format("data: foo%nleft: null%nright: null");
		assertEquals(expected, toTest.toString());
	}
	
	@Test
	public void canCompare() {
		BinaryTree<String> nullTree = new BinarySearchTree<String>(null);
		assertEquals(0, nullTree.compareTo(new BinarySearchTree<String>(null)));
		assertEquals(1, toTest.compareTo(nullTree));
		assertTrue(toTest.compareTo(new BinarySearchTree<String>("zeeman")) < 0);
		assertTrue(toTest.compareTo(new BinarySearchTree<String>("")) > 0);
	}

}
