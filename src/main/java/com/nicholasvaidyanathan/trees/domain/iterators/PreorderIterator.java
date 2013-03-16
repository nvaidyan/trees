package com.nicholasvaidyanathan.trees.domain.iterators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.nicholasvaidyanathan.trees.domain.BinaryTree;

public class PreorderIterator<T> implements Iterator<BinaryTree<T>> {
	private List<BinaryTree<T>> nodes;
	private Iterator<BinaryTree<T>> it;
	
	public PreorderIterator(BinaryTree<T> root) {
		nodes = new LinkedList<BinaryTree<T>>();
		traverse(root);
		it = nodes.iterator();
	}
	
	private void traverse(BinaryTree<T> node) {
		if(node != null){
			nodes.add(node);
			traverse(node.getLeft());
			traverse(node.getRight());
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
