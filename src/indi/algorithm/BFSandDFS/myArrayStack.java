package indi.algorithm.BFSandDFS;

public class myArrayStack implements MyStack {
	private int top;
	private Object[] objs;
	private int size;
	
	public myArrayStack(int s){
		top=-1;
		size=s;
		objs=new Object[s];
	}
	
	@Override
	public boolean isFull() {
		return (top+1)==size;
	}
	
	@Override
	public boolean isEmpty(){
		return top==-1;
	}
	
	@Override
	public void push(Object data){
		if(isFull())
			System.out.println("the stack is full,now please resize");
		else {
			top=top+1;
			objs[top]=data;
		}
			
	}
	
	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			System.out.println("the stack is empty");
			return null;
		}
		else {
			top=top-1;
			return objs[top+1];
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i=0;i<size;i++)
			objs[i]=null;
		top=-1;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return top+1;
	}

	@Override
	public Object getTop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}
		else{
			return objs[top];
		}
	}
}
