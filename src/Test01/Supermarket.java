package Test01;

import java.util.ArrayList;
import java.util.List;

/*
 * �ֿ⣬����
 */
class Supermarket {
	private List<Beer> beers = new ArrayList<Beer>(); // �洢ơ�Ƶ��б�
	private int length; // �ֿ��С

	public Supermarket(int length) {
		this.length = length;
	}

	// ����ơ��
	public void add(Beer beer) throws Exception {
		if (size() >= length) {
			throw new Exception("�������������࣬�밴�չ涨����");
		}
		beers.add(beer);
	}

	// ����ơ��
	public Beer remove() throws Exception {
		if (size() <= 0) {
			throw new Exception("������㣬���Ժ�����");
		}
		return beers.remove(0);
	}

	private int size() {
		// TODO Auto-generated method stub
		return beers.size();
	}
}