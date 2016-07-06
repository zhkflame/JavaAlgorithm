package indi.algorithm.simple;


public class bsearch {
	
	public static int binsearch(int[] L,int tar) {
		int l=0;
		int r=L.length-1;
		while(l<=r){
			int mid=(l+r)/2;
			if(tar==L[mid])
				return mid;
			else if (tar>L[mid]) 
				l=mid+1;
			else r=mid-1;
		}
		
		return -1;
	}
	
	public static int binsearch_min(int[] L,int tar) {
		int l=0;
		int r=L.length-1;
		while(l<r){
			int mid=(l+r)/2;
			if(tar>L[mid])
				l=mid+1;
			else 
				r=mid;
		}
		if(tar==L[l])
			return l;
		return -1;
		
	}
	
	public static int binsearch_max(int[] L,int tar) {
		int l=0;
		int r=L.length-1;
		while(l<r){
			int mid=(l+r+1)/2;
			if(tar<L[mid])
				r=mid-1;
			else l=mid;
		}
		if(tar==L[l])
			return l;
		return -1;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[]  L={3,5,7,14,14,14,14,14,14,14,14,18,34,39};
		 int temp=binsearch(L,14);
		 int temp1=binsearch_min(L,14);
		 int temp2=binsearch_max(L,14);
		 System.out.println(temp);
		 System.out.println(temp1);
		 System.out.println(temp2);
	}
}
