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
	
	//����stream��collect�����Լ�java.util.stream.Collectors������ռ���
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
		//���lambda���ʽֻ��һ������ʱ�����ſ���ʡ��
		Map<Boolean, List<Integer>> map2 = Arrays.asList(arr4).stream().collect(Collectors.groupingBy(t->t>3));
		int resoult2 = Arrays.stream(arr4).collect(Collectors.reducing((a,b)->a+b)).get();
		
		System.out.println(map1);
		System.out.println(resoult1);
		System.out.println(map2);
		System.out.println(resoult2);
	}
	
	//����stream���������� 
	public static void test02() {
		int[] arr1 = new int[] {1,2,3,4,5};
		System.out.println(Arrays.stream(arr1).reduce((a,b)->a+b).getAsInt());
		System.out.println(Arrays.stream(arr1).parallel().reduce(0,(a,b)->a+b));		//���м��㣬ÿ���̶߳��������indentity�������ܣ�����߳���*indentity
		Arrays.stream(arr1).forEach(System.out::println);
		System.out.println(Arrays.stream(arr1).sum());
		System.out.println(Arrays.stream(arr1).summaryStatistics());
		System.out.println(Arrays.stream(arr1).allMatch((i)->i>0));
		System.out.println(Arrays.stream(arr1).findFirst().getAsInt());
		System.out.println("-------------------------------------------");
		//peek����������ÿһ��Ԫ�������ͬһ������actionȻ�󷵻ط���һ������ÿ���ڷ��ص���������һ������֮ǰ��֮ǰ��ӵ�action�ͻᱻ����
		IntStream intStream = Arrays.stream(arr1).peek((x)->System.out.println(x+"peek"));
		intStream.forEach(System.out::println);
		System.out.println("---------------------------------------------");
		IntStream intStream2 = Arrays.stream(arr1);
//		intStream2.close();
		intStream2.forEach(System.out::println);
		intStream2.count();
		intStream.close();
	}
	
	//����stream�����Ƿ��Զ��ر�
	public static void test03() throws InterruptedException {
		Thread.sleep(10000);
		System.gc();
		Thread.sleep(5000);
		int[] arr1 = new int[1024*1024*2];			//8m�ڴ�
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
		 * ͨ��jvisualvm���ԣ��ó����ۣ�
		 * 1.������һ���������ʱ����ֻ�ǵõ��������һ�����ã���û�ж��ⴴ��һ���µ����顣���ֻ�����˴���һ��������ڴ档
		 * 2.�������굥�����е�����ʱ�����������һ�������������sum��allMatch�ȷ���������ô���������ᱻ�رգ�����˵�Ƿ����������е���Դ������һ�����飩�����ã����Ҳ�����ʹ�ã����߱���
		 * 		Ҳ����˵����һ���������ݱ��������ʱ�������������Զ�close�������ֶ�close��
		 * 3.�������÷��������ķ���ʱ����filter��������ԭ��������������ʹ�ã����򱨴�����ԭ�����������������Դ�����ã���Ϊ��ʱ��û�м��㣨���ԣ�������Ҳ����ʹ�ö����ڴ�ռ䡣
		 * 4.�ڶ����ʽ�����������У�����������Ԥ�ȼ��㣬ֱ�������ս᷽�����˹��̲������Ķ�����ڴ棬ֻ���ĳ��е���Դ��ռ���ڴ棬�����ù�����������ʹ�ã����򱨴������������������Դ�����á�
		 * 5.��һ������������Դ�����ã�������Դ���ܱ������ռ������գ��ͷ��ڴ棩�ķ�ʽ��
		 * 		(1)��������close����
		 * 		(2)������Ϊnull
		 * 		(3)����ʽ�����и����һ���������ս᷽����
		 */
	}

}