package com.epam.sport_shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RentUnit {
	private static Map<String, ArrayList<SportEquipment>> goodsRentedByUsers = new HashMap<>(); // username + his rents
	// private ArrayList<SportEquipment> units; //position rented by one unique user

	public static void addRents(User user){
		if(!goodsRentedByUsers.containsKey(user.getName())){
			goodsRentedByUsers.put(user.getName(), user.getRentedUnits());
		}
	}
	
	public Map<String, ArrayList<SportEquipment>> getGoodsRentedByUsers(){
		return this.goodsRentedByUsers;
	}
	
	public int getSize(){
		int sumOfRentedItems = 0;
		for(String s : goodsRentedByUsers.keySet()){
			sumOfRentedItems += goodsRentedByUsers.get(s).size();
		}
		return sumOfRentedItems; // will return number of all items rented by users
	}
}
