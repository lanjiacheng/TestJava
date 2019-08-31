package Test01;

import java.util.Random;

public class BeerProducter implements Runnable {

	// ����
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
			beer.setShap("��Բ");
			beer.setName("�ൺơ��" + num);
			synchronized(supermarket){			//�����ߺ�����Ҫʹ��ͬһ��������
				try{
					supermarket.add(beer);
					System.out.println("������������" + beer.getName());
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
