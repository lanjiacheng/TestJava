package Test01;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Test01_13_MethodHandler {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object rcvr = "b";
		MethodType mt = MethodType.methodType(int.class);
		MethodHandles.Lookup l = MethodHandles.lookup();
		MethodHandle mh = l.findVirtual(rcvr.getClass(), "hashCode", mt);
		int ret = (int) mh.invoke(rcvr);
		System.out.println(ret);
	}

}
