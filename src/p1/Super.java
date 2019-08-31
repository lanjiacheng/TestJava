package p1;

public class Super {
	String name = "super";
	public Super(String name){
		this.name = name;
	}
	public void sayName() {
		System.out.println(name);
	}
	static void sayAge() {
		System.out.println("super 18 year");
	}
}
