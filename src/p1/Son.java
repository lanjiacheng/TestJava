package p1;

public class Son extends Super {
	public Son() {				//������������˴������Ĺ��췽����û���޲ι��췽������ô��������ڹ��췽������ʾʹ��super�ؼ��ָ����๹�췽�����ݲ���
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
