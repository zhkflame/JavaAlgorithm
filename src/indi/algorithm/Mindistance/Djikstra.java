package indi.algorithm.Mindistance;

public class Djikstra {
	public static int[] getDistance(int[][] graph,int point,int[] distance) {
		if(graph.length==0)
			return null;
		int len=graph.length;
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
			for(int j=0;j<len;j++){
				if(isVisit[j]==false && distance[pm]+graph[pm][j]<distance[j])
					distance[j]=distance[pm]+graph[pm][j];
			}
			
		}
		return distance;
	}
}
