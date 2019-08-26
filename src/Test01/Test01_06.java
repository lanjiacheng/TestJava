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

	// ����ArrayList����
	public static void testArrayList() {
		/*
		 * ����ArrayList�ڲ�ά��������ĳ��ȣ�capacity���������⣺ �����ʼ������0��Ĭ�ϳ�����10
		 * ���ArrayList����ʱû�д����κβ�����Ĭ�ϳ�����0����������κβ�������ô����ز�������
		 * ������鳤����Ҫ��������Ҫ�ĳ�����0~10��Ĭ�ϳ���֮�䣩����ô���鳤�Ȼ�����������10��Ĭ�ϳ��ȣ�
		 * ������鳤����Ҫ��������Ҫ�ĳ��ȳ���10����ô���鳤�Ȼ���ͼ���ԭ����1.5����1.5��ԭ���ĳ��Ȼ������Ļ����ͱ����Ҫ�ĳ��ȣ����˾ͱ��ԭ����1.
		 * 5�����ȡ�
		 * 
		 * ��ArrayList��ȡ������֮�󣬶�ArrayList���������ӻ�ɾ������������ͨ�����������������еģ�����ô��ʹ�õ�����ʱ�ᱨ��
		 */

		// ����ArrayList
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));
		System.out.println(arrayList1);
		// ���
		arrayList1.add(6);
		arrayList1.add(0, 0);
		arrayList1.addAll(Arrays.asList(new Integer[] { 7, 8, 9 }));
		arrayList1.addAll(10, Arrays.asList(new Integer[] { 10, 11, 12 }));
		System.out.println(arrayList1);
		// ɾ��
		arrayList1.remove(6);
		arrayList1.remove(new Integer(7));
		arrayList1.removeAll(Arrays.asList(new Integer[] { 8, 9, 10 }));
		arrayList1.removeIf(i -> i == 11 || i == 12);
		arrayList1.retainAll(Arrays.asList(new Integer[] { 1, 2, 3, 4 })); // ���˸������������Ԫ��֮�⣬����ԭ��������ɾ��
		System.out.println(arrayList1);
		// �ж�
		System.out.println("arrayList1 is empty ? " + arrayList1.isEmpty());
		System.out.println("arrayList1 is contain 5 ? " + arrayList1.contains(5));
		System.out.println("arrayList1 is containAll [-1,2,3] ? "
				+ arrayList1.containsAll(Arrays.asList(new Integer[] { -1, 2, 3 })));
		// ��ȡ
		System.out.println(arrayList1.get(0));
		System.out.println(arrayList1.indexOf(3));
		// �޸�
		arrayList1.set(0, 10);
		System.out.println(arrayList1);
		// ����
		arrayList1.sort((i1, i2) -> i1 - i2);
		System.out.println(arrayList1);
		// �滻
		arrayList1.replaceAll(i -> i * -1);
		System.out.println(arrayList1);
		// ��ȡ
		List<Integer> subArrayList1 = arrayList1.subList(0, 1);
		System.out.println(subArrayList1);
		// ����
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
		// ���
		arrayList1.clear();
		System.out.println(arrayList1);
		System.out.println(arrayList1.isEmpty());
	}

	// ����LinkedList����
	public static void testLinkedList() {

//		����
		LinkedList<Integer> linkedList1 = new LinkedList<Integer>(Arrays.asList(new Integer[] { 0, 1, 2, 3, 4 }));
		System.out.println("init arr is " + linkedList1);
//		���
//		linkedList1.add(null);
		linkedList1.add(5);
		linkedList1.addFirst(-1);
		linkedList1.push(-2);
		System.out.println("after add : " + linkedList1);
//		ɾ��
		linkedList1.remove(); // ɾ����һ��
		linkedList1.removeLast();
		linkedList1.poll();
		System.out.println("after remove : " + linkedList1);
//		�ж�
		linkedList1.isEmpty();
		linkedList1.contains(1);
//		��ȡ
		System.out.println("first elements is : " + linkedList1.get(0));
		System.out.println("first elements is : " + linkedList1.peek());
//		�޸�
		linkedList1.set(0, -1);
		System.out.println(linkedList1);
//		����
		linkedList1.sort((i1, i2) -> i2 - i1);
		System.out.println(linkedList1);
//		�滻
		linkedList1.replaceAll(i -> i * -1);
		System.out.println(linkedList1);
//		��ȡ
		List<Integer> subList = linkedList1.subList(1, 3);
		System.out.println(subList);
//		����
		ListIterator litr = linkedList1.listIterator();
		while (litr.hasNext()) {
			System.out.println(litr.next());
		}
//		���
		linkedList1.clear();
		System.out.println(linkedList1.isEmpty());
	}

	// ����PriorityQueue����
	public static void testPriorityQueue() {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((Integer i, Integer j) -> i - j);
		priorityQueue.add(3);
		priorityQueue.add(10);
		priorityQueue.add(6);
//		priorityQueue.add(null);				Ҫ�Ƚϣ�������nullֵ
		System.out.println(priorityQueue);
		System.out.println(priorityQueue.poll());
		System.out.println(priorityQueue.poll());
		System.out.println(priorityQueue.poll());
	}

	// ����HashMap����
	public static void testHashMap() {
//		System.out.println(1^1);
//		System.out.println(Integer.toBinaryString("str1".hashCode()));
//		System.out.println('\t' + Integer.toBinaryString(tableSizeFor(2 * 2 * 2 * 2 * 2 * 2 + 1)));
//		����
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		System.out.println("init state : " + hashMap);
//		���
		hashMap.put(0, "zero");
		hashMap.put(1, "one");
		hashMap.put(2, "two");
		System.out.println("after add : " + hashMap);
//		ɾ��
		hashMap.remove(0);
		System.out.println("after remove " + hashMap);
//		�ж�
		System.out.println("contains key 1 ? " + hashMap.containsKey(1));
//		��ȡ
		System.out.println("the value of key 2 : " + hashMap.get(2));
//		�޸�
		hashMap.replace(2, "too");
		System.out.println("set value of key 2 to too : " + hashMap);
//		����hashmap��������
//		�滻���滻�����޸�
//		��ȡ��û��
//		������hashmapû��ֱ�ӵĵ������������Ȼ�ȡkeySet��ͨ��keyIterator()��ȥ���ĵ�����
//		forEach������keySet()��values()��entrySet�����������Խ��е���
//		hashMap.forEach((k, v) -> System.out.println(k + "->" + v));
//		Set<Map.Entry<Integer, String>> entrySet = hashMap.entrySet();
//		for(Map.Entry<Integer, String> entry : entrySet) {
//			System.out.println(entry.getKey() + "->" + entry.getValue());
//		}
//		���
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
		 * �˷�����HashMap�����������ķ��������ص���ʼ�շ���һ�����ڵ��ڴ���Ĳ�������2�Ĵη��������� ��һ�������������ı仯���£� cap=
		 * 1000001 n = cap-1= 1000000 n |= n >>> 1 = 1100000 n |= n >>> 2 = 1111000 n |=
		 * n >>> 4 = 1111111 n |= n >>> 8 = 1111111 n |= n >>> 16 = 1111111 cap= n+1 =
		 * 10000000
		 */
	}

	// ����LinkedHashMap����
	public static void testLinkedHashMap() {
		// ����
//		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>(100,0.75f,false);	//��������˳�����
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>(100, 0.75f, true); // ������˳�����
		// ���
		lhm.put(1, "one"); // ÿ�����Ԫ�أ�����Ԫ�طŵ����
		lhm.put(2, "two");
		lhm.put(3, "three");
		lhm.put(0, "zero");
		System.out.println(lhm);
		lhm.get(1); // ���accessOrderΪtrue��ÿ�η���֮�󶼰ѷ��ʵ�Ԫ�طŵ�˫��������
		lhm.get(3);
		Set<Map.Entry<Integer, String>> entrySet = lhm.entrySet();
		entrySet.forEach(System.out::println);
	}

	// ����TreeMap����
	public static void testTreeMap() {
		// ����
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
		// �����벻�ܱȽϣ�û��ʵ��Comparable���Ķ�����û��ָ���Ƚ���Comparatorʱ���ᱨת���������͵��쳣��
	}

	// ����HashSet����
	public static void testHashSet() {
		// ����
		HashSet<String> hashSet = new HashSet<String>();
		// ���
		hashSet.add("one");
		hashSet.add("two");
		hashSet.add("three");
		hashSet.add("three");
		System.out.println(hashSet);
		// ��ȡ��û��get����

		// ����
		hashSet.forEach(System.out::println);
		// �ж�
		System.out.println(hashSet.contains("two"));
	}

	// ����TreeSet����
	private static void testTreeSet() {
		// ����
		TreeSet<Integer> treeSet = new TreeSet<Integer>((i,j)->i-j);
//		treeSet.add(null);			TreeMap��TreeSet������ſ�ֵ�������Ϊ��ֵ���ʱҪ���бȽϣ�һ������null�ǲ��ܽ��бȼ۵ģ����Բ�����
//									TreeMap���Է�nullֵ�����ܷ�null��
		treeSet.add(3);
		treeSet.add(2);
		treeSet.add(1);
		System.out.println(treeSet);
//		System.out.println(treeSet.pollLast());
		treeSet.forEach(System.out::println);
	}
}
