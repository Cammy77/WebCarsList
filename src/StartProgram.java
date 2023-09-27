import java.util.List;
import java.util.Scanner;

import controller.CarListHelper;
import model.CarList;

/**
 * Cameron Mockobee - cmockobee1@dmacc.edu CIS175 - Fall 2023 Sep 11, 2023
 */
public class StartProgram {

	// TODO Auto-generated method stub
	static Scanner in = new Scanner(System.in);
	static CarListHelper clh = new CarListHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a brand: ");
		String brand = in.nextLine();
		System.out.print("Enter an model: ");
		String model = in.nextLine();
		CarList toAdd = new CarList(brand, model);
		clh.insertCar(toAdd);

	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the brand to delete: ");
		String brand = in.nextLine();
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();
		CarList toDelete = new CarList(brand, model);
		clh.deleteCar(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Brand");
		System.out.println("2 : Search by Model");
		int searchBy = in.nextInt();
		in.nextLine();
		List<CarList> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the brand name: ");
			String brand = in.nextLine();
			foundItems = clh.searchForCarByBrand(brand);

		} else {
			System.out.print("Enter the model: ");
			String model = in.nextLine();
			foundItems = clh.searchForCarByModel(model);

		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (CarList cl : foundItems) {
				System.out.println(cl.getId() + " : " + cl.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			CarList toEdit = clh.searchForCarById(idToEdit);
			System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getBrand());
			System.out.println("1 : Update Brand");
			System.out.println("2 : Update Model");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Store: ");
				String newBrand = in.nextLine();
				toEdit.setBrand(newBrand);
			} else if (update == 2) {
				System.out.print("New Item: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			}

			clh.updateCar(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our car list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an car");
			System.out.println("*  2 -- Edit an car");
			System.out.println("*  3 -- Delete an car");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				clh.cleanUp();
				System.out.println("   See Ya!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<CarList> allItems = clh.showAllCars();

		for (CarList singleItem : allItems) {
			System.out.println(singleItem.returnCarInfo());
		}

	}

}
