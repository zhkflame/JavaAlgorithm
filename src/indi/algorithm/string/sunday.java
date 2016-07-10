package indi.algorithm.string;

public class sunday {
	
	public static int sunday(String t_str,String p_str){
		int lenT=t_str.length();
		int lenP=p_str.length();
		if(lenT<lenP)
			return -1;
		int[] moveLength=new int[256];
		for(int i=0;i<256;i++)
			moveLength[i]=lenP+1;
		for(int i=0;i<lenP;i++){
			moveLength[(int)p_str.charAt(i)]=lenP-i;
		}
		int m=lenT-lenP+1;
		int i=0;
		while(i<m){
			if(t_str.charAt(i)==p_str.charAt(0)){
				int x=i+1;
				int y=1;
				while(y<lenP && t_str.charAt(x)==p_str.charAt(y)){
					x=x+1;
					y=y+1;
				}
				if(y==lenP)
					return i;
				if(t_str.charAt(x)!=p_str.charAt(y)){
					if (i+lenP<lenT)
						i=i+moveLength[(int)t_str.charAt(i+lenP)];
					else 
						return -1;
				}								
			}
			else 
				i=i+1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		String t_String="abcdabceabcegf";
		String p_String="bce";
		int res=sunday(t_String, p_String);
		System.out.println(res);
	}

}
