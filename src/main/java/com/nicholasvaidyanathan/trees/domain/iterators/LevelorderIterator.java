package com.nicholasvaidyanathan.trees.domain.iterators;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.nicholasvaidyanathan.trees.domain.BinaryTree;

public class LevelorderIterator<T> implements Iterator<BinaryTree<T>> {
	private Queue<BinaryTree<T>> nodes;
	private Iterator<BinaryTree<T>> it;
	
	public LevelorderIterator(BinaryTree<T> root) {
		nodes = new PriorityQueue<BinaryTree<T>>();
		traverse(root);
		it = nodes.iterator();
	}
	
	private void traverse(BinaryTree<T> node) {
		if(node != null){
			BinaryTree<T> left = node.getLeft();
			BinaryTree<T> right = node.getRight(); 
			nodes.add(node);
			if(left != null) {
				nodes.add(left);
			}
			if(right != null) {
				nodes.add(right);
			}
			traverse(nodes.remove());
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
