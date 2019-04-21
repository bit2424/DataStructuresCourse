package Divide_and_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Creative_Snap {
	public static long priceNoAvangers;
	public static long priceWithAvangers;
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String data[] = br.readLine().split(" ");
		
		long p_Size = (long)Math.pow(2,Integer.parseInt(data[0]));
		long n_avangers = Long.parseLong(data[1]);
		priceNoAvangers = Long.parseLong(data[2]);
		priceWithAvangers = Long.parseLong(data[3]);
		
		boolean base[] = new boolean[(int)p_Size];
		
		String data2[] = br.readLine().split(" ");
		
		for(int I=0;I<data2.length; I++) {
			base[Integer.parseInt(data2[I])-1] = true;
		}
		
		int solution = Destroy(base, 0, base.length-1)[1];
		System.out.println(solution);
	}

	private static int[] Destroy(boolean[] base, int start, int finish) {
		int solve[] = new int[2];
		if(start == finish) {
			if(base[start]) {
				solve[0] = 1;
				solve[1] = (int)priceWithAvangers;
			}else {
				solve[0] = 0;
				solve[1] = (int)priceNoAvangers;
			}

			return solve;
		}
		
		int mid = (int)Math.floor((start+finish)/2);
		int solveLeft[] = Destroy(base, start,mid);
		int solveRight[] = Destroy(base,mid+1,finish);
		
		if(solveLeft[0]+solveRight[0] == 0) {
			solve[0] += 0;
			solve[1] += (long)Math.min(priceNoAvangers, solveLeft[1] + solveRight[1]);
		}else {
			solve[0] += solveLeft[0] + solveRight[0];
			solve[1] += (long)Math.min(priceWithAvangers*(solveLeft[0] + solveRight[0])*(finish-start+1), solveLeft[1] + solveRight[1]);
			
		}
		
		return solve;
	}
}
