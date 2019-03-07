package TAD;

public interface Numero<N1 extends Number,N2 extends Number> {

	//¿Constructores en la interfaz?
	
	public void cambiarNumerador(N1 p);
	
	public void CambiarDenominador(N2 q);
 	
	public N1 DarNumerador();
	
	public N2 DarDenominador();
	
	public Numero<N1,N2> Sumar(Numero<Number,Number> n);
	
	public Numero<N1,N2> Restar(Numero<Number,Number> n);
	
	public Numero<N1,N2> Multiplicar(Numero<Number,Number> n);
	
	public Numero<N1,N2> Division(Numero<Number,Number> n);

	
	
	
	
}
