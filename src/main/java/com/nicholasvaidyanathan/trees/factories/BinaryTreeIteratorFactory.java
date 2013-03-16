package com.nicholasvaidyanathan.trees.factories;

import java.util.Iterator;

import com.nicholasvaidyanathan.trees.domain.BinaryTree;
import com.nicholasvaidyanathan.trees.domain.TraversalMode;
import com.nicholasvaidyanathan.trees.domain.iterators.InorderIterator;
import com.nicholasvaidyanathan.trees.domain.iterators.LevelorderIterator;
import com.nicholasvaidyanathan.trees.domain.iterators.PostorderIterator;
import com.nicholasvaidyanathan.trees.domain.iterators.PreorderIterator;

public class BinaryTreeIteratorFactory<T> {

	public Iterator<BinaryTree<T>> createIterator(TraversalMode mode, BinaryTree<T> root) {
		switch(mode) {
			case PRE:
				return preorderIterator(root);
			case POST:
				return postorderIterator(root);
			case IN:
				return inorderIterator(root);
			case LEVEL:
				return levelorderIterator(root);
			default:
				throw new UnsupportedOperationException("Don't know how to handle mode");
		}
	}
	
	private Iterator<BinaryTree<T>> preorderIterator(BinaryTree<T> root) {
		return new PreorderIterator<T>(root);
	}
	
	private Iterator<BinaryTree<T>> postorderIterator(BinaryTree<T> root) {
		return new PostorderIterator<T>(root);
	}
	
	private Iterator<BinaryTree<T>> inorderIterator(BinaryTree<T> root) {
		return new InorderIterator<T>(root);
	}
	
	private Iterator<BinaryTree<T>> levelorderIterator(BinaryTree<T> root) {
		return new LevelorderIterator<T>(root);
	}

}
