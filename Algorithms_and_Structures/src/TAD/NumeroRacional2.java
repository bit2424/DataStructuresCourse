//package TAD;
//
//public class NumeroRacional2<N1 extends Number,N2 extends Number> implements Numero<N1,N2>{
//	N1 p;
//	N2 q;
//	// ¿Por qué no puedo ponerle los dos tiposde datos que quiero que sea?
//	// ¿El N1 y el N2 de Numero Racional y el de numero deben ser el mismo?
//	
//	public NumeroRacional2(Number p,Number q) {
//		this.p =  (N1) p;
//		this.q =  (N2) q;
//	}
//
//	@Override
//	public void cambiarNumerador(Number p) {
//		this.p = (N1)p;
//	}
//
//	@Override
//	public void CambiarDenominador(Number q) {
//		this.q = (N2)q; 
//	}
//
//	@Override
//	public N1 DarNumerador() {
//		return p;
//	}
//
//	@Override
//	public N2 DarDenominador() {
//		return q;
//	}
//
//	@Override
//	public Numero<N1,N2> Sumar(Numero<N1,N2> n) {
//		return new NumeroRacional<N1,N2>(q.intValue() + (n.DarDenominador()).intValue(),q.intValue() + n.DarDenominador().intValue());
//	}
//
//	@Override
//	public Numero<N1,N2> Restar(Numero<N1,N2> n) {
//		return new NumeroRacional<N1,N2>(q.intValue() - (n.DarDenominador()).intValue(),q.intValue() - n.DarDenominador().intValue());
//		
//	}
//
//	@Override
//	public Numero<N1,N2> Multiplicar(Numero<N1,N2> n) {
//		return new NumeroRacional<N1,N2>(q.intValue() * (n.DarDenominador()).intValue(),q.intValue() * n.DarDenominador().intValue());
//		
//	}
//
//	@Override
//	public Numero<N1,N2> Division(Numero<N1,N2> n) {
//		if ((n.DarDenominador()).intValue() == 0) {
//			return null;
//		}
//		
//			return new NumeroRacional<N1,N2>(q.intValue() / (n.DarDenominador()).intValue(),q.intValue() / n.DarDenominador().intValue());
//	}
//
//	
//}
