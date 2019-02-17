package Images;

public class A {
	{
		System.out.println("instance block");
	}
	
	A()
	{
		System.out.println("Constructor");
	}
	
	public static void main(String[] args) {
		A a = new A();
		A a1 = new A();
	}

}
