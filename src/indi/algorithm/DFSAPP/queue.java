package indi.algorithm.DFSAPP;

import java.util.ArrayList;
import java.util.Arrays;

public class queue {
	
	boolean[] m_colomn;
	boolean[] m_MainDiagonal;
	boolean[] m_MinorDiagonal;
	ArrayList<Integer[]> result;
	boolean isSloved;
	int Qsize;
	Integer[] path;
	
	public queue(int size) {
		path=new Integer[size];
		m_colomn=new boolean[size];
		m_MainDiagonal=new boolean[2*size-1];
		m_MinorDiagonal=new boolean[2*size-1];
		result=new ArrayList<Integer[]>();
		isSloved=false;
		Qsize=size;
	}
	
	public boolean canLay(int row,int col) {
		return (m_colomn[col]==false &&
				m_MainDiagonal[row-col+Qsize-1]==false &&
				m_MinorDiagonal[row+col]==false);
	}
	
	public void setLay(int row,int col,boolean res) {
		m_colomn[col]=res;
		m_MainDiagonal[row-col+Qsize-1]=res;
		m_MinorDiagonal[row+col]=res;
	}
	
	public boolean queue(Integer[] path,int row){
		if(row==Qsize){
			Integer[] temp=path.clone();
			result.add(temp);
			isSloved=true;
			return true;
		}
		int a=4;
		for(int col=0;col<Qsize;col++){
			if(canLay(row, col)){
				path[row]=col;
				setLay(row, col, true);
				if(queue(path, row+1))
					return true;
				//queue(path, row+1);
				setLay(row, col, false);
			}
		}
		return false;
	}
	public void start(){
		queue(path, 0);
	}
	public void printResult() {
		for(Integer[] re : result){
			System.out.println(Arrays.toString(re));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queue q=new queue(8);
		q.start();
		q.printResult();
	}

}
