package indi.algorithm.BFSandDFS;

public class preOrder {
	
	public static void preOrder1(mytreeNode root){
		if(root==null)
			return;
		System.out.println(root.getValue());
		preOrder1(root.getLeft());
		preOrder1(root.getRight());
	}
	
	public static void preOrder2(mytreeNode root) {
		if(root==null)
			return;
		MyStack stack=new myArrayStack(10);
		stack.push(root);
		while(!stack.isEmpty()){
			mytreeNode node=(mytreeNode)stack.pop();
			System.out.println(node.getValue());
			if(node.getRight()!=null)
				stack.push(node.getRight());
			if(node.getLeft()!=null)
				stack.push(node.getLeft());
		}
	}
	
	public static void preOrder3(mytreeNode root) {
		if(root==null)
			return;
		myArrayStack stack=new myArrayStack(10);
		mytreeNode node=root;
		while(node!=null || !stack.isEmpty()){
			while(node!=null){
				stack.push(node);
				System.out.println(node.getValue());
				node=node.getLeft();
			}
			mytreeNode temp=(mytreeNode)stack.pop();
			node=temp.getRight();
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
	    preOrder.preOrder3(root);
	    //p.preOrder1(root);
		
	}

}
