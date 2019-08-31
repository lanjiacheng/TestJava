package Test01;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test01_11 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test01_11 t = new Test01_11();
		DiskLoader dlr = new DiskLoader();
		Class<?> clzTest = dlr.loadFromDisk("E:/javacode/TestJava/bin/Test01/BeerConsumer.class");
		t.findDeprecatedMethod(clzTest);
	}

	public static class DiskLoader extends ClassLoader {
		public DiskLoader() {
			super(DiskLoader.class.getClassLoader());
		}

		public Class<?> loadFromDisk(String clzName) throws IOException {
			byte[] b = Files.readAllBytes(Paths.get(clzName));
			return defineClass(null, b, 0, b.length);
		}
	}

	public void findDeprecatedMethod(Class<?> clz) {
		for (Method m : clz.getMethods()) {
			for (Annotation a : m.getAnnotations()) {
				if (a.annotationType() == Deprecated.class) {
					System.out.println(m.getName());
				}
			}
		}
	}

}
