package indi.algorithm.string;


public class kmp {
	
	public static int[] getNext(String p_str){
		int lenP=p_str.length();
		int[] next=new int[lenP];
		if(lenP<2)
			return next;
		next[0]=0;
		next[1]=0;
		int k=0;
		int j=2;
		for(j=2;j<lenP;j++){
			while(k>0 && p_str.charAt(j-1)!=p_str.charAt(k))
				k=next[k];
			if(p_str.charAt(j-1)==p_str.charAt(k)){
				next[j]=k+1;
				j++;
			}
			else
				next[j++]=0;
		}
		/*
		while(j<lenP){
			if(p_str.charAt(j-1)==p_str.charAt(k)){
				next[j++]=k+1;
			}
			else {
				if(k!=0)
					k=next[k];
				else {
					next[j++]=0;
				}	
			}
		}
		*/
		return next;
	}
	
	public static int kmp(String t_str,String p_str) {
		int lenT=t_str.length();
		int lenP=p_str.length();
		if(lenT<lenP)
			return -1;
		int j=0;
		int[] next=getNext(p_str);
		for(int i=0;i<lenT;i++){
			while(j>0 && t_str.charAt(i)!=p_str.charAt(j))
				j=next[j];
			if(t_str.charAt(i)==p_str.charAt(j))
				j++;
			if(j==lenP)
				return i-lenP+1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		String t_String="abcdabceabcegf";
		String p_String="abceg";
		int res=kmp(t_String, p_String);
		System.out.println(res);
	}

}
