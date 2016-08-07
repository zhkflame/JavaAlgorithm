package indi.algorithm.Mindistance;

public class Prime {
	public static int getDistance(int[][] graph,int point,int[] distance) {
		if(graph.length==0)
			return -1;
		int len=graph.length;
		int sum=0;
		boolean[] isVisit=new boolean[len];
		isVisit[point]=true;
		for(int i=0;i<len;i++) 
			distance[i]=graph[point][i];
		for(int i=0;i<len;i++){
			int min=9999999;
			int pm=point;
			for(int j=0;j<len;j++){
				if(isVisit[j]==false)
					if(min>distance[j]){
						min=distance[j];
						pm=j;
					}
			}
			isVisit[pm]=true;
			if(min==9999999)
				break;
			sum+=min;
			for(int j=0;j<len;j++){
				if(isVisit[j]==false && graph[pm][j]<distance[j])
					distance[j]=graph[pm][j];
			}
			
		}
		return sum;
	}
}
