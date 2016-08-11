package indi.algorithm.DFSAPP;

import java.util.ArrayList;
import java.util.Arrays;

import indi.algorithm.BFSandDFS.inOrder;

public class horse {
	
	Integer chess[][];
	int xdirect[]={-2,-2,-1,1,2,2,1,-1};
	int ydirect[]={-1,1,2,2,1,-1,-2,-2};
	ArrayList<Integer[][]> answer;
	int row;
	int col;
	int count=0;
	
	public horse(int x,int y){
		chess=new Integer[x][y];
		row=x;col=y;
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				chess[i][j]=0;
		chess[0][0]=1;
		answer=new ArrayList<Integer[][]>();
		//System.out.println(chess[0][0]);
	}
	
	public boolean jump(int x,int y,int step) {
		if(step==row*col){
			Integer[][] res=new Integer[row][col];
			for(int i=0;i<row;i++)
				res[i]=chess[i].clone();
			//res1=chess.clone();
			answer.add(res);
			return true;
		}
		for(int i=0;i<8;i++){
			int xCur=x+xdirect[i];
			int yCur=y+ydirect[i];
			if(isJump(chess, xCur, yCur)){
				//System.out.println(chess[xCur][yCur]);
				chess[xCur][yCur]=step+1;
				if(jump(xCur, yCur, chess[xCur][yCur]))
					return true;
				//jump(xCur, yCur, chess[xCur][yCur]);
				chess[xCur][yCur]=0;
			}
		}
		System.out.println(count++);
		return false;
		
	}
	
	public boolean isJump(Integer[][] chess,int x,int y){
		if(x<0 || x>=row || y<0 ||y>=col)
			return false;
		return chess[x][y]==0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		horse h=new horse(4,6);
		h.jump(0, 0, 1);
		for(int i=0;i<h.answer.size();i++){
			Integer[][] res=h.answer.get(i);
			for(int j=0;j<res.length;j++)
				System.out.println(Arrays.toString(res[j]));
		}
		
	}

}
