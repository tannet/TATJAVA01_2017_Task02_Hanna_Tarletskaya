package com.epam.sport_shop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Shop {
	private Map<SportEquipment, Integer> goods; // Integer - amount of goods in this category

	private BufferedReader input;
	Shop() {
		goodsInitialization();
	}

	private void goodsInitialization() {
		try {
			input = new BufferedReader(new FileReader("goods.txt"));
			goods = new HashMap<>();
			String line = null;
			while ((line = input.readLine()) != null) {
				String[] columns = line.split(" ");
				SportEquipment s = new SportEquipment(columns);
				goods.put(s, Integer.parseInt(columns[3]));
			}
		} catch (FileNotFoundException e) {
			System.err.println("ERROR. File not found. Please check the directory.");
		} catch (IOException e) {
			System.err.println("ERROR. Line can't be read. Check your file.");
		} catch (NumberFormatException e) {
			System.err
					.println("ERROR. Amount parameter (the 4th one) can not be converted to Integer. Check your file.");
		}
	}

	private ArrayList<SportEquipment> itemsRentedByUser = new ArrayList<>();

	// USERS MODULE
	private ArrayList<User> users = new ArrayList<>();

	public void addNewUser(User newUser) {
		users.add(newUser);
	}

	public boolean checkForNewUser(User userToCheck) {
		if (users.contains(userToCheck)) {
			return true;
		} else {
			return false;
		}
	}

	// RENTING MODULES IN THE SHOP
	private boolean searchForItem(SportEquipment item) {
		if (goods.containsKey(item)) {
			return true;
		} else {
			return false;
		}
	}

	public void rentTheItem(User currentUser, SportEquipment itemToRent) {
		if (searchForItem(itemToRent)) {
			// System.out.println("Amount before renting:" +
			// goods.get(itemToRent));
			currentUser.addItemToRentedItemList(itemToRent);
			itemsRentedByUser.add(itemToRent);
			removeRentedItemFromGoods(itemToRent);
			// System.out.println("Amount after renting: " +
			// goods.get(itemToRent));
		} else {
			System.out.println("There are no such item in the shop. Check your request or choose another item.");
		}
	}

	private void removeRentedItemFromGoods(SportEquipment itemToRent) {
		Integer newItemsAmount = (int) goods.get(itemToRent);
		newItemsAmount--;
		goods.replace(itemToRent, newItemsAmount);
	}

	public void returnTheItem(User currentUser, SportEquipment itemToReturn) {
		if (currentUser.getRentedUnits().contains(itemToReturn)) {
			// System.out.println("Amount before return:" +
			// goods.get(itemToReturn));
			currentUser.removeItemFromRentedItemList(itemToReturn);
			itemsRentedByUser.remove(itemToReturn);
			returnRentedItemToGoods(itemToReturn);
			// System.out.println("Amount after return: " +
			// goods.get(itemToReturn));
		} else {
			System.out.println(
					"There are no such item in your rented items. Check your request or choose another item to return.");
		}
	}

	private void returnRentedItemToGoods(SportEquipment itemToReturn) {
		Integer newItemsAmount = (int) goods.get(itemToReturn);
		newItemsAmount++;
		goods.replace(itemToReturn, newItemsAmount);
	}

	public boolean checkItem(SportEquipment itemToRent) {
		if (goods.get(itemToRent) > 0) {
			return true;
		} else {
			System.out.println("There are no available items of this position to rent. Try again later.");
			return false;
		}
	}

	// PRINTING OF GOODS IN THE SHOP
	public void printFreeGoodsList() {
		System.out.println("===Free Sport Equipment:");
		for (Entry<SportEquipment, Integer> entry : goods.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
		//System.out.println(" SIZE: " + goods.size());
	}

	public void printRentedGoodsList() {
		System.out.println("===Rented Sport Equipment:");
		for (User u : users) {
			System.out.println(u.getName() + ": " + u.getRentedUnits());
		}
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public Map<SportEquipment, Integer> getGoods() {
		return goods;
	}

}
