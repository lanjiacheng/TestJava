package Test01;

public class BeerConsumer implements Runnable {

	// ����
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
					System.out.println("������������" + beer.getName());
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
