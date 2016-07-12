package DP;

public class EditLength {
	
	public static int EditLength(String str1,String str2) {
		int len1=str1.length();
		int len2=str2.length();
		int[][] matrix=new int[len1+1][len2+1];
		
		for(int i=0;i<=len1;i++){
			for(int j=0;j<=len2;j++){
				if(i==0)
					matrix[i][j]=j;
				else if(j==0)
					matrix[i][j]=i;
				else {
					int temp1=Math.min(matrix[i-1][j]+1,matrix[i][j-1]+1);
					int temp2= str1.charAt(i-1)==str2.charAt(j-1)?matrix[i-1][j-1]:(matrix[i-1][j-1]+1);
					matrix[i][j]=Math.min(temp1, temp2);
				}
			}
		}
		
		return matrix[len1][len2];
	}
	
	public static int EditLength2(String str1,String str2) {
		int len1=str1.length();
		int len2=str2.length();
		int[] matrix=new int[len2+1];
		int leftup=0;
		for(int i=1;i<=len1;i++){
			for(int j=0;j<=len2;j++){
				if(j==0){
					leftup=matrix[j];
					matrix[j]=i;
				}
				else {
					int temp=matrix[j];
					int temp1=Math.min(matrix[j]+1,matrix[j-1]+1);
					int temp2= str1.charAt(i-1)==str2.charAt(j-1)?leftup:(leftup+1);
					matrix[j]=Math.min(temp1, temp2);
					leftup=temp;
				}
			}
		}
		
		return matrix[len2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString="abcdefg";
		String bString="ab";
		System.out.println(EditLength2(aString, bString));
	}

}
