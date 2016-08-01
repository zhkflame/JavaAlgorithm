package indi.algorithm.BFSandDFS;

public class myArrayQueue implements MyQueue {
	private int head;
	private int size;
	private int length;
	private Object[] objs;
	
	public myArrayQueue(int s) {
		// TODO Auto-generated constructor stub
		size=s;
		head=0;
		length=0;
		objs=new Object[s];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return 0==length;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head=0;
		length=0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return size==length;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public void push(Object data) {
		// TODO Auto-generated method stub
		if(isFull())
			System.out.println("the queue is full now");
		else {
			objs[(head+length)%size]=data;
			length=length+1;
		}
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			System.out.println("the queue is empty now");
			return null;
		}
		else {
			int temp=head;
			head=(head+1)%size;
			length=length-1;
			return objs[temp];
		}
	}

	@Override
	public Object getHead() {
		// TODO Auto-generated method stub
		return objs[head];
	}

	@Override
	public Object getTail() {
		// TODO Auto-generated method stub
		return objs[(head+length-1)%size];
	}

}
