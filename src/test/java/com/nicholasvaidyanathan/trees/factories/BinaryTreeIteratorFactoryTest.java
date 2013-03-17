package com.nicholasvaidyanathan.trees.factories;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.nicholasvaidyanathan.trees.domain.BinaryTree;
import com.nicholasvaidyanathan.trees.domain.TraversalMode;
import com.nicholasvaidyanathan.trees.domain.iterators.*;

public class BinaryTreeIteratorFactoryTest {
	BinaryTreeIteratorFactory<Integer> toTest;
	BinaryTree<Integer> collaborator;
	
	@Before
	public void setup() {
		collaborator = new BinaryTreeFactory<Integer>().create(5);
		toTest = new BinaryTreeIteratorFactory<Integer>();
	}
	@Test
	public void canCreatePreorder() {
		Iterator<BinaryTree<Integer>> it = toTest.createIterator(TraversalMode.PRE, collaborator);
		assertTrue(it instanceof PreorderIterator);
	}
	@Test
	public void canCreatePostorder() {
		Iterator<BinaryTree<Integer>> it = toTest.createIterator(TraversalMode.POST, collaborator);
		assertTrue(it instanceof PostorderIterator);
	}
	
	@Test
	public void canCreateInorder() {
		Iterator<BinaryTree<Integer>> it = toTest.createIterator(TraversalMode.IN, collaborator);
		assertTrue(it instanceof InorderIterator);
	}
	
	@Test
	public void canCreateLevelorder() {
		Iterator<BinaryTree<Integer>> it = toTest.createIterator(TraversalMode.LEVEL, collaborator);
		assertTrue(it instanceof LevelorderIterator);
	}

}
