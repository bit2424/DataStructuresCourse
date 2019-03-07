package TAD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Parentesis {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr  = new BufferedWriter(new OutputStreamWriter(System.out));
		String entradaC = br.readLine();
		int casos = Integer.parseInt(entradaC);
		for (int i = 0; i < casos; i++) {
			String entrada = br.readLine();
			String formato[] = entrada.split("");
			boolean solucion = resolverCaso(formato);
			
		}
	}

	private static boolean resolverCaso(String[] formato) {
		Stack<String> pila = new Stack<>();
		boolean solucion  = false;
		
		boolean seAcabo = false;
		
		for (int i = 0; i < formato.length && !seAcabo; i++) {
			if(formato[i].equals("{") || formato[i].equals("[") || formato[i].equals("(") ) {
				pila.push(formato[i]);
			}else if(formato[i].equals("}")){
				if(pila.empty()) {
					seAcabo = true;
				}
				String elem = pila.pop();
				if(!elem.equals("{")) {
					seAcabo = true;
					break;
				}
			}else if(formato[i].equals("]")){
				if(pila.empty()) {
					seAcabo = true;
				}
				String elem = pila.pop();
				if(!elem.equals("[")) {
					seAcabo = true;
				}
			}else if(formato[i].equals(")")){
				if(pila.empty()) {
					seAcabo = true;
				}
				String elem = pila.pop();
				if(!elem.equals("(")) {
					seAcabo = true;
				}
			}
		}
		
		int tipo = 0;
		
		
		if(pila.isEmpty() && !seAcabo) {
			solucion = true;
		}
		System.out.println(solucion);
		return solucion;
	}
}
