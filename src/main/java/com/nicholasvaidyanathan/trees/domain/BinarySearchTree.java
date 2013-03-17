package com.nicholasvaidyanathan.trees.domain;

import java.util.Iterator;
import com.nicholasvaidyanathan.trees.factories.BinaryTreeIteratorFactory;

public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {
	private T data;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	private BinaryTreeIteratorFactory<T> iterator;
	private TraversalMode mode = TraversalMode.PRE;
	
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
		return String.format("data: %s%nleft: %s%nright: %s", data, left, right);
	}

	private TraversalMode getMode() {
		return mode;
	}

	@Override
	public void setMode(TraversalMode mode) {
		this.mode = mode;
	}

	@Override
	public int compareTo(BinaryTree<T> o) {
		if(getData() == null) {
			return (o.getData() == null) ? 0 : -1;
		} else if (o.getData() == null){
			return 1;
		} else {
			return getData().compareTo(o.getData());
		}
	}
}
