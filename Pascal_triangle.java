public class Pascal {
	
	public static int factorial(int n) {
		if (n==0 || n==1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	public static int combi(int n, int r) {
		return (factorial(n) / (factorial(r)*factorial(n-r)));
	}
	
	public static void main(String args[]) {
		
		//#2
		int[][] raggedArray = new int[10][];
		
		for(int i=0;i<10;i++) {
			raggedArray[i] = new int[i+1];
		}
		
		//#3
		for(int i=0;i<10;i++) {
			for(int j=0; j<=i; j++)
				raggedArray[i][j] = combi(i,j);
		}
		
		//#4
		for(int i=0;i<10;i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(raggedArray[i][j]+" ");
			}
			System.out.println();
		}
				
	}
}
