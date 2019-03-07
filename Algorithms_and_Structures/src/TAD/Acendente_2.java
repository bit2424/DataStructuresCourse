package TAD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Acendente_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr  = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String casos1 = br.readLine();
		int casos = Integer.parseInt(casos1);
		
		for (int j = 0; j < casos; j++) {

			String entrada2 = br.readLine();
			
			String entrada = br.readLine();
			String formato[] = entrada.split(" ");
			
			int caso[] = new int[formato.length];
			
			
			for (int i = 0; i < formato.length; i++) {
				caso[i] = Integer.parseInt(formato[i]);
			}
			
			entrada2 = br.readLine();
			
			int k = Integer.parseInt(entrada2);
			
			int solucion[] = resolverCaso(caso,k);
		}
			
		
		
				
	}

	private static int[] resolverCaso(int[] caso, int k) {
		int sol[];
		
		if(caso.length == 1){
			System.out.println(caso[0]);
			return caso;
		}
		Stack<Integer> almacen = new Stack<>();
		Stack<Integer> numeros = new Stack<>();
		
		for (int I = caso.length-1; I >= 0 ; I--) {
			numeros.push(caso[I]);
		}
		
		boolean Acomparar = false;
		
		while(k>0 && numeros.size()>0 ) {
		
				if(Acomparar && !almacen.isEmpty()) {
					int ref = almacen.pop();
					if(!numeros.isEmpty() && ref<numeros.peek()){
						k--;
						Acomparar = true;
					}else {
						almacen.push(ref);
						Acomparar = false;
					}
				}else{
					int ref = numeros.pop();
					if(!numeros.isEmpty() && ref<numeros.peek()){
						k--;
						Acomparar = true;
					}else {
						almacen.push(ref);
						Acomparar = false;
					}
				}
			
		}
		sol = new int[almacen.size()+numeros.size()];
		for (int i = sol.length-1; i >= 0; i--) {
			if(!numeros.isEmpty()) {	
				sol[almacen.size()+sol.length-i-1] = numeros.pop();
			}else {
				sol[i] = almacen.pop();
			}
		}
		for (int i = 0; i < sol.length; i++) {
			System.out.print(sol[i]);
			if(i != sol.length-1) {
				System.out.print(" ");
			}
		}
		System.out.println();
		
		return sol;
	}

}
