package com.epam.sport_shop;

import java.util.ArrayList;

public class User {
	private String name;
	private double moneyAvailable;
	private ArrayList<SportEquipment> rentedUnits = new ArrayList<>();

	User(String name, double moneyAvailable) {
		setName(name);
		setMoneyAvailable(moneyAvailable);
	}

	public boolean checkUser(User currentUser, SportEquipment currentEquipment) {
		if (isEnoughMoney(currentEquipment.getPrice()) && isAmountAvailable()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isEnoughMoney(double price) {
		if (getMoneyAvailable() >= price) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isAmountAvailable() {
		if (rentedUnits.size() < 3) {
			return true;
		} else {
			return false;
		}
	}

	public void addItemToRentedItemList(SportEquipment itemToRent) {
		rentedUnits.add(itemToRent);
	}

	public void removeItemFromRentedItemList(SportEquipment itemToReturn) {
		rentedUnits.remove(itemToReturn);
	}

	public String getName() {
		return name;
	}

	public double getMoneyAvailable() {
		return moneyAvailable;
	}

	public ArrayList<SportEquipment> getRentedUnits() {
		return rentedUnits;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMoneyAvailable(double moneyAvailable) {
		this.moneyAvailable = moneyAvailable;
	}

	public void setRentedUnits(ArrayList<SportEquipment> rentedUnits) {
		this.rentedUnits = rentedUnits;
	}

	@Override
	public String toString() {
		return (getName() + " " + getMoneyAvailable() + " ");
	}
}
