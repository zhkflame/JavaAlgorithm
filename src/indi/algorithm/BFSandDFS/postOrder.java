package indi.algorithm.BFSandDFS;

import java.util.Vector;

public class postOrder {
	
	public static void postOrder1(Object rot) {
		if(rot==null)
			return;
		mytreeNode root=(mytreeNode)rot;
		if(root.getLeft()!=null)
			postOrder1(root.getLeft());
		if(root.getRight()!=null)
			postOrder1(root.getRight());
		System.out.println(root.getValue());
	}
	
	public static void postOrder2(Object rot) {
		if(rot==null)
			return;
		mytreeNode root=(mytreeNode)rot;
		myArrayStack stack=new myArrayStack(10);
		Vector<Object> nList=new Vector<Object>();
		nList.add(root);
		nList.add(0);
		stack.push(nList);
		while (!stack.isEmpty()) {
			Vector<Object> tList=(Vector<Object>)stack.getTop();
			mytreeNode tempNode=(mytreeNode)tList.get(0);
			if((int)tList.get(1)==0){
				tList.set(1, 1);
				if(tempNode.getLeft()!=null){
					Vector<Object> nNode=new Vector<Object>(); 
					nNode.add(tempNode.getLeft());
					nNode.add(0);
					stack.push(nNode);
				}
			}
			else if ((int)tList.get(1)==1) {
				tList.set(1, 2);
				if(tempNode.getRight()!=null){
					Vector<Object> nNode=new Vector<Object>(); 
					nNode.add(tempNode.getRight());
					nNode.add(0);
					stack.push(nNode);
				}
			}
			else {
				System.out.println(tempNode.getValue());
				stack.pop();
			}
		}
	}
	
	public static void postOrder3(Object rot) {
		if(rot==null)
			return;
		mytreeNode root=(mytreeNode)rot;
		myArrayStack stack=new myArrayStack(10);
		mytreeNode pre=null;
		stack.push(root);
		while (!stack.isEmpty()) {
			mytreeNode node=(mytreeNode)stack.getTop();
			if((node.getLeft()==null && node.getRight()==null) ||
					pre!=null && (pre==node.getLeft()||pre==node.getRight())){
				System.out.println(node.getValue());
				stack.pop();
			}
			else {
				if(node.getRight()!=null)
					stack.push(node.getRight());
				if(node.getLeft()!=null)
					stack.push(node.getLeft());
			}
			pre=node;
			
		}
	}

	public static void main(String[] args) {
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
	    postOrder.postOrder3(root);
	}

}
