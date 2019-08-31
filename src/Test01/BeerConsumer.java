package Test01;

public class BeerConsumer implements Runnable {

	// 超市
	private Supermarket supermarket;

	public BeerConsumer(Supermarket supermarket) {
		this.supermarket = supermarket;
	}

	@Deprecated
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Beer beer = null;
			synchronized (supermarket) {
				try {
					beer = supermarket.remove();
					System.out.println("消费者消费了" + beer.getName());
				} catch (Exception e) {
					try {
						supermarket.notifyAll();
						supermarket.wait();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
