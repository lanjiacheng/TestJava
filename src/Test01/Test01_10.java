package Test01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test01_10 {
	public static void main(String[] args) {
		// test1();
		// test2();
		test3();
	}

	// 测试类对象
	private static void test1() {
		Class c1 = int.class;
		Class c2 = Integer.class;
		Class c3 = new Integer(1).getClass();
		Class c4 = Integer.TYPE;
		System.out.println(c1);
		System.out.println(c1 == c2);
		System.out.println(c2 == c3);
		System.out.println(c4 == c1);
		System.out.println(c2.toGenericString());
		System.out.println(c1.getClassLoader());
		System.out.println(c2.getClassLoader()); // 无法访问核心类的类加载器
		System.out.println(Test01_10.class.getClassLoader());
		class MyClassLoader extends ClassLoader {
			public Class load(String path) {
				Path p = Paths.get(path);
				InputStream in = null;
				try {
					in = new FileInputStream(p.toFile());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileChannel channel = (FileChannel) Channels.newChannel(in);
				ByteBuffer bf = ByteBuffer.allocate(1024 * 1024 * 8); // 开辟1m的内存
				int len = 0;
				try {
					len = channel.read(bf);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return defineClass(null, bf.array(), 0, len); // 这样加载的类，它的class的类加载器必然是调用此方法的加载器
			}
		}
		try {
			Class c5 = new MyClassLoader().loadClass("Test01.Test01_10"); // 因为该类已经加载过，所以直接返回表示该类的class
			System.out.println(c5.getClassLoader());
			Class c6 = new MyClassLoader().loadClass("Test01.Beer");
			System.out.println(c6.getClassLoader());
			Class c7 = new MyClassLoader().loadClass("p1.AbstractSuper"); // 因为双亲委派模型，所以虽然用不同的类加载器的方法去加载，最终返回的类的类加载器还是应用类加载器（父）
			System.out.println(c7.getClassLoader());
			System.out.println("----------------------------------------------");
			Class c8 = new MyClassLoader().load("E:/javacode/TestJava/bin/Test01/BeerConsumer.class");
			System.out.println(c8.getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end");

	}

	// 测试Class对象的一些方法
	private static void test2() {
		// 找出一个类中被弃用的方法
		Class clz = Thread.class;
		for (Method m : clz.getMethods()) {
			for (Annotation a : m.getAnnotations()) {
				if (a.annotationType() == Deprecated.class) {
					System.out.println(m.getName());
				}
			}
		}
		Class clz2 = Test01_10.class;
		Object o = null;
		try {
			o = clz2.newInstance(); // 这样获取类的一个实例
			// clz2.cast(new Object());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(o instanceof Test01_10);
	}

	// 测试反射
	private static void test3() {
		Object rcvr = new Object();
		try {
			Class<?>[] argTypes = new Class[] {};
			Object[] args = null;

			Method meth = rcvr.getClass().getMethod("hashCode", argTypes);
			Object ret = meth.invoke(rcvr, args);
			System.out.println(ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
