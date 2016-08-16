package indi.algorithm.Leecode;

import java.util.Arrays;

public class marray {
	
	public static void getResult(int[][] man,int[][] woman,int[] resultMan) {
		int len=man.length;
		int len2=woman.length;
		int[] r=new int[len];
		if(len==len2 && len>1){
			boolean hasSigle=true;
			//resultMan=new int[len];  //函数内如果对形参进行重新new，则只在函数内有效，返回后无效
			int[] resultWoman=new int[len];
			for(int i=0;i<len;i++){
				resultMan[i]=-1;resultWoman[i]=-1;
			}
			int[][] wrank=new int[len][len];
			for(int i=0;i<len;i++)
				for(int j=0;j<len;j++)
					wrank[i][woman[i][j]]=j;
			int[] rejectNum=new int[len];
			while (hasSigle) {
				hasSigle=false;
				for(int i=0;i<len;i++){
					if(resultMan[i]!=-1)
						continue;
					hasSigle=true;
					int j=rejectNum[i];
					rejectNum[i]+=1;
					int w=man[i][j];
					int m=resultWoman[w];		
					if(m==-1 || wrank[w][i]<wrank[w][m]){
						resultMan[i]=w;
						resultWoman[w]=i;
						if(m!=-1)
							resultMan[m]=-1;
					}
				}				
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] man={{2,3,1,0},
			         {2,1,3,0},
			         {0,2,3,1},
			         {1,3,2,0}};
		int[][] woman={{0,3,2,1},
			           {0,1,2,3},
			           {0,2,3,1},
			           {1,0,3,2}};
		int[] resultMan=new int[4];
		getResult(man,woman,resultMan);
		System.out.println(Arrays.toString(resultMan));
	}

}
