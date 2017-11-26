package model.impl;

import model.exceptions.MonException;

public class Finally2 {
	public static void f(int n) throws MonException {
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
		int n = 0;
		try {
			for (n = 1; n < 5; n++) {
				f(n);
			}
		} catch (MonException e) {
			System.out.println("catch dans main - n=" + n);
		} finally {
			System.out.println("dans finally de main - n=" + n);
		}
	}
}
