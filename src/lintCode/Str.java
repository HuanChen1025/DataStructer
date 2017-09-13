package lintCode;

public class Str {
	
	
	public static void main(String[] args) {
		String A="lintcode";
		String B =null;
		 int N =strStr_2(A, B);
		System.out.println(N);
		
		
		
	}
	
	
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int strStr(String source, String target) {
        // write your code here
   		//先判断输入是否为null，再判断字符串是否是空串
     		if(source==null||target==null){
     			
     			return -1;
     		}
     		
     		if(target.length()==0)
     			return 0;
     		if(source.equals(target))
     			return 0;
     
     	int [] a = new int [127];
     	int [] b = new int [127];
     	int result=1;
     	for (int i = 0; i < source.length(); i++) {
     		a[source.charAt(i)-0] +=1;
     		System.out.println(source.charAt(i)-0);
 			
 		}
     	System.out.println("------------------");
     	for(int j=0;j<target.length();j++){
     		b[target.charAt(j)-0]+=1;
     		
     		System.out.println(target.charAt(j)-0);
     	}
     	
     	for(int k=0;k<127;k++){
     		//System.out.println(a[k]-b[k]);
     		if(a[k]-b[k]<0)
     			result= -1;
     	}
     	
     	for(int i = 0; i < source.length(); i++){
     		
     		if(a[i]!=0 & b[i]!=0){
    
     			if(a[i]-b[i]==0)
     				
     				return i;
     			
     		}
     	}
     	
         
     	
     	return result;
    }
    
    /**
     * 首先判断字符串输入是否为null
     * 字符匹配首先想到的是两重for循环（其次KMP算法也行）
     * 不用遍历完所有的source长度，只需要遍历到target长度在source中的第一个位置
     * 然后遍历target 与 source 是否匹配，
     * 如果匹配，返回外层的i；如果不匹配，返回-1
     * @param source
     * @param target
     * @return int
     */
    public static int strStr_2(String source, String target) {
    	if(source==null||target==null)
    	{
    		return -1;
    	}
    	int i,j;
    	for(i=0;i<source.length()-target.length()+1;i++){
    		for(j=0;j<target.length();j++){
    			if(target.charAt(j)!=source.charAt(i+j))
    				break;
    		}
    		// 为什么不能放在for循环中呢？
    		if(j==target.length())
			{
				return i;
			}
    		
    		
    	}
    	return -1;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
