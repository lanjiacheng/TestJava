package Test01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test01_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testArrayList();
//		testLinkedList();
//		testPriorityQueue();
//		testHashMap();
//		testLinkedHashMap();
//		testTreeMap();
//		testHashSet();
//		testTreeSet();
	}

	// 测试ArrayList容器
	public static void testArrayList() {
		/*
		 * 关于ArrayList内部维护的数组的长度（capacity）增长问题： 数组初始长度是0，默认长度是10
		 * 如果ArrayList创建时没有传入任何参数，默认长度是0，如过传入任何参数，那么由相关参数决定
		 * 如果数组长度需要增长，需要的长度在0~10（默认长度之间），那么数组长度会马上增长到10（默认长度）
		 * 如果数组长度需要增长，需要的长度超过10，那么数组长度会试图变成原来的1.5倍，1.5倍原来的长度还不够的画，就变成需要的长度，够了就变成原来的1.
		 * 5倍长度。
		 * 
		 * 在ArrayList获取迭代器之后，对ArrayList进行了增加或删除操作（不是通过迭代器本身方法进行的），那么在使用迭代器时会报错。
		 */

		// 创建ArrayList
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));
		System.out.println(arrayList1);
		// 添加
		arrayList1.add(6);
		arrayList1.add(0, 0);
		arrayList1.addAll(Arrays.asList(new Integer[] { 7, 8, 9 }));
		arrayList1.addAll(10, Arrays.asList(new Integer[] { 10, 11, 12 }));
		System.out.println(arrayList1);
		// 删除
		arrayList1.remove(6);
		arrayList1.remove(new Integer(7));
		arrayList1.removeAll(Arrays.asList(new Integer[] { 8, 9, 10 }));
		arrayList1.removeIf(i -> i == 11 || i == 12);
		arrayList1.retainAll(Arrays.asList(new Integer[] { 1, 2, 3, 4 })); // 除了给定集合里面的元素之外，都从原集合里面删除
		System.out.println(arrayList1);
		// 判断
		System.out.println("arrayList1 is empty ? " + arrayList1.isEmpty());
		System.out.println("arrayList1 is contain 5 ? " + arrayList1.contains(5));
		System.out.println("arrayList1 is containAll [-1,2,3] ? "
				+ arrayList1.containsAll(Arrays.asList(new Integer[] { -1, 2, 3 })));
		// 获取
		System.out.println(arrayList1.get(0));
		System.out.println(arrayList1.indexOf(3));
		// 修改
		arrayList1.set(0, 10);
		System.out.println(arrayList1);
		// 排序
		arrayList1.sort((i1, i2) -> i1 - i2);
		System.out.println(arrayList1);
		// 替换
		arrayList1.replaceAll(i -> i * -1);
		System.out.println(arrayList1);
		// 截取
		List<Integer> subArrayList1 = arrayList1.subList(0, 1);
		System.out.println(subArrayList1);
		// 迭代
//		arrayList1.stream().forEach(System.out::println);
//		for(Integer i : arrayList1) {
//			System.out.println(i);
//		}
//		Iterator<Integer> itr = arrayList1.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		ListIterator<Integer> litr = arrayList1.listIterator();
		arrayList1.set(0, 111);
		arrayList1.remove(0);
		while (litr.hasNext()) {
			System.out.println(litr.next());
		}
		while (litr.hasPrevious()) {
			System.out.println(litr.previous());
		}
		// 清空
		arrayList1.clear();
		System.out.println(arrayList1);
		System.out.println(arrayList1.isEmpty());
	}

	// 测试LinkedList容器
	public static void testLinkedList() {

//		创建
		LinkedList<Integer> linkedList1 = new LinkedList<Integer>(Arrays.asList(new Integer[] { 0, 1, 2, 3, 4 }));
		System.out.println("init arr is " + linkedList1);
//		添加
//		linkedList1.add(null);
		linkedList1.add(5);
		linkedList1.addFirst(-1);
		linkedList1.push(-2);
		System.out.println("after add : " + linkedList1);
//		删除
		linkedList1.remove(); // 删除第一个
		linkedList1.removeLast();
		linkedList1.poll();
		System.out.println("after remove : " + linkedList1);
//		判断
		linkedList1.isEmpty();
		linkedList1.contains(1);
//		获取
		System.out.println("first elements is : " + linkedList1.get(0));
		System.out.println("first elements is : " + linkedList1.peek());
//		修改
		linkedList1.set(0, -1);
		System.out.println(linkedList1);
//		排序
		linkedList1.sort((i1, i2) -> i2 - i1);
		System.out.println(linkedList1);
//		替换
		linkedList1.replaceAll(i -> i * -1);
		System.out.println(linkedList1);
//		截取
		List<Integer> subList = linkedList1.subList(1, 3);
		System.out.println(subList);
//		迭代
		ListIterator litr = linkedList1.listIterator();
		while (litr.hasNext()) {
			System.out.println(litr.next());
		}
//		清空
		linkedList1.clear();
		System.out.println(linkedList1.isEmpty());
	}

	// 测试PriorityQueue容器
	public static void testPriorityQueue() {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((Integer i, Integer j) -> i - j);
		priorityQueue.add(3);
		priorityQueue.add(10);
		priorityQueue.add(6);
//		priorityQueue.add(null);				要比较，不允许null值
		System.out.println(priorityQueue);
		System.out.println(priorityQueue.poll());
		System.out.println(priorityQueue.poll());
		System.out.println(priorityQueue.poll());
	}

	// 测试HashMap容器
	public static void testHashMap() {
//		System.out.println(1^1);
//		System.out.println(Integer.toBinaryString("str1".hashCode()));
//		System.out.println('\t' + Integer.toBinaryString(tableSizeFor(2 * 2 * 2 * 2 * 2 * 2 + 1)));
//		创建
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		System.out.println("init state : " + hashMap);
//		添加
		hashMap.put(0, "zero");
		hashMap.put(1, "one");
		hashMap.put(2, "two");
		System.out.println("after add : " + hashMap);
//		删除
		hashMap.remove(0);
		System.out.println("after remove " + hashMap);
//		判断
		System.out.println("contains key 1 ? " + hashMap.containsKey(1));
//		获取
		System.out.println("the value of key 2 : " + hashMap.get(2));
//		修改
		hashMap.replace(2, "too");
		System.out.println("set value of key 2 to too : " + hashMap);
//		排序，hashmap不能排序
//		替换，替换就是修改
//		截取，没有
//		迭代：hashmap没有直接的迭代器，可以先获取keySet再通过keyIterator()过去键的迭代器
//		forEach方法和keySet()和values()和entrySet方法，都可以进行迭代
//		hashMap.forEach((k, v) -> System.out.println(k + "->" + v));
//		Set<Map.Entry<Integer, String>> entrySet = hashMap.entrySet();
//		for(Map.Entry<Integer, String> entry : entrySet) {
//			System.out.println(entry.getKey() + "->" + entry.getValue());
//		}
//		清空
		hashMap.clear();
		System.out.println("hashMap is empty ? " + hashMap.isEmpty());
	}

	static int tableSizeFor(int cap) {
		System.out.println("cap= " + '\t' + Integer.toBinaryString(cap));
		int n = cap - 1;
		System.out.println("n = cap-1= " + '\t' + Integer.toBinaryString(n));
		n |= n >>> 1;
		System.out.println("n |= n >>> 1 = " + '\t' + Integer.toBinaryString(n));
		n |= n >>> 2;
		System.out.println("n |= n >>> 2 = " + '\t' + Integer.toBinaryString(n));
		n |= n >>> 4;
		System.out.println("n |= n >>> 4 = " + '\t' + Integer.toBinaryString(n));
		n |= n >>> 8;
		System.out.println("n |= n >>> 8 = " + '\t' + Integer.toBinaryString(n));
		n |= n >>> 16;
		System.out.println("n |= n >>> 16 = " + '\t' + Integer.toBinaryString(n));
		return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
		/*
		 * 此方法是HashMap中求新容量的方法，其特点是始终返回一个大于等于传入的参数且是2的次方的整数。 从一个最坏的情况，数的变化如下： cap=
		 * 1000001 n = cap-1= 1000000 n |= n >>> 1 = 1100000 n |= n >>> 2 = 1111000 n |=
		 * n >>> 4 = 1111111 n |= n >>> 8 = 1111111 n |= n >>> 16 = 1111111 cap= n+1 =
		 * 10000000
		 */
	}

	// 测试LinkedHashMap容器
	public static void testLinkedHashMap() {
		// 创建
//		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>(100,0.75f,false);	//仅按插入顺序迭代
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>(100, 0.75f, true); // 按访问顺序迭代
		// 添加
		lhm.put(1, "one"); // 每次添加元素，都把元素放到最后
		lhm.put(2, "two");
		lhm.put(3, "three");
		lhm.put(0, "zero");
		System.out.println(lhm);
		lhm.get(1); // 如果accessOrder为true，每次访问之后都把访问的元素放到双链表的最后
		lhm.get(3);
		Set<Map.Entry<Integer, String>> entrySet = lhm.entrySet();
		entrySet.forEach(System.out::println);
	}

	// 测试TreeMap容器
	public static void testTreeMap() {
		// 创建
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(1, "one");
		treeMap.put(2, "two");
		treeMap.put(0, "zero");
		treeMap.put(3, null);
		System.out.println(treeMap);
		treeMap.forEach((k, v) -> System.out.println(k + "->" + v));
		System.out.println(treeMap.firstEntry());
		System.out.println(treeMap.higherEntry(1));
//		TreeMap<Test01_06, String> treeMap2 = new TreeMap<Test01_06, String>();
//		treeMap2.put(new Test01_06(), "1");
//		treeMap2.put(new Test01_06(), "1");
		// 当传入不能比较（没有实现Comparable）的对象，且没有指定比较器Comparator时，会报转换对象类型的异常。
	}

	// 测试HashSet容器
	public static void testHashSet() {
		// 创建
		HashSet<String> hashSet = new HashSet<String>();
		// 添加
		hashSet.add("one");
		hashSet.add("two");
		hashSet.add("three");
		hashSet.add("three");
		System.out.println(hashSet);
		// 获取，没有get方法

		// 迭代
		hashSet.forEach(System.out::println);
		// 判断
		System.out.println(hashSet.contains("two"));
	}

	// 测试TreeSet容器
	private static void testTreeSet() {
		// 创建
		TreeSet<Integer> treeSet = new TreeSet<Integer>((i,j)->i-j);
//		treeSet.add(null);			TreeMap和TreeSet不允许放空值或键，因为存值或键时要进行比较，一般来书null是不能进行比价的，所以不允许
//									TreeMap可以放null值，不能放null键
		treeSet.add(3);
		treeSet.add(2);
		treeSet.add(1);
		System.out.println(treeSet);
//		System.out.println(treeSet.pollLast());
		treeSet.forEach(System.out::println);
	}
}
