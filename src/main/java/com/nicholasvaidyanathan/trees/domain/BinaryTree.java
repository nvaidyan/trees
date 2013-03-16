package com.nicholasvaidyanathan.trees.domain;

public interface BinaryTree<T> extends Iterable<BinaryTree<T>> {
	T getData();
	void setLeft(BinaryTree<T> child);
	void setRight(BinaryTree<T> child);
	BinaryTree<T> getLeft();
	BinaryTree<T> getRight();
}
