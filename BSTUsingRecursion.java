/*
 * This program shows the implementation of Binary search tree using recursion.
 * 
 * @author Alankar Singh
 * 
 * This program supports following BST's operations.
 * insert(), minimum(), maximum(), search(),
 * delete(), display()
 */

import java.util.*;
/*
 * The following BstNode class is used to create a node,
 * when value is passed to this class it makes a node of binary tree.
 */
class Rec{
	
	int data;
	Rec left;
	Rec right;
	public Rec(int value){
		this.data = value;
		left = null;
		right = null;
	}
}

public class BSTUsingRecursion {
	
	Rec root;
	
	public BSTUsingRecursion(){
		root = null;
	}
	
	/*
	 * A method to insert a new node
	 * @param int val
	 */
	public void insert(int val){
		root = insertRec(root,val);
	}
	
	/*
	 * A recursive method to add new node to the tree
	 * @param Rec root
	 * @param int val
	 * return root
	 */
	Rec insertRec(Rec root,int val){
		
		if(root==null){
			root=new Rec(val);
			return root;
		}
		if(val<root.data){
			root.left = insertRec(root.left,val);
		}else{
			root.right = insertRec(root.right,val);
		}
		return root;
		
	}
	
	/*
	 * A method to search a given value
	 * @param int val
	 * @retun boolean
	 */
	public boolean search(int val){
		boolean ans = searchRec(root,val);
		return ans;
	}
	
	/*
	 * A recursive method to search a node from the tree
	 * @param Rec root
	 * @param int val
	 * return boolean
	 */
	public boolean searchRec(Rec root, int val){
		
		boolean flag = false;
		if(root.data == val){
			flag = true;
		}
		else if(val<root.data){
			searchRec(root.left,val);
		}else if(val>root.data){
			searchRec(root.right,val);
		}else{
			flag =false;
		}
		return flag;
	}
	
	public void display(){
		
		inOrder(root);
	}
	
	public void inOrder(Rec root){
		
		if(root!=null){
			System.out.print(" "+root.data);
			inOrder(root.left);
			inOrder(root.right);
		}
	}
	
	public static void main(String[] args){
		
		BSTUsingRecursion bst = new BSTUsingRecursion();
		bst.insert(11);
		bst.insert(4);
		bst.insert(3);
		bst.insert(9);
		bst.insert(16);
		bst.insert(19);
		bst.insert(15);
		System.out.println(bst.search(4));
		
	}
}
