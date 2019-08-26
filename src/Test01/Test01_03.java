package Test01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test01_03 {
	
	int i;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test01();
//		test02();
		try {
			test03();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//测试stream的collect方法以及java.util.stream.Collectors里面的收集器
	public static void test01() {
		int[] arr1 = new int[] {1,2,3,4,5};
		int[] arr2 = Arrays.stream(arr1).collect(()->new int[] {0}, (a,x)->a[0] += x, (a1,a2)->a1[0]+=a2[0]);
		System.out.println(Arrays.toString(arr2));
		String[] arr3 = new String[] {"a","b","c"};
//		Arrays.asList(arr3).forEach(Integer::valueOf);
		
		Integer[] arr4 = new Integer[] {1,2,3,4,5};
		double d = Arrays.asList(arr4).stream().collect(Collectors.averagingInt((i)->i));
		System.out.println(d);
		
		Map<String, Integer> map1 = Arrays.asList(arr4).stream().collect(Collectors.toMap((k)->"key_"+k, (v)->v));
		int resoult1 = Arrays.asList(arr4).stream().collect(Collectors.minBy((a,b)->a-b)).get();
		//如果lambda表达式只有一个参数时，括号可以省略
		Map<Boolean, List<Integer>> map2 = Arrays.asList(arr4).stream().collect(Collectors.groupingBy(t->t>3));
		int resoult2 = Arrays.stream(arr4).collect(Collectors.reducing((a,b)->a+b)).get();
		
		System.out.println(map1);
		System.out.println(resoult1);
		System.out.println(map2);
		System.out.println(resoult2);
	}
	
	//测试stream的其他方法 
	public static void test02() {
		int[] arr1 = new int[] {1,2,3,4,5};
		System.out.println(Arrays.stream(arr1).reduce((a,b)->a+b).getAsInt());
		System.out.println(Arrays.stream(arr1).parallel().reduce(0,(a,b)->a+b));		//并行计算，每个线程都会计算上indentity，最后汇总，多出线程数*indentity
		Arrays.stream(arr1).forEach(System.out::println);
		System.out.println(Arrays.stream(arr1).sum());
		System.out.println(Arrays.stream(arr1).summaryStatistics());
		System.out.println(Arrays.stream(arr1).allMatch((i)->i>0));
		System.out.println(Arrays.stream(arr1).findFirst().getAsInt());
		System.out.println("-------------------------------------------");
		//peek方法，是在每一个元素上添加同一个消费action然后返回返回一个流，每当在返回的流中消费一个对象之前，之前添加的action就会被触发
		IntStream intStream = Arrays.stream(arr1).peek((x)->System.out.println(x+"peek"));
		intStream.forEach(System.out::println);
		System.out.println("---------------------------------------------");
		IntStream intStream2 = Arrays.stream(arr1);
//		intStream2.close();
		intStream2.forEach(System.out::println);
		intStream2.count();
		intStream.close();
	}
	
	//测试stream用完是否自动关闭
	public static void test03() throws InterruptedException {
		Thread.sleep(10000);
		System.gc();
		Thread.sleep(5000);
		int[] arr1 = new int[1024*1024*2];			//8m内存
		Thread.sleep(5000);
		IntStream intStream = Arrays.stream(arr1);
		Thread.sleep(5000);
		arr1 = null;
		System.gc();
		Thread.sleep(5000);
//		intStream.sum();
//		intStream.close();
		intStream.filter(i->i>0).filter(i->i>0).sum();
//		IntStream intStream2 = intStream.filter(i->i>0);
//		intStream2.close();
//		intStream.close();
//		intStream2 = null;
//		intStream = null;
		
		Thread.sleep(5000);
		System.gc();
		Thread.sleep(5000);
		
		/*
		 * 通过jvisualvm测试，得出结论：
		 * 1.当创建一个数组的流时，流只是得到了数组的一个引用，并没有额外创建一个新的数组。因此只消耗了创建一个数组的内存。
		 * 2.当消费完单个流中的内容时（比如遍历完一个流或调用流的sum、allMatch等方法），那么这个流自身会被关闭，或者说是放弃对它持有的资源（比如一个数组）的引用，并且不能再使用，否者报错。
		 * 		也可以说，当一个流的内容被消费完的时候，这个流本身会自动close，无需手动close。
		 * 3.对流调用返回新流的方法时（如filter方法），原来的流将不能再使用，否则报错，但是原来的流不会放弃对资源的引用，因为此时还没有计算（惰性），新流也不会使用额外内存空间。
		 * 4.在多次链式调用流方法中，不会流不会预先计算，直到遇到终结方法，此过程不会消耗额外的内存，只消耗持有的资源所占的内存，被调用过的流不能再使用（否则报错），但它不会放弃对资源的引用。
		 * 5.让一个流放弃对资源的引用（这样资源才能被垃圾收集器回收，释放内存）的方式：
		 * 		(1)调用流的close方法
		 * 		(2)设置流为null
		 * 		(3)在链式调用中给最后一个流调用终结方法。
		 */
	}

}