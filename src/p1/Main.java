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
 * ���̳��з�����Ա�������ڸ�ʱ��һ����Ա���������˳�Ա�������õ����ĸ��ࣨ������ࣩ�еĳ�Ա�����������ڸǣ�������ִ�е�����������ڵ�������ģ�
 * ���ڱ������ң�û�о������ң���
 * ��ֱ��ͨ��ʵ��ȥ���ʱ��ڸǵĳ�Ա����ʱ����A.xx�������ʵ������ĸ����еĳ�Ա�����ɵ�ǰʵ�������ͣ�����ʵ�����ͣ����������B��A�ĸ��࣬��ô((B)A)
 * .xx���ʵ�����B�еĳ�Ա���������ھ�̬�����ĵ��û���Ҳ�Ǻͳ�Ա����һ����
 * 
 * �ӿ���ʽ�ķ������η���public abstract���ӿ���ʽ�������η���public static final
 * �ӿ��п����о�̬������Ҳ��public�ģ�����ֱ��ͨ���ӿ����ͷ��������á��ӿ��е�Ĭ�Ϸ�������ʵ�֣���Ҫ�������в��ܵ��á�
 * ��һ����ʵ���������ӿڣ��������ӿ�������ͬ�ĳ��󷽷�ʱ����ô�����ֻ��Ҫ���ǳ��󷽷�һ�Σ���ͬʱ�����������ӿ��е��������󷽷�����������ĸ�������
 * ����ǰ��ʵ�����������͡� �ڸ��Ƿ����е���һ���ӿ��ж���ĳ��������ʵ�ֵĶ���ӿڶ���ͬ����������ô��������Ϊģ�����ã�һ����Ҫ���Ͻӿ��޶���
 * 
 * ��һ��������ʵ�ֲ��ּ��ڵķ�������һ����̳г����࣬��ô�����ֻ��Ҫʵ�ֳ�������û��ʵ�ֵĽӿڵķ�����
 * ���������B����ʵ��A������C�̳�B��ʵ��A����ôCֻ��ʵ��Bδʵ�ֵ�A�еķ��������ҷ������ǡ�
 */