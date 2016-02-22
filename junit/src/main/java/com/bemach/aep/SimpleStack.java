package com.bemach.aep;

import java.util.ArrayList;

public class SimpleStack<T> {
	private ArrayList<T> stack;
	
	public SimpleStack() {
		stack = new ArrayList<T> ();
	}
	
	public int size() {
		return stack.size();
	}
	
	public void push(T object) {
		stack.add(object);
	}
	
	public T pop() {
		return stack.remove(size()-1);
	} 
} 
