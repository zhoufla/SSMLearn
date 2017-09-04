package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 购物车类
 * 
 * @author zhou
 *
 */
public class Cart {

	// 购买商品的集合
	private Map<Items, Integer> goods  = new HashMap<>();
	// 购物车总金额
	private double totalPrice;

	public Cart() {
	}

	/**
	 * 增加商品
	 * 
	 * @param item
	 * @param num
	 * @return
	 */
	public boolean addGoodsInCart(Items item, int num) {
		if (this.goods.containsKey(item))// 如果存在商品，将数量累加
			this.goods.put(item, goods.get(item) + num);
		else
			this.goods.put(item, num);
		calTotalPrice();
		return true;
	}

	/**
	 * 删除商品
	 * 
	 * @param item
	 * @return
	 */
	public boolean removeGoodsFromCart(Items item) {
		this.goods.remove(item);
		calTotalPrice();
		return true;
	}

	/**
	 * 计算总价
	 * 
	 * @return
	 */
	public double calTotalPrice() {
		Iterator<Entry<Items, Integer>> iterator = this.goods.entrySet().iterator();
		double sum = 0.0;
		while (iterator.hasNext()) {
			Entry<Items, Integer> entry = iterator.next();
			Items item = entry.getKey();
			sum += item.getPrice() * entry.getValue();
		}
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}

	public Map<Items, Integer> getGoods() {
		return goods;
	}

	public void setGoods(Map<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
