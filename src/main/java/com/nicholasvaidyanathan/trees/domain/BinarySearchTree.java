package com.nicholasvaidyanathan.trees.domain;

import java.util.Iterator;
import com.nicholasvaidyanathan.trees.factories.BinaryTreeIteratorFactory;

public class BinarySearchTree<T> implements BinaryTree<T> {
	private T data;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	private BinaryTreeIteratorFactory<T> iterator;
	private TraversalMode mode;
	
	public BinarySearchTree(T newData) {
		data = newData;
		updateIterator();
	}
	
	private void updateIterator() {
		iterator = new BinaryTreeIteratorFactory<T>();
	}
	
	public T getData() {
		return data;
	}
	
	public void setLeft(BinaryTree<T> child) {
		left = child;
		updateIterator();
	}
	
	public void setRight(BinaryTree<T> child) {
		right = child;
		updateIterator();
	}
	
	public BinaryTree<T> getLeft() {
		return left;
	}
	
	public BinaryTree<T> getRight() {
		return right;
	}
	
	public Iterator<BinaryTree<T>> iterator() {
		return iterator.createIterator(getMode(), this);
	}
	
	@Override
	public String toString(){
		return String.format("%ndata : %s%nleft : %s%nright: %s%n", data, left, right);
	}

	private TraversalMode getMode() {
		return mode;
	}

	public void setMode(TraversalMode mode) {
		this.mode = mode;
	}
}
