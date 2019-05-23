package Estructures.linear_Structures;

import MyEstructures.Heap;
import MyEstructures.MyQueue;

public class PriorityQueue<V extends Comparable<V>> implements MyQueue<V> {
	MyEstructures.Heap<V> elements;
	
	public PriorityQueue (boolean Type) {
		elements = new Heap<>(Type);
	}

	@Override
	public void offer(V obj) {
		elements.add(obj);
	}

	@Override
	public V poll() {
		return elements.obtain();
	}

	@Override
	public V peek() {
		return elements.getTop();
	}
	
	public int getSize() {
		return elements.getSize();
	}

}

