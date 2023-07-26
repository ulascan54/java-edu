package moon;

import earth.A;

public class C extends A{
	public void fun() {
		// x++; error: x is private in A
		y++;
		z++;
		// u++; error: u is package private in A
	}
}
