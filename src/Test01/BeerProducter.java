package Test01;

import java.util.Random;

public class BeerProducter implements Runnable {

	// 超市
	private Supermarket supermarket;

	public BeerProducter(Supermarket supermarket) {
		this.supermarket = supermarket;
	}

	@Override
	public void run() {
		while(true){
			Random r = new Random();
			long num = r.nextInt(100);
			Beer beer = new Beer();
			beer.setCapabality(100);
			beer.setShap("椭圆");
			beer.setName("青岛啤酒" + num);
			synchronized(supermarket){			//消费者和生产要使用同一个监视器
				try{
					supermarket.add(beer);
					System.out.println("生产者生产了" + beer.getName());
				}catch(Exception e){
					try{
						supermarket.notifyAll();
						supermarket.wait();
					}catch(Exception e1){
						e1.printStackTrace();
					}
					System.out.println(e.getMessage());
				}
			}
		}

	}

}
