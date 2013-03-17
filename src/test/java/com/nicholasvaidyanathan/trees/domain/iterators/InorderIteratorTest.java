package com.nicholasvaidyanathan.trees.domain.iterators;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nicholasvaidyanathan.trees.domain.BinaryTree;
import com.nicholasvaidyanathan.trees.factories.BinaryTreeFactory;

public class InorderIteratorTest {
	InorderIterator<Integer> toTest;
	BinaryTree<Integer> tree;
	BinaryTreeFactory<Integer> frak;
	
	@Before
	public void setup() {
		frak = new BinaryTreeFactory<Integer>();
		tree = initializeTreeA();
		toTest = new InorderIterator<Integer>(tree);
	}
	
	private BinaryTree<Integer> initializeTreeA() {
		BinaryTree<Integer> two = frak.create(2);
		two.setLeft(frak.create(1));
		two.setRight(frak.create(3));
		BinaryTree<Integer> four = frak.create(4);
		four.setLeft(two);
		four.setRight(frak.create(5));
		
		BinaryTree<Integer> seven = frak.create(7);
		seven.setRight(frak.create(9));
		BinaryTree<Integer> ten = frak.create(10);
		ten.setRight(frak.create(11));
		BinaryTree<Integer> eight = frak.create(8);
		eight.setLeft(seven);
		eight.setRight(ten);
		
		BinaryTree<Integer> six = frak.create(6);
		six.setLeft(four);
		six.setRight(eight);
		return six;
	}
	@Test
	public void canCreate() {
		assertNotNull(toTest);
	}

	@Test
	public void testHasNext() {
		assertTrue(toTest.hasNext());
	}

	@Test
	public void testNext() {
		List<Integer> expected = expectedTraversalResult();
		for(Integer i : expected) {
			BinaryTree<Integer> node = toTest.next();
			assertEquals(i, node.getData());
		}
	}

	private List<Integer> expectedTraversalResult() {
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(5);
		expected.add(6);
		expected.add(7);
		expected.add(9);
		expected.add(8);
		expected.add(10);
		expected.add(11);
		return expected;
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testRemove() {
		toTest.remove();
	}

}
