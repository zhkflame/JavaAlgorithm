package indi.algorithm.Dp;

public class TwoGroup {

	public static int getSum(int[] a) {
		int len=a.length;
		int len2=len/2;
		int sum=0;
		for(int x:a)
			sum+=x;
		int sum2=sum/2;
		int[] matrix=new int[sum2+1];
		int leftup=0;
		for(int i=0;i<len;i++){
			for(int j=sum2;j>=a[i];j--){
				matrix[j]=Math.max(matrix[j], matrix[j-a[i]]+a[i]);
			}
		}
		System.out.println(sum);
		return matrix[sum2-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] l={23,4,12,56,90,15,25,36,48,31};
		int sum=getSum(l);
		System.out.println(sum);
	}

}
