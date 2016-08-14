package indi.algorithm.DFSAPP;

import java.util.ArrayList;
import java.util.Arrays;

public class sudoku {
	Integer[][] chess;
	boolean isDone;
	ArrayList<Integer[][]> result;
	
	public sudoku(Integer[][] a) {
		chess=a;
		isDone=false;
		result=new ArrayList<Integer[][]>();
	}
	
	public boolean canLay(int x,int y,int val) {
		for(int i=0;i<9;i++){
			if(chess[x][i]==val || chess[i][y]==val)
				return false;
		}
		int row=(x/3)*3;
		int col=(y/3)*3;
		for(int i=row;i<row+3;i++)
			for(int j=col;j<col+3;j++)
				if(chess[i][j]==val)
					return false;
		return true;
	}
	
	public boolean sudoku() {
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(chess[i][j]!=0)
					continue;
				for(int k=1;k<10;k++){
					if(canLay(i, j, k)){
						chess[i][j]=k;
						if(sudoku()){
							if(!isDone){
								Integer[][] res=new Integer[9][9];
								for(int t=0;t<9;t++)
									res[t]=chess[t].clone();
								result.add(res);
								//isDone=true;
							}
							//return true;
						}						
					}
					chess[i][j]=0;	
				}
				return false;
			}
		}		
		return true;
	}

	public void printResult() {
		for(Integer[][] re : result){
			for(int i=0;i<re.length;i++){
				System.out.println(Arrays.toString(re[i]));
			}
			System.out.println("---------------------");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[][] chess1={{0,4,2,0,6,3,0,0,9},
		                    {6,0,0,0,1,0,0,0,5},
		                    {3,0,0,0,2,0,4,8,0},
		                    {1,0,0,5,0,2,6,0,8},
		                    {4,0,0,0,0,7,0,0,1},
		                    {9,0,5,6,0,0,0,0,7},
		                    {0,3,6,0,5,0,0,0,2},
		                    {2,0,0,0,7,0,0,0,4},
		                    {7,0,0,2,9,0,8,5,0}};
		Integer[][] chess3={{6,0,8,1,0,2,0,7,0},
		                    {0,0,7,0,4,0,0,8,3},
		                    {0,0,9,3,0,0,1,0,0},
		                    {0,2,0,7,6,0,5,0,0},
		                    {0,0,4,0,9,0,0,1,0},
		                    {7,9,0,0,0,0,8,0,2},
		                    {4,0,5,0,3,0,7,0,8},
		                    {0,0,0,0,2,0,9,4,0},
		                    {0,0,2,5,0,4,0,6,0}};
		sudoku s=new sudoku(chess3);
		s.sudoku();
		s.printResult();
	}

}
