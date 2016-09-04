package indi.algorithm.Leecode;

public class jump {
	
	public static int jump(int[] a){
		int len=a.length;
		if(len<=0)
			return -1;
		int max=a[0];
		int step=1;
		int left=1;
		int right=max;
		while(max<len-1){
			step++;
			for(int i=left;i<=right;i++)
				if(a[i]+i>max)
					max=a[i]+i;
			left=right+1;
			right=max;
		}
		return step;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,3,1,1,1,2,1,1,1};
		int len=jump(a);
		System.out.println(len);
	}

}
