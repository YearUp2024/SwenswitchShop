package com.pluralsight.Interfaces;

import com.pluralsight.OrderScreen.Drink;
import com.pluralsight.Toppings.ToppingsOptions;
import com.pluralsight.Console;
import java.util.List;

public class DrinksInterface {
    private static final double small = 2.00;
    private static final double medium = 2.50;
    private static final double large = 3.00;

    ToppingsOptions toppingsOptions = new ToppingsOptions();

    /**
     * This method is related to Sandwich Method. This method allows the users to Order and Drink when they are ordering a Sandwich.
     * @return
     */
    public Drink orderDrinks(){
        List<String> drinkType = null;
        int size = 0;
        double price = 0.0;
        String drinkName = "";
        boolean addMoreDrinks;

        do{
            int userOption = 0;
            boolean validInput = false;

            while(!validInput){
                try{
                    System.out.println("\nPlease choose from the Drinks options: ");
                    drinkType = toppingsOptions.drinksOptions();
                    userOption = Console.PromptForInt("Enter your choice: ");

                    if(userOption >= 1 && userOption <= drinkType.size()){
                        validInput = true;
                    }else{
                        System.out.println("\n--------------------------------------------------------------");
                        System.out.println("                " + userOption + " is not a valid input.");
                        System.out.println("--------------------------------------------------------------");
                    }
                }catch(Exception e){
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 7.");
                    System.out.println("-------------------------------------------------------------------------------------");
                }
            }

            try{
                boolean validSizeInput = false;
                do {
                    try {
                        size = Console.PromptForInt("Please choose from the Size options: (1: Small, 2: Medium, 3: Large) ");

                        if (size >= 1 && size <= 3) {
                            validSizeInput = true;
                        } else {
                            System.out.println("\n--------------------------------------------------------------------");
                            System.out.println("                     " + size + " is not a valid input.");
                            System.out.println("--------------------------------------------------------------------\n");
                        }
                    } catch (Exception e) {
                        System.out.println("\n--------------------------------------------------------------------");
                        System.out.println("       Your input is not valid. Please enter a valid size. ");
                        System.out.println("----------------------------------------------------------------------\n");
                    }
                } while (!validSizeInput);

                if(userOption >= 1 && userOption <= drinkType.size()){
                    validInput = true;
                }
            }catch(Exception e){
                System.out.println("\n-------------------------------------------------------------------------------------");
                System.out.println("            Your input is invalid. Please enter a number between 1 and 7.");
                System.out.println("-------------------------------------------------------------------------------------");
            }

            switch(userOption){
                case 1:
                    drinkName = "pepsi";
                    break;
                case 2:
                    drinkName = "sprite";
                    break;
                case 3:
                    drinkName = "red bull";
                    break;
                case 4:
                    drinkName = "gatorade";
                    break;
                case 5:
                    drinkName = "arizona";
                    break;
                case 6:
                    drinkName = "coca cola";
                    break;
                case 7:
                    drinkName = "coke";
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
            }

            if(size == 1){
                price = small;
            }else if(size == 2){
                price = medium;
            }else if(size == 3){
                price = large;
            }
            addMoreDrinks = Console.PromptForYesNo("Do you want to add more Drinks?");
        }while(addMoreDrinks);
        return new Drink(drinkName, size, price);
    }

    /**
     * This method allows the users to only a Drink without buying Sandwich.
     * @return
     */
    public Drink buyDrinkOnly(){
        List<String> drinkType;
        int size = 0;
        double price = 0.0;
        String drinkName = "";
        boolean addMoreDrinks;
        double totalPrice = 0;

        do{
            int userOption = 0;
            boolean validInput = false;

            while(!validInput){
                try{
                    System.out.println("Which drink do you want?");
                    drinkType = toppingsOptions.drinksOptions();
                    userOption = Console.PromptForInt("Enter your choice: ");

                    size = Console.PromptForInt("What size do you want? (1: Small, 2: Medium, 3: Large) ");
                    System.out.println();

                    if(userOption >= 1 && userOption <= drinkType.size()){
                        validInput = true;
                    }
                }catch(Exception e){
                    System.out.println("\n-------------------------------------------------------------------------------------");
                    System.out.println("            Your input is invalid. Please enter a number between 1 and 7.");
                    System.out.println("-------------------------------------------------------------------------------------\n");
                    System.out.println("Please select from the Options: ");
                    toppingsOptions.drinksOptions();
                }
            }

            switch(userOption){
                case 1:
                    drinkName = "pepsi";
                    break;
                case 2:
                    drinkName = "sprite";
                    break;
                case 3:
                    drinkName = "red bull";
                    break;
                case 4:
                    drinkName = "gatorade";
                    break;
                case 5:
                    drinkName = "arizona";
                    break;
                case 6:
                    drinkName = "coca cola";
                    break;
                case 7:
                    drinkName = "coke";
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
            }

            if(size == 1){
                price = small;
            }else if(size == 2){
                price = medium;
            }else if(size == 3){
                price = large;
            }
            totalPrice += price;
            addMoreDrinks = Console.PromptForYesNo("Do you want to add more Drinks?");
        }while(addMoreDrinks);

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                       Your Total for the Order is $" + totalPrice);
        System.out.println("----------------------------------------------------------------------------------");

        return new Drink(drinkName, size, price);
    }
}