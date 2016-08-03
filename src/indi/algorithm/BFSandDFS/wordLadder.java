package indi.algorithm.BFSandDFS;

import java.awt.print.Printable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class wordLadder {
	
	public static int ladderLength(String a,String b,Set dic) {
		if(a==b)
			return 1;
		dic.add(b);
		Map<String,Integer> wordmap=new HashMap<String,Integer>();
		wordmap.put(a, 1);
		myArrayQueue myQueue=new myArrayQueue(20);
		myQueue.push(a);
		while (!myQueue.isEmpty()) {
			String str=(String)myQueue.pop();
			int step=wordmap.get(str)+1;
			int len=str.length();
			for(int i=0;i<len;i++){
				for(int j='a';j<='z';j++){
					char t=(char)j;
					String temp=String.valueOf(t);
					if(t!=str.charAt(i)){
						StringBuilder tempWord=new StringBuilder(str);
						tempWord.replace(i, i+1, temp);
						String tempstr=tempWord.toString();
						//System.out.println(tempstr);
						if(dic.contains(tempstr) && !wordmap.containsKey(tempstr)){
							if(tempstr.equals(b)){
								System.out.println("success");
								//System.out.println(step);
								return step;
							}
							wordmap.put(tempstr, step);
							myQueue.push(tempstr);
							System.out.println(tempstr+"  "+ step);
						}
						
						
					}
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		String aString="abcd";
		String bString="defc";
		Set dic=new HashSet<>();
		dic.add("aecd");
		dic.add("abfd");
		dic.add("decd");
		dic.add("defd");
		dic.add("abfc");
		dic.add("aefc");
		//for(Iterator iterator=dic.iterator();iterator.hasNext();){
		//	System.out.println(iterator.next());
		//}
		int l=ladderLength(aString, bString, dic);
		System.out.println(l);
	}
}
