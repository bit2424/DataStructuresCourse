package Divide_and_Conquer;

import java.math.BigInteger;

import javafx.scene.transform.Scale;

public class Karatsuba {

	public static void main(String[] args) {
		
		System.out.println(Karatsuba("232342342365645683429834928342423423","114233434512345235345895464"));
	}
	
	 public static String Karatsuba(String num1, String num2) {
		
		 
		BigInteger a;
		BigInteger b;
		BigInteger c;
		BigInteger d;
		int size = 0;
		if(num1.length() == 1 && num2.length() == 1) {
			return String.valueOf(Integer.parseInt(num1)*Integer.parseInt(num2));
		}else if(num1.length() > 1 && num2.length() == 1) {
			String raw_a = num1.substring(0, (int) Math.floor(num1.length()/2));
			String raw_b = num1.substring((int)Math.floor(num1.length()/2),num1.length());
			a = new BigInteger(raw_a);
			b = new BigInteger(raw_b);
			c = new BigInteger("0");
			d = new BigInteger(num2);
			size =  num1.length();
		}else if(num2.length() > 1 && num1.length() == 1) {
			String raw_c = num2.substring(0, (int) Math.floor(num2.length()/2));
			String raw_d = num2.substring((int)Math.floor(num2.length()/2),num2.length());
			a = new BigInteger("0");
			b = new BigInteger(num1);
			c = new BigInteger(raw_c);
			d = new BigInteger(raw_d);
			size =  num2.length();
		}else {
			String raw_a = num1.substring(0, (int) Math.floor(num1.length()/2));
			String raw_b = num1.substring((int)Math.floor(num1.length()/2),num1.length());
			String raw_c = num2.substring(0, (int) Math.floor(num2.length()/2));
			String raw_d = num2.substring((int)Math.floor(num2.length()/2),num2.length());
			a =  new BigInteger(raw_a);
			b =  new BigInteger(raw_b);
			c =  new BigInteger(raw_c);
			d =  new BigInteger(raw_d);
			if(num1.length()>num2.length()) {

				size =  num1.length();
			}else {

				size =  num2.length();
			}
		}
		
		BigInteger ac =  new BigInteger(Karatsuba(a.toString(),c.toString()));
	    BigInteger bd = new BigInteger(Karatsuba(b.toString(),d.toString()));
	    BigInteger Sacbd = new BigInteger(Karatsuba((a.add(b)).toString() , (c.add(d)).toString()));
		Sacbd = Sacbd.subtract(ac);
		Sacbd = Sacbd.subtract(bd);
		
		BigInteger e1 = new BigInteger(String.valueOf(((int)Math.pow(10,size))));
		BigInteger e2 = new BigInteger(String.valueOf((int)Math.pow(10,size/2)));
		
		BigInteger result = ac.multiply(e1);
		result = result.add(Sacbd.multiply(e2));
		result = result.add(bd);
		
		return result.toString();
	}

}
