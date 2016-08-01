package indi.algorithm.BFSandDFS;

public interface MyStack {
	boolean isEmpty();
	void clear();
	boolean isFull();
	int length();
	void push(Object data);
	Object getTop();
	Object pop();

}
