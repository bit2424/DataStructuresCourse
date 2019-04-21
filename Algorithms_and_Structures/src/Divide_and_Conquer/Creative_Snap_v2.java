package Divide_and_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Creative_Snap_v2 {
	public static long priceNoAvangers;
	public static long priceWithAvangers;
	public static int base[];
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String data[] = br.readLine().split(" ");
		
		long p_Size = (long)Math.pow(2,Integer.parseInt(data[0]));
		long n_avangers = Long.parseLong(data[1]);
		priceNoAvangers = Long.parseLong(data[2]);
		priceWithAvangers = Long.parseLong(data[3]);
		
		base = new int[(int)p_Size];
		
		String data2[] = br.readLine().split(" ");
		
		for(int I=0;I<data2.length; I++) {
			base[Integer.parseInt(data2[I])-1] = 1;
		}
		
		int solution = Destroy( 0, base.length-1);
		System.out.println(solution);
	}

	private static int Destroy(int start, int finish) {
		int solve = 0;
		if(start == finish) {
			if(base[start] != 0) {
				return(int)priceWithAvangers;
			}else {
				return (int)priceNoAvangers;
			}
		}
		
		int mid = (int)Math.floor((start+finish)/2);
		int solveLeft = Destroy(start,mid);
		int solveRight = Destroy(mid+1,finish);
		
		if(base[mid]+base[mid+1] == 0) {
			solve += (long)Math.min(priceNoAvangers, solveLeft + solveRight);
		}else {
			solve += (long)Math.min(priceWithAvangers*(base[mid]+base[mid+1])*(finish-start+1), solveLeft + solveRight);
			int a =  base[mid]+base[mid+1];
			base[finish] = a;
			base[start] = a;
		}
		
		return solve;
	}
}
