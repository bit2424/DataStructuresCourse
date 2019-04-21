package Divide_and_Conquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Find_the_number {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		int cases = Integer.parseInt(br.readLine());
		
		for(int I = 0; I<cases ; I++) {
			wr.write(String.valueOf(SolveCase()) + "\n");
		}
		
		wr.flush();
		
	}
	private static int SolveCase() throws NumberFormatException, IOException {
		int elements = Integer.parseInt(br.readLine());
		
		int original_Numbers[] = new int[elements];

		int change_Numbers[] = new int[elements + 1];
		
		for (int i = 0; i < change_Numbers.length-1; i++) {
			String data[] = br.readLine().split(" ");
			original_Numbers[i] = Integer.parseInt(data[1]);
			change_Numbers[i] = Integer.parseInt(data[0]);
		}
		
		change_Numbers[elements] = Integer.parseInt(br.readLine());
		
		int index = divide_and_conquer(original_Numbers,change_Numbers,0,original_Numbers.length-1);
		
		if(original_Numbers[index] == change_Numbers[index]) {
			index = elements;
		}
		
		return index;
	}
	
	
	private static int divide_and_conquer(int[] original_Numbers, int[] change_Numbers, int start, int end) {
		int mid = (int) Math.floor((start+end)/2);
		if(start == end) {
			return start;
		}
		
		boolean goRight = original_Numbers[mid+1] == change_Numbers[mid+1];
		boolean goLeft = original_Numbers[mid] == change_Numbers[mid];
		
		int solve = -1;
		
		if(!goRight && goLeft) {
			solve = mid+1;
		}else if(goRight && goLeft) {
			solve = divide_and_conquer(original_Numbers, change_Numbers, mid+1, end);
		}else {
			solve = divide_and_conquer(original_Numbers, change_Numbers, start,mid);
		}
		
		return solve;
	}
}
