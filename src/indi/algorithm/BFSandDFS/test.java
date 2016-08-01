package indi.algorithm.BFSandDFS;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myArrayStack testStack=new myArrayStack(10);
		myArrayQueue testQueue=new myArrayQueue(5);
		System.out.println(testQueue.length());
		testQueue.push(1);
		testQueue.push(2);
		testQueue.push(3);
		testQueue.push(4);
		testQueue.push(5);
		System.out.println(testQueue.length());
		testQueue.push(6);
		System.out.println(testQueue.length());
		System.out.println(testQueue.pop());
		System.out.println(testQueue.length());
		System.out.println(testQueue.getHead());
		System.out.println(testQueue.getTail());
		testQueue.clear();
		System.out.println(testQueue.length());
	}

}
