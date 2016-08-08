package indi.algorithm.Mindistance;

import java.util.ArrayList;

public class Kruskal {

	public static int kruskal(int[][]graph, int point, int[] distance) {
		ArrayList<ArrayList> edge=new ArrayList<ArrayList>();
		int len=graph.length;
		int[] maskG=new int[len];
		for(int i=0;i<len;i++)
			maskG[i]=i;
		//edge存储边和结点的值
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++){
				ArrayList<Object> a=new ArrayList<>();
				a.add(graph[i][j]);
				a.add(i);
				a.add(j);
				edge.add(a);
			}
		}
		int num=len*(len-1)/2;
		quickSort(edge, 0, num-1);
		//for(int i=0;i<len;i++){
		//	System.out.println(edge.get(i).get(0));
		//}
		int sum=0;
		int count=0;
		for(int i=0;i<num;i++){
			int x=(int)edge.get(i).get(1);
			int y=(int)edge.get(i).get(2);
			while(x!=maskG[x])
				x=maskG[x];
			while(y!=maskG[y])
				y=maskG[y];
			if(x!=y){
				sum+=(int)edge.get(i).get(0);
				maskG[y]=x;
				count+=1;
			}
		}
		if(count<len-1)
			return 0;
		return sum;
	}
	
	public static void quickSort(ArrayList<ArrayList> edge,int left,int right) {
		int len=edge.size();
		if(left>right)
			return;
		int l=left;
		int r=right;
		ArrayList<Object> temp=edge.get(left);
		while(l<r){
			while (l<r && (int)edge.get(r).get(0)>(int)temp.get(0))
				r--;
			edge.set(l, edge.get(r));
			while (l<r && (int)edge.get(l).get(0)<=(int)temp.get(0))
				l++;
			edge.set(r, edge.get(l));
		}
		edge.set(l,temp);
		quickSort(edge,left,l-1);
		quickSort(edge, l+1, right);
		return;
		
	}
}
