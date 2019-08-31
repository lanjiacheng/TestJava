package Test01;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.Channel;

public class Test01_12_Proxy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		test1();
	}

	private static void test1() throws IOException {
		InvocationHandler h = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				String name = method.getName();
				System.out.println(name);
				return null;
			}

		};
		Channel c = (Channel) Proxy.newProxyInstance(Channel.class.getClassLoader(), new Class[] { Channel.class }, h);
		String str = c.toString();		//因为在invovationHandler里面的incoke方法返回的是null，所以这个方法返回的也是null
		System.out.println(str);
		System.out.println(c);
		//测试非接口的动态代理
//		Object o = (Object) Proxy.newProxyInstance(Object.class.getClassLoader(), new Class[]{Object.class}, h);		//非接口不能代理
	}
}
