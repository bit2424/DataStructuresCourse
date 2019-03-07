package TAD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problema_Ascendente {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr  = new BufferedWriter(new OutputStreamWriter(System.out));
		String entrada = br.readLine();
		String formato[] = entrada.split(" ");
		String entrada2 = br.readLine();
		int caso[] = new int[formato.length];
		int k = Integer.parseInt(entrada2);
		
		for (int i = 0; i < formato.length; i++) {
			caso[i] = Integer.parseInt(formato[i]);
		}
		
		int solucion[] = resolverCaso(caso,k);
		
		
				
	}

	private static int[] resolverCaso(int[] caso, int k) {
		int  lugar = 0;
		int sol[];
		Queue<Integer> almacen = new LinkedList<>();
		
		while(k>0 && lugar<caso.length-1) {
			System.out.println(caso[lugar] +" "+almacen.size());
			if(almacen.size() == 0 || caso[lugar]>caso[lugar+1]) {	
				if(caso[lugar]<caso[lugar+1]) {
					lugar++;
					k--;
				}else {
					almacen.offer(caso[lugar]);
					lugar++;
				}
			}else {
				System.out.println("Me ejecute");
				if(almacen.peek()<caso[lugar]) {
					almacen.poll();
					k--;
				}else {
					almacen.offer(caso[lugar]);
					lugar++;
				}
			}
		}
		sol = new int[almacen.size()+caso.length - lugar];
		for (int i = 0; i < sol.length; i++) {
			if(!almacen.isEmpty()) {	
				sol[i] = almacen.poll();
			}else {
				int a = caso[lugar];
				sol[i] = a;
				lugar++;
			}
		}
		System.out.println(Arrays.toString(sol));
		return null;
	}

}
