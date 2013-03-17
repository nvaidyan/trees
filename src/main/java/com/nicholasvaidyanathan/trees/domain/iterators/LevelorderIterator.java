package com.nicholasvaidyanathan.trees.domain.iterators;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

import com.nicholasvaidyanathan.trees.domain.BinaryTree;

public class LevelorderIterator<T extends Comparable<T>> implements Iterator<BinaryTree<T>> {
	private List<BinaryTree<T>> nodes;
	private Iterator<BinaryTree<T>> it;
	
	public LevelorderIterator(BinaryTree<T> root) {
		nodes = new LinkedList<BinaryTree<T>>();
		traverse(root);
		it = nodes.iterator();
	}
	
	private void traverse(BinaryTree<T> node) {
		Queue<BinaryTree<T>> items = new LinkedList<BinaryTree<T>>();
		items.add(node);
		while(!items.isEmpty()){
			BinaryTree<T> iterating = items.remove();
			nodes.add(iterating);
			BinaryTree<T> left = iterating.getLeft();
			BinaryTree<T> right = iterating.getRight(); 
			
			if(left != null) {
				items.add(left);
			}
			if(right != null) {
				items.add(right);
			}
		}
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public BinaryTree<T> next() {
		return it.next();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Too hard right now!");
	}

}
