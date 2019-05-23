package Estructures.linear_Structures;
import MyEstructures.MyHashMap;
import MyEstructures.NodoHash;

import java.lang.System;

public class HashMap<K,V> implements MyHashMap<K, V> {
	
	private Object container[] = new Object[1000000];
	int size;
	
	@Override
	public void put(K key, V value) {
		size++;
		int P = ((key).hashCode() % container.length);
		int c = VerifyCollisions(P);
		container[c] = new NodoHash<K,V>(key,value);
//		System.out.println(container[c] + " " + c);
	}
	
	//Double-Hashing 
	private int VerifyCollisions(int p) {
		int a = p;
		while(container[a] != null){
//			System.out.println(a);
			a = (java.util.Objects.hash(2, a)%container.length);
		}
		return a;
	}

	@Override
	public V get(K key) {
		int a = (key).hashCode() % container.length;
		while(container[a] != null && !((NodoHash)container[a]).getActualkey().equals(key) ){
			a = (java.util.Objects.hash(2, a)%container.length);
		}
		if(container[a] == null) {
			return null;
		}
		return (V)((NodoHash)container[a]).getValue();
	}

	@Override
	public boolean contains(K key) {
		
		int a = (key).hashCode() % container.length;
		
		while(container[a] != null && !((NodoHash)container[a]).getActualkey().equals(key)){
			a = (java.util.Objects.hash(2, a)%container.length);
		}
		
		if(container[a] == null) {
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean delete(K key) {
		size--;
		int a = (key).hashCode() % container.length;
		while(container[a] != null && !((NodoHash)container[a]).getActualkey().equals(key)){
			a = (java.util.Objects.hash(2, a)%container.length);
		}
		if(container[a] != null) {
			container[a] = null;
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}


	public void changeValue(K key, V value) {
		int a = (key).hashCode() % container.length;
		while(container[a] != null && !((NodoHash)container[a]).getActualkey().equals(key)){
			a = (java.util.Objects.hash(2, a)%container.length);
		}
		container[a] = new NodoHash<K, V>(key, value);
		
		
	}

}
