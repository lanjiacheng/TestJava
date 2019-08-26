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
 * 测试数组以及数组工具的使用
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
		// System.out.println("数组你好！");
		// 数组的三种创建方法
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = new int[] { 4, 5, 6 };
		double arr3[] = new double[3]; // 如果创建数组没有初始化,那么数组元素将会被对应类型的默认值填充
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(new int[] { 1, 2, 3 });
		String[] arr4 = new String[] { "hello", "world", "java" };
		Object[] com = arr4; // 数组可以放大转换，放大之后的元素的类型必须是原来的元素类型的超类
		System.out.println(Arrays.toString(com));
		System.out.println(Object[].class.getName()); // 数组也是一种类型，数组实例也是一种对象，只不过这个类型对程序员不可见。
		System.out.println(1 << 13);
		System.out.println(Math.pow(2, 13));
	}

	private static void test02() {
		// 测试工具类java.util.Arrays的用法
		Random random = new Random();
		int[] arr = random.ints(10000).limit(20).toArray();
		System.out.println(Arrays.toString(arr));

		// 排序方法,该方法使用双枢快速排序算法实现
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		// 测试并行前缀计算方法
		int[] arr1 = new int[] { 1, 2, 3, 4 };
		Arrays.parallelPrefix(arr1, new IntBinaryOperator() {

			@Override
			public int applyAsInt(int left, int right) {
				// TODO Auto-generated method stub
				return left * right;
			}
		});
		System.out.println(Arrays.toString(arr1));

		// 测试二分查找法
		int[] arr2 = new int[] { 20, 2, 11, 4, 5, 10, 7, 80, 9, 90 };
		int index = Arrays.binarySearch(arr2, 80);
		System.out.println(index);

		// 测试Arrays类的equal方法
		System.out.println(Arrays.equals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }));

		// 测试Arrays类的fill方法
		Arrays.fill(arr2, 2);
		System.out.println(Arrays.toString(arr2));
		System.out.println(((Object) arr2).getClass() == int[].class);

		// 测试Arrays的copyOf方法
		System.out.println(new int[] { 1, 2 }.equals(new int[] { 1, 2 }));
		int[] arr3 = arr2;
		System.out.println(arr2 == arr3); // 数组并没有覆盖equal方法，其继承下来的equal方法默认是使用==运算符来计算
		System.out.println(arr2 == Arrays.copyOf(arr2, arr2.length));
		System.out.println(Arrays.toString(Arrays.copyOfRange(new int[] { 1, 2, 3 }, 0, 1)));

		// 测试Arrays类的asList方法
		System.out.println(Arrays.asList("1", "2", "3").get(0).getClass());

		System.out.println(1 ^ 0);

		// 测试Arrays类的hashCode方法
		System.out.println(Arrays.hashCode(new long[] { Long.MAX_VALUE, Long.MAX_VALUE - 1 }));
		System.out.println(Arrays.hashCode(new long[] { Long.MAX_VALUE - 3, Long.MAX_VALUE - 4 }));

		int[] o = new int[10];
		System.out.println(o instanceof Object); // 数组的类型也是有继承关系的,比如Integer[]继承自Object[]继承自Object

		System.out.println(new Object());
		System.out.println(new Object().hashCode());
		System.out.println(String.valueOf(new Object()));
		System.out.println(String.valueOf(1));

		// 测试deepToString方法
		System.out.println(Arrays.deepToString(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
		System.out.println(Arrays.toString(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));

		// setAll方法
		int[] arr4 = new int[] { 1, 2, 3 };
		Arrays.setAll(arr4, new IntUnaryOperator() {

			@Override
			public int applyAsInt(int operand) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		System.out.println(Arrays.toString(arr4));

		// spliteraor方法
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
		java.util.Spliterator<Integer> spliterator2 = spliterator.trySplit();	//一分为二，返回前面的（可能小1个），原来的就剩后面的，已经迭代过的不算
//		spliterator.forEachRemaining(System.out::println);
		spliterator2.forEachRemaining((i)->System.out.println(i));
		
		//测试stream
		Arrays.stream(arr5).limit(3).sorted().forEach(System.out::println);
	}
	
	//测试多个参数
	public static <T> void test03(T...is) {
		
		//当方法声明为void xxx(Xx x)时，给方法传入数组参数时，x是一个等同于传入的数组的数组
		//当方法声明为<T> void xxx(T x)时，给方法传入数组参数时，x是一个以传入的数组类型为元素类型的数组
		for(T i : is) {
			System.out.println(i);
		}
		System.out.println(is.getClass());
		int l = is.length;
		System.out.println((char)99);
		
	}
}
