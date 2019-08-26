package p1;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Son son = new Son();
//		son.sayAge();
//		((Super) son).sayAge();
//		System.out.println(son instanceof Super);
//		((Super) son).sayName();
//		System.out.println(((Super) son).name);
//		SuperInterface.NAME = "";
//		SuperInterface.sayName();
//		SuperInterface superInterface = new Son2();
//		superInterface.sayAge();
//		((SuperInterface2)superInterface).sayAge();
		System.out.println((100l + 3.14f));
	}
}

/*
 * 当继承中发生成员变量的遮盖时，一个成员方法调用了成员变量，用的是哪个类（子类或父类）中的成员变量（发生遮盖），是由执行的这个方法所在的类决定的（
 * 现在本类中找，没有就往上找）。
 * 当直接通过实例去访问被遮盖的成员变量时（如A.xx），访问到的是哪个类中的成员变量由当前实例的类型（不是实际类型）决定。如果B是A的父类，那么((B)A)
 * .xx访问到的是B中的成员变量。对于静态方法的调用机制也是和成员变量一样。
 * 
 * 接口隐式的方法修饰符：public abstract，接口隐式变量修饰符：public static final
 * 接口中可以有静态方法。也是public的，可以直接通过接口名和方法名调用。接口中的默认方法不用实现，但要在子类中才能调用。
 * 当一个类实现了两个接口，并且两接口中有相同的抽象方法时，那么这个类只需要覆盖抽象方法一次，就同时覆盖了两个接口中的两个抽象方法，具体调用哪个方法，
 * 看当前的实例的声明类型。 在覆盖方法中调用一个接口中定义的常量，如果实现的多个接口都有同名常量，那么报错，因为模糊调用，一般需要加上接口限定。
 * 
 * 当一个抽象类实现部分几口的方法，又一个类继承抽象类，那么这个类只需要实现抽象类中没有实现的接口的方法。
 * 如果抽象类B部分实现A，并且C继承B且实现A，那么C只用实现B未实现的A中的方法，并且发生覆盖。
 */