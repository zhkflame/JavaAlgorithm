package indi.algorithm.BFSandDFS;

public interface MyQueue {
	boolean isEmpty();
	void clear();
	boolean isFull();
	int length();
	void push(Object data);
	Object pop();
	Object getHead();
	Object getTail();
}
