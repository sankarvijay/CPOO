package model.impl;

import model.exceptions.MonException;

public final class Finally {
	public static void f(int n) {
		try {
			System.out.println(n);
			throw new MonException();
		} catch (MonException e) {
			System.out.println("catch dans f, n=" + n);
		} finally {
			System.out.println("dans finally, n =" + n);
		}
	}

	public static void main(String[] args) {
		int n;
		f(1);
		f(2);
	}
}