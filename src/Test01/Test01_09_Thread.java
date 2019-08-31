package Test01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test01_09_Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test1();
		// test2();
		// test3();
		// test4();
		test5();
		// test6();

	}

	// �����̵߳ķ���һ���̳�Thread�ಢ����run����
	private static void test1() {
		class MyThread extends Thread {
			public void run() {
				System.out.println("in run of " + getName());
				System.out.println(this == currentThread()); // ��ӡ�����True��˵����ͬһ������
			}
		}
		new MyThread().start();
		System.out.println("in run of " + Thread.currentThread().getName());
	}

	// �����̷߳�����������Threadʵ��ʱ����һ��Runnableʵ��
	private static void test2() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("in run of runnable of " + Thread.currentThread().getName());
			}

		}).start();
		System.out.println("in run of " + Thread.currentThread().getName());
	}

	// �����̵߳ķ�������ͨ��Callable�ӿ�
	private static void test3() {
		class MyThread implements Callable {

			@Override
			public Object call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("in call of " + Thread.currentThread().getName());
				return null;
			}

		}
		Callable callable = new MyThread();
		FutureTask<Object> futureTask = new FutureTask<>(callable);
		new Thread(futureTask).start();
		while (!futureTask.isDone()) {
			System.out.println("task is running...");
		}
	}

	// �����߳�һЩ����
	private static void test4() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("befor sleep...");
				int i = 10000;
				while (i > 0) {
					i--;
				}
				System.out.println("after sleep...");
			}
		});
		t1.start();
		t1.interrupt();
		// try {
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println(t1.isAlive());
		System.out.println(t1.isInterrupted());
		// System.out.println(t1.isAlive());
		// System.out.println(t1.isInterrupted()); //�߳̽���֮��interrupted״̬�ᱻ���
		// t1.start(); //�̲߳��������ڶ���
	}

	// ���Զ��̵߳�ͬ��
	private static void test5() {
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName() + " : start running...");
				Object o = new Object();
				synchronized (o) {
					System.out.println("befor wait1");
					try {
						o.wait(); // �������������o���ֵ�����o��wait�������ͻᱨ��
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("after wait1");
				}
				o.notify(); // ����ԭ��������wait����
				try {
					o.wait(); // ���wait����������synchronized������ڣ����ߵ����˷Ǽ�������wait�������ᱨ��
					// o.notify();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("in " + Thread.currentThread().getName());
			}

		};
		// new Thread(r1).start();
		new Thread(r2).start();
		new Thread(r2).start();
		new Thread(r2).start();
	}

	// ����������������ģ��
	private static void test6() {
		Supermarket supermarket = new Supermarket(20);
		BeerProducter p1 = new BeerProducter(supermarket);
		BeerProducter p2 = new BeerProducter(supermarket);
		BeerProducter p3 = new BeerProducter(supermarket);
		BeerConsumer c1 = new BeerConsumer(supermarket);
		BeerConsumer c2 = new BeerConsumer(supermarket);
		BeerConsumer c3 = new BeerConsumer(supermarket);
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(p1);
		service.execute(p2);
		service.execute(p3);
		service.execute(c1);
		service.execute(c2);
		service.execute(c3);
	}

}
