package Test01;

public class Test01_04 {

	/*
	 * �����ַ�����ز���
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test01();
	}
	
	//�����ַ����Ĵ���
	public static void test01() {
		String s1 = new String("abc");
		String s2 = "abc";
		String s3 = s1.intern();		//�˷���Ŀ���ǽ���ǰ�ַ����е����ݷŵ��ַ��������أ�����Ѵ��ڳ������У��Ͳ����룬��󷵻س��������뱾�ַ���equalΪtrue���ַ���������
		String s4 = "abc";
		System.out.println(s3 == s4);
		
		System.out.println("-------------------------------------------------------");
		String s5 = String.valueOf(3.14);
		String s6 = String.copyValueOf(new char[] {'o','k','!'});
		System.out.println(s5);
		System.out.println(s6);
		System.out.println(new String(new byte[] {65,66,67})); 		//��д��ĸA��ascii����65��Сдa��97��Сд��ĸASCII����ڴ�д��ĸASCII�����32
		System.out.println(new String(new StringBuilder("stringbuilder")));
		System.out.println(s6.length());
		System.out.println(s6.charAt(0));
		System.out.println(s4.codePointAt(1));
		System.out.println(s4.codePointBefore(1));
		System.out.println("hahaha����".codePointCount(0, 8));			//codepoint������ָunicode�е�һ���ַ���һ���ַ�������2�ֽ�Ҳ������4�ֽ�
																		//�����2�ֽ�
		System.out.println("abc".compareToIgnoreCase("abC"));
	}
	
}
