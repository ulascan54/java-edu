package earth;

public class B extends A{
	public void fun() {
		// x++; error: x is private in A
		y++;
		z++;
		u++;
	}
}
