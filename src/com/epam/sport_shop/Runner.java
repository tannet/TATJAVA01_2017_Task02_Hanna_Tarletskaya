package com.epam.sport_shop;

public class Runner {

	public static void main(String[] args) {
		Shop shop = new Shop();
		//===PRINT TESTING
		//shop.printFreeGoodsList();
		//shop.printRentedGoodsList();

		//===RENT TESTING (1 user? 2 items to rent and to give back
		User user = new User("TestUser", 500); //check parameters before creating User object
		String[] userWannaThisItem = new String[] {"Skiing",  "Skiboots",  "80"}; // Lets make smth to give the user ability to make a choise :)
		SportEquipment itemWanted = new SportEquipment(userWannaThisItem);
		
		if(!shop.checkForNewUser(user)) {
			shop.addNewUser(user);
		}
		
		if(user.checkUser(user, itemWanted) && shop.checkItem(itemWanted)) {
			shop.rentTheItem(user, itemWanted);
		}
		
		// The 2d item
		String[] userWannaThisItem2 = new String[] {"Football",  "Boots",  "116"}; // Lets make smth to give the user ability to make a choise :)
		SportEquipment itemWanted2 = new SportEquipment(userWannaThisItem2);
		
		if(!shop.checkForNewUser(user)) {
			shop.addNewUser(user);
		}		
		if(user.checkUser(user, itemWanted2) && shop.checkItem(itemWanted2)) {
			shop.rentTheItem(user, itemWanted2);
		}
		
		//will print all rents for unique user
		shop.printRentedGoodsList();
		
		shop.returnTheItem(user, itemWanted);
		shop.returnTheItem(user, itemWanted2);
	}
}
