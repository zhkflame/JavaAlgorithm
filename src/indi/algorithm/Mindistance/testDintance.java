package indi.algorithm.Mindistance;

import java.lang.reflect.Array;
import java.util.Arrays;

public class testDintance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph={{0   ,17  ,9999,9999,16  ,   1},
				{17  ,0   ,6   ,5   ,9999,  11},
				{9999,6   ,0   ,10  ,9999,9999},
				{9999,5   ,10  ,0   ,4   ,  14},
				{16  ,9999,9999,4   ,0   ,  33},
				{1   ,11  ,9999,14  ,33  ,   0}
				};
		//System.out.println(graph[2][3]);
		int len=graph.length;
		//boolean[] isVisit=new boolean[len];
		//isVisit[0]=true;
		//for(boolean i:isVisit)
			//System.out.println(i);
		int[] distance=new int[len];
		Arrays.fill(distance, 999999);
		for(int i=0;i<6;i++){
			Djikstra.getDistance(graph, i, distance);
			for(int j:distance)
				System.out.print(j+"  ");
			System.out.println();
		}
		
		System.out.println(Prime.getDistance(graph, 1, distance));
		
		
		
	}

}
