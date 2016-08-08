package indi.algorithm.Mindistance;

//求图上每一点到其他点的最短距离
public class Floyd {

	public static void getDistance(int[][] graph,int[][] distance) {
		int len=graph.length;
		
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++)
				distance[i][j]=graph[i][j];
		}
		int k=0;
		for(k=0;k<len;k++){
			for(int i=0;i<len;i++){
				for(int j=0;j<len;j++){
					if(graph[i][k]+graph[k][j]<distance[i][j])
						distance[i][j]=graph[i][k]+graph[k][j];
				}
			}
		}
		return;
	}	
}
