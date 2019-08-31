package p1;

public class Son extends Super {
	public Son() {				//如果父类声明了带参数的构造方法，没有无参构造方法，那么子类必须在构造方法中显示使用super关键字给父类构造方法传递参数
		super("");
		// TODO Auto-generated constructor stub
	}

	String name = "son";

	public void sayName() {
		System.out.println(name);
	}

	static void sayAge() {
		System.out.println("son 18 year");
	}
}
