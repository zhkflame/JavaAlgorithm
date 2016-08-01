package indi.algorithm.BFSandDFS;

public class mytreeNode{

	private Object val;
	private mytreeNode left;
	private mytreeNode right;
	
	public mytreeNode(Object value){
		val=value;
		left=null;
		right=null;
	}
	
	public void setLeft(mytreeNode node){
		left=node;
	}
	public mytreeNode getLeft() {
		return left;
	}
	
	public void  setRight(mytreeNode node) {
		right=node;
	}
	public mytreeNode getRight() {
		return right;
	}
	
	public void setValue(Object value) {
		val=value;
	}
	public Object getValue() {
		return val;
	}

}
