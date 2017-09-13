package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {
	public static void main(String[] args) {
		String [] str ={"str","rst","mmt"};
		ArrayList<String> list = new ArrayList<String>();
		list = anagrams(str);
		for (String string : list) {
			System.out.println(string);
		}
		
	}

	
	public static ArrayList<String> anagrams(String[] strs) {
		       ArrayList<String> result=new ArrayList<String>();
		       
		      if (strs==null||strs.length==0)
		           return result;
		       //HashMap<K,V>
		       HashMap<String,ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		       //遍历字符串
		       for (String s:strs){
		          char[] temp=s.toCharArray();
		          //对字符数组排序
		          Arrays.sort(temp);
		          //将数组转换成字符串
		          String tempStr=new String(temp);
		          //如果在hashmap里面能够找到，不仅要存入到hashmap中，也需要存入到result中
		          if (hm.containsKey(tempStr)){
		        	  //如果存入的是第一个，不能进行对比，直接存入
		              if(hm.get(tempStr).size() == 1)
		                 result.add(hm.get(tempStr).get(0));
		              //hm.get(tempStr)返回的是ArrayList对象，然后对ArrayList调用add方法是可以的
		              hm.get(tempStr).add(s);
		              result.add(s);
		          }else{
		              ArrayList<String> tempList=new ArrayList<String>();
		              tempList.add(s);
		              hm.put(tempStr, tempList);
		              }
		         }
		         return result;

}
}
