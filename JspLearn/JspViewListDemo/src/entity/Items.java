package entity;

/**
 * 商品信息实体类
 * 
 * @author zhou
 *
 */
public class Items {

	private int id;// 商品编号
	private String name;// 商品名称
	private String city;// 产地
	private double price;// 价格
	private int number;// 数量
	private String picture;// 商品图片

	public Items() {
	}

	@Override
	public int hashCode() {
		return this.getId() + this.getName().hashCode();
	}

	/**
	 * 判断两个商品是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Items) {
			Items item = (Items) obj;
			if (this.getId() == item.getId() && this.getName().equals(item.getName()))
				return true;
			else
				return false;
		} else
			return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
