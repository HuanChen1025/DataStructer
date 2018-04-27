package Interview.JD;



	public class Infinite {
	    /*
	     * @param A: A string
	     * @param B: A string
	     * @return: if string A contains all of the characters in B return true else return false
	     */
		public static void main(String[] args) {
			System.out.println("第5050项是"+fun(5050));
			System.out.println("第5050项是"+funcc(5050));

			System.out.println(Math.pow(2, 7));
			
		}
		
		public static int fun(int n){
			
			return (int)Math.sqrt(2*n);
		}
		
		
		public static int funcc(int n){
			
			int result=0;
			int j=0;
			for (int i = 0; i*(i-1)/2<n; i++) {
				j++;
				if(i*(i+1)/2>=n) //此处要大于等于，否则输入每个K开始时的数会输出0
					result= i;
			}
			System.out.println(j);
			return result;
		}
		
		
		public static int funccc(int n){
			
			
			return 0;
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}


