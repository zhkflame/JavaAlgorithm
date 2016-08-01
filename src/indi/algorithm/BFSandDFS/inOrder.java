package indi.algorithm.BFSandDFS;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class inOrder {
	
	public static void  inOrder1(mytreeNode root) {
		if(root==null)
			return;
		if(root.getLeft()!=null)
			inOrder1(root.getLeft());
		System.out.println(root.getValue());
		if(root.getRight()!=null)
			inOrder1(root.getRight());
	}
	
	public static void inOrder2(mytreeNode root) {
		if(root==null)
			return;
		myArrayStack stack=new myArrayStack(10);
		Vector<Object> nList=new Vector<Object>(); 
		System.out.println(root);
		nList.add(root);
		nList.add(0);
		stack.push(nList);
		while(!stack.isEmpty()){
			Vector node=(Vector)stack.getTop();
			mytreeNode tempNode=(mytreeNode)node.get(0);
			if((int)node.get(1)==0){
				node.set(1, 1);
				if(tempNode.getLeft()!=null){
					Vector<Object> nNode=new Vector<Object>(); 
					nNode.add(tempNode.getLeft());
					nNode.add(0);
					stack.push(nNode);
				}
			}
			else if ((int)node.get(1)==1) {
				System.out.println(tempNode.getValue());
				stack.pop();
				if(tempNode.getRight()!=null){
					Vector<Object> nNode=new Vector<Object>(); 
					nNode.add(tempNode.getRight());
					nNode.add(0);
					stack.push(nNode);
				}
			}
			
		}
	}
	
	public static void inOrder3(mytreeNode root) {
		if(root==null)
			return;
		myArrayStack stack=new myArrayStack(10);
		mytreeNode node=root;
		while(node!=null || !stack.isEmpty()){
			while(node!=null){
				stack.push(node);
				node=node.getLeft();
			}
			mytreeNode temp=(mytreeNode)stack.getTop();
			System.out.println(temp.getValue());
			stack.pop();
			node=temp.getRight();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		mytreeNode root=new mytreeNode(1);
		mytreeNode a=new mytreeNode(2);
		mytreeNode b=new mytreeNode(3);
		mytreeNode c=new mytreeNode(4);
		mytreeNode d=new mytreeNode(5);
		mytreeNode e=new mytreeNode(6);
		mytreeNode f=new mytreeNode(7);
		mytreeNode g=new mytreeNode(8);
		root.setLeft(a);
		root.setRight(b);
		a.setRight(c);
		b.setLeft(d);
	    c.setLeft(e);
	    e.setRight(f);
	    d.setRight(g);
	    inOrder.inOrder3(root);
	}

}
