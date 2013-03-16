package com.nicholasvaidyanathan.trees;

import java.util.Iterator;

import com.nicholasvaidyanathan.trees.domain.BinaryTree;
import com.nicholasvaidyanathan.trees.factories.BinaryTreeFactory;

/**
 * Savitch & Carrano's Ch 24 problem 4
 *
 */
public class App 
{
	private static BinaryTree<Integer> toaster;
	private static BinaryTreeFactory<Integer> frak = new BinaryTreeFactory<Integer>();
	
	private static BinaryTree<Integer> initializeTreeA() {
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
	
	private static BinaryTree<Integer> initializeTreeB() {
		BinaryTree<Integer> three = frak.create(3);
		three.setLeft(frak.create(2));
		three.setRight(frak.create(1));
		
		BinaryTree<Integer> five = frak.create(5);
		five.setLeft(frak.create(4));
		five.setRight(frak.create(6));
		
		BinaryTree<Integer> eight = frak.create(8);
		eight.setLeft(three);
		eight.setRight(five);
		
		BinaryTree<Integer> ten = frak.create(10);
		ten.setLeft(frak.create(9));
		ten.setRight(frak.create(7));
		
		BinaryTree<Integer> eleven = frak.create(11);
		eleven.setLeft(eight);
		ten.setRight(ten);
		
		return eleven;
	}
    
	public static void main( String[] args )
    {
//        toaster = initializeTreeA();
//        printTree(toaster);
        toaster = initializeTreeB();
        printTree(toaster);
    }
	
	private static void printTree(BinaryTree<Integer> toPrint) {
		Iterator<BinaryTree<Integer>> it = toPrint.iterator();
        while(it.hasNext()) {
        	BinaryTree<Integer> t = it.next(); 
        	System.out.println(t);
        }
	}
}
