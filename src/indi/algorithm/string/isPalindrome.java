package indi.algorithm.string;
import java.lang.Character;

public class isPalindrome {
	
	public static boolean isPalindrome(String string) {
		int lenS=string.length();
		int l=0;
		int r=lenS-1;
		String str=string.toLowerCase();
		while(l<=r){
			if(Character.isLetterOrDigit(str.charAt(l))&&Character.isLetterOrDigit(str.charAt(r))){
				if(str.charAt(l)==str.charAt(r)){
					l++;r--;
				}
				else {
					return false;
				}
			}
			else {
				if(!Character.isLetterOrDigit(str.charAt(l)))
					l++;
				if(!Character.isLetterOrDigit(str.charAt(r)))
					r--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t1="a,b,cbA";
		String t2="abcdcba";
		String t3="abdcba";
		String t4=",";
		System.out.println(isPalindrome(t1));
		System.out.println(isPalindrome(t2));
		System.out.println(isPalindrome(t3));
		System.out.println(isPalindrome(t4));
	}

}
