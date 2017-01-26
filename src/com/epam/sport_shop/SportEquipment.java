package com.epam.sport_shop;

public class SportEquipment {
	private Category category;
	private String title;
	private int price;

	SportEquipment(String[] s) {
		this.category = new Category(s[0]);
		this.title = s[1];
		this.price = Integer.parseInt(s[2]);
	}

	public void setCaregory(Category caregory) {
		this.category = caregory;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SportEquipment that = (SportEquipment) o;

		if (price != that.price)
			return false;
		if (!category.equals(that.category))
			return false;
		return title.equals(that.title);
	}

	@Override
	public int hashCode() {
		int result = category.hashCode();
		result = 31 * result + title.hashCode();
		result = 31 * result + price;
		return result;
	}

	@Override
	public String toString() {
		return (getCategory() + " " + getTitle() + " " + getPrice());
	}
}
