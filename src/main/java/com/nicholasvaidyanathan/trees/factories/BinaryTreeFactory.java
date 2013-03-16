package com.nicholasvaidyanathan.trees.factories;

import com.nicholasvaidyanathan.trees.domain.BinarySearchTree;
import com.nicholasvaidyanathan.trees.domain.BinaryTree;

public class BinaryTreeFactory<T> {

	public BinaryTree<T> create(T data) {
		return new BinarySearchTree<T>(data);
	}

}
