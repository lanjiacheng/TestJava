package Test01;

public class Test01_04 {

	/*
	 * 测试字符串相关操作
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test01();
	}
	
	//测试字符串的创建
	public static void test01() {
		String s1 = new String("abc");
		String s2 = "abc";
		String s3 = s1.intern();		//此方法目的是将当前字符串中的内容放到字符串常量池，如果已存在常量池中，就不放入，最后返回常量池中与本字符串equal为true的字符串的引用
		String s4 = "abc";
		System.out.println(s3 == s4);
		
		System.out.println("-------------------------------------------------------");
		String s5 = String.valueOf(3.14);
		String s6 = String.copyValueOf(new char[] {'o','k','!'});
		System.out.println(s5);
		System.out.println(s6);
		System.out.println(new String(new byte[] {65,66,67})); 		//大写字母A的ascii码是65，小写a是97，小写字母ASCII码等于大写字母ASCII码加上32
		System.out.println(new String(new StringBuilder("stringbuilder")));
		System.out.println(s6.length());
		System.out.println(s6.charAt(0));
		System.out.println(s4.codePointAt(1));
		System.out.println(s4.codePointBefore(1));
		System.out.println("hahaha哈哈".codePointCount(0, 8));			//codepoint概念是指unicode中的一个字符，一个字符可能是2字节也可能是4字节
																		//大多是2字节
		System.out.println("abc".compareToIgnoreCase("abC"));
	}
	
}
