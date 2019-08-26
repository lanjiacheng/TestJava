package Test01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/*
 * ���������Լ����鹤�ߵ�ʹ��
 */
public class Test01_01 {
	public static void main(String[] args) {
		
//		test01();

//		test02();
		
		Integer[] arr = new Integer[] {1,2,3};
		Collection<Integer> list = Arrays.asList(arr); 
		Map<String,String> map = new HashMap();
		
		test03(list);
	}

	private static void test01() {
		// System.out.println("������ã�");
		// ��������ִ�������
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = new int[] { 4, 5, 6 };
		double arr3[] = new double[3]; // �����������û�г�ʼ��,��ô����Ԫ�ؽ��ᱻ��Ӧ���͵�Ĭ��ֵ���
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(new int[] { 1, 2, 3 });
		String[] arr4 = new String[] { "hello", "world", "java" };
		Object[] com = arr4; // ������ԷŴ�ת�����Ŵ�֮���Ԫ�ص����ͱ�����ԭ����Ԫ�����͵ĳ���
		System.out.println(Arrays.toString(com));
		System.out.println(Object[].class.getName()); // ����Ҳ��һ�����ͣ�����ʵ��Ҳ��һ�ֶ���ֻ����������ͶԳ���Ա���ɼ���
		System.out.println(1 << 13);
		System.out.println(Math.pow(2, 13));
	}

	private static void test02() {
		// ���Թ�����java.util.Arrays���÷�
		Random random = new Random();
		int[] arr = random.ints(10000).limit(20).toArray();
		System.out.println(Arrays.toString(arr));

		// ���򷽷�,�÷���ʹ��˫����������㷨ʵ��
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		// ���Բ���ǰ׺���㷽��
		int[] arr1 = new int[] { 1, 2, 3, 4 };
		Arrays.parallelPrefix(arr1, new IntBinaryOperator() {

			@Override
			public int applyAsInt(int left, int right) {
				// TODO Auto-generated method stub
				return left * right;
			}
		});
		System.out.println(Arrays.toString(arr1));

		// ���Զ��ֲ��ҷ�
		int[] arr2 = new int[] { 20, 2, 11, 4, 5, 10, 7, 80, 9, 90 };
		int index = Arrays.binarySearch(arr2, 80);
		System.out.println(index);

		// ����Arrays���equal����
		System.out.println(Arrays.equals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }));

		// ����Arrays���fill����
		Arrays.fill(arr2, 2);
		System.out.println(Arrays.toString(arr2));
		System.out.println(((Object) arr2).getClass() == int[].class);

		// ����Arrays��copyOf����
		System.out.println(new int[] { 1, 2 }.equals(new int[] { 1, 2 }));
		int[] arr3 = arr2;
		System.out.println(arr2 == arr3); // ���鲢û�и���equal��������̳�������equal����Ĭ����ʹ��==�����������
		System.out.println(arr2 == Arrays.copyOf(arr2, arr2.length));
		System.out.println(Arrays.toString(Arrays.copyOfRange(new int[] { 1, 2, 3 }, 0, 1)));

		// ����Arrays���asList����
		System.out.println(Arrays.asList("1", "2", "3").get(0).getClass());

		System.out.println(1 ^ 0);

		// ����Arrays���hashCode����
		System.out.println(Arrays.hashCode(new long[] { Long.MAX_VALUE, Long.MAX_VALUE - 1 }));
		System.out.println(Arrays.hashCode(new long[] { Long.MAX_VALUE - 3, Long.MAX_VALUE - 4 }));

		int[] o = new int[10];
		System.out.println(o instanceof Object); // ���������Ҳ���м̳й�ϵ��,����Integer[]�̳���Object[]�̳���Object

		System.out.println(new Object());
		System.out.println(new Object().hashCode());
		System.out.println(String.valueOf(new Object()));
		System.out.println(String.valueOf(1));

		// ����deepToString����
		System.out.println(Arrays.deepToString(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
		System.out.println(Arrays.toString(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));

		// setAll����
		int[] arr4 = new int[] { 1, 2, 3 };
		Arrays.setAll(arr4, new IntUnaryOperator() {

			@Override
			public int applyAsInt(int operand) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		System.out.println(Arrays.toString(arr4));

		// spliteraor����
		int[] arr5 = new int[] { 1, 2, 3, 4, 5 };
		java.util.Spliterator<Integer> spliterator = Arrays.spliterator(arr5);
		System.out.println(spliterator.tryAdvance(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		}));
		spliterator.tryAdvance(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		});
		java.util.Spliterator<Integer> spliterator2 = spliterator.trySplit();	//һ��Ϊ��������ǰ��ģ�����С1������ԭ���ľ�ʣ����ģ��Ѿ��������Ĳ���
//		spliterator.forEachRemaining(System.out::println);
		spliterator2.forEachRemaining((i)->System.out.println(i));
		
		//����stream
		Arrays.stream(arr5).limit(3).sorted().forEach(System.out::println);
	}
	
	//���Զ������
	public static <T> void test03(T...is) {
		
		//����������Ϊvoid xxx(Xx x)ʱ�������������������ʱ��x��һ����ͬ�ڴ�������������
		//����������Ϊ<T> void xxx(T x)ʱ�������������������ʱ��x��һ���Դ������������ΪԪ�����͵�����
		for(T i : is) {
			System.out.println(i);
		}
		System.out.println(is.getClass());
		int l = is.length;
		System.out.println((char)99);
		
	}
}
