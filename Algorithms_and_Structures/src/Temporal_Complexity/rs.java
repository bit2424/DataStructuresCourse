package Temporal_Complexity;

import java.util.Arrays;

public class rs {

	public static void main(String[] args) {
		int A[] = {5,40,10,101};
		int D = 3;
		for (int i = 1; i < D; i++) {
			int [] C = new int[10];
			
			for (int j = 0; j <= 9; j++) {
				C[j] = 0;
			}
			
			for (int j = 1; j < A.length; j++) {
				int k = posD(A[j],i);
				C[k] = C[k]+1;
			}
			
			for (int j = 1; j < C.length; j++) {
				C[j] = C[j] + C[j-1];
			}
			
			int B [] = new int[A.length];
			
			for (int j = B.length-1; j > 0; j--) {
				int k = posD(A[j], i);
				B[C[k]] = A[j];
				C[k] = C[k] - 1;
			}
			A = B;
		}
			
	}

	private static int posD(int a, int j) {
		String dato  = String.valueOf(a);
		int salida = Integer.parseInt(dato.charAt(j-1)+"");
		return salida;
	}

}
