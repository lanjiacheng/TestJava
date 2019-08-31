package Test01;

import java.util.ArrayList;
import java.util.List;

/*
 * 仓库，超市
 */
class Supermarket {
	private List<Beer> beers = new ArrayList<Beer>(); // 存储啤酒的列表
	private int length; // 仓库大小

	public Supermarket(int length) {
		this.length = length;
	}

	// 放入啤酒
	public void add(Beer beer) throws Exception {
		if (size() >= length) {
			throw new Exception("生产的数量过多，请按照规定生产");
		}
		beers.add(beer);
	}

	// 售卖啤酒
	public Beer remove() throws Exception {
		if (size() <= 0) {
			throw new Exception("存货不足，请稍后再来");
		}
		return beers.remove(0);
	}

	private int size() {
		// TODO Auto-generated method stub
		return beers.size();
	}
}