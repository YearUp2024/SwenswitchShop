package com.pluralsight.OrderScreen;

import com.pluralsight.Console;
import com.pluralsight.Toppings.ToppingsOptions;
import java.util.*;

public class SandwichInterface {
    private static final double baseCost4 = 5.50;
    private static final double baseCost8 = 7.00;
    private static final double baseCost12 = 8.50;
    private static final double meatCost4 = 1.00;
    private static final double meatCost8 = 2.00;
    private static final double meatCost12 = 3.00;
    private static final double extraMeatCost4 = 0.50;
    private static final double extraMeatCost8 = 1.00;
    private static final double extraMeatCost12 = 1.50;
    private static final double cheeseCost4 = 0.75;
    private static final double cheeseCost8 = 1.50;
    private static final double cheeseCost12 = 2.25;
    private static final double extraCheeseCost4 = 0.30;
    private static final double extraCheeseCost8 = 0.60;
    private static final double extraCheeseCost12 = 0.90;

    ToppingsOptions toppingsOptions = new ToppingsOptions();
    List<String> regularToppings = new ArrayList<>();
    List<String> premiumToppings = new ArrayList<>();

    public void orderSandwich(){
        int sandwichSize = promptForSandwichSize();
        System.out.println();

        String breadType = promptForBreadType();
        System.out.println(breadType);
        boolean toasted = Console.PromptForYesNo("Do you want your bread to be toasted:");

        List<String> regularToppingsType = promptForRegularToppings();
        System.out.println(regularToppingsType);

        List<String> meatToppingsType = promptForMeatType();
        System.out.println(meatToppingsType);

        List<String> cheeseToppingsType = promptForCheeseType();
        System.out.println(cheeseToppingsType);

//        System.out.println();
//        List<String> meatToppings = new ArrayList<>();
//        boolean extraMeat = false;
//        String meat;
//        do{
//            meat = Console.PromptForString("Do you want Meat? ");
//            if(meat.equalsIgnoreCase("Yes") || meat.equalsIgnoreCase("Y")){
//                meatToppings.addAll(promptForToppings("meat"));
//                extraMeat = Console.PromptForYesNo("Do you want extra Meat?");
//                System.out.println();
//            }else if(!meat.equalsIgnoreCase("Yes") && !meat.equalsIgnoreCase("Y") && !meat.equalsIgnoreCase("No") && !meat.equalsIgnoreCase("N")){
//                System.out.println("\nPlease enter Yes or No");
//            }else if(meat.equalsIgnoreCase("no") || meat.equalsIgnoreCase("n")){
//                System.out.println();
//            }
//            premiumToppings.addAll(meatToppings);
//        }while(!meat.equalsIgnoreCase("yes") && !meat.equalsIgnoreCase("y") && !meat.equalsIgnoreCase("no") && !meat.equalsIgnoreCase("n"));
//
//        List<String> cheeseToppings = new ArrayList<>();
//        boolean extraCheese = false;
//        String cheese;
//        do{
//            cheese= Console.PromptForString("Do you want Cheese? ");
//            if(cheese.equalsIgnoreCase("Yes") || cheese.equalsIgnoreCase("Y")){
//                cheeseToppings.addAll(promptForToppings("cheese"));
//                extraCheese = Console.PromptForYesNo("Do you want extra Cheese?");
//                System.out.println();
//            }else if(!cheese.equalsIgnoreCase("Yes") && !cheese.equalsIgnoreCase("Y") && !cheese.equalsIgnoreCase("No") && !cheese.equalsIgnoreCase("N")){
//                System.out.println("\nPlease enter Yes or No");
//            }else if(cheese.equalsIgnoreCase("no") || cheese.equalsIgnoreCase("n")){
//                System.out.println();
//            }
//            premiumToppings.addAll(cheeseToppings);
//        }while(!cheese.equalsIgnoreCase("yes") && !cheese.equalsIgnoreCase("y") && !cheese.equalsIgnoreCase("no") && !cheese.equalsIgnoreCase("n"));
//
//
//        String sides;
//        do{
//            sides = Console.PromptForString("Do you want Sides? ");
//            if(sides.equalsIgnoreCase("Yes") || sides.equalsIgnoreCase("Y")){
//                System.out.println("Please choose from the Sides options.");
//                toppingsOptions.sidesToppings();
//
//                String userSides = Console.PromptForString("Enter your choice: ");
//                if(userSides.equalsIgnoreCase("sauce")){
//                    List<String> sauceToppings = new ArrayList<>();
//                    sauceToppings.addAll(promptForToppings("sauce"));
//                    regularToppings.addAll(sauceToppings);
//                    System.out.println();
//                }else if(userSides.equalsIgnoreCase("au jus")){
//                    regularToppings.add("au jus");
//                }
//            }
//        }while(!sides.equalsIgnoreCase("yes") && !sides.equalsIgnoreCase("y") && !sides.equalsIgnoreCase("no") && !sides.equalsIgnoreCase("n"));
//
//        double totalCost = calculateCost(sandwichSize, premiumToppings, extraMeat, extraCheese);

//        AddSandwich addSandwich = new AddSandwich("Custom Sandwich", totalCost, 1, sandwichSize, breadType, toasted, regularToppings, premiumToppings);
//
//        showOrderSummery(addSandwich);
    }

    private int promptForSandwichSize() {
        int sandwichSize = 0;
        do{
            System.out.println("What size Sandwich do you want?");
            toppingsOptions.sandwichSizeType();

            try{
                sandwichSize = Console.PromptForInt("Enter your choice: ");
                if(sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12){
                    System.out.println("\nPlease enter a valid size: 4, 8, or 12.\n");
                }
            }catch(Exception e){
                System.out.println("\nPlease enter a valid size: 4, 8, or 12.\n");
            }
        }while(sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12);
        return sandwichSize;
    }

    public String promptForBreadType(){
        System.out.println("What type of bread do you want?");
        List<String> breadType = toppingsOptions.breadTypes();

        String userChoice = "";
        do{
            int userOption = 0;
            boolean validInput = false;

            while(!validInput){
                try{
                    userOption = Console.PromptForInt("Enter your choice: ");
                    if(userOption >= 1 && userOption <= 4){
                        validInput = true;
                    }else{
                        System.out.println("\nPlease select from the options: ");
                        toppingsOptions.breadTypes();
                    }
                }catch(Exception e){
                    System.out.println("\nYour input is invalid. Please enter a number between 1 and 4.\n");
                    System.out.println("Please select from the Options: ");
                    toppingsOptions.breadTypes();
                }
            }

            switch(userOption){
                case 1:
                    userChoice = "white";
                    break;
                case 2:
                    userChoice = "Wheat";
                    break;
                case 3:
                    userChoice = "Rye";
                    break;
                case 4:
                    userChoice = "Wrap";
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
                    break;
            }
        }while(!breadType.contains(userChoice));
        return userChoice;
    }

    public List<String> promptForRegularToppings(){
        System.out.println("\nWhat toppings do you want?");
        List<String> normalToppings = toppingsOptions.regularToppingsType();
        List<String> selectedToppings = new ArrayList<>();

        String userChoice = "";
        do{
            int userOption = 0;
            boolean validInput = false;

            while(!validInput){
                try{
                    userOption = Console.PromptForInt("Enter your choice: ");
                    if(userOption >= 1 && userOption <= normalToppings.size()){
                        validInput = true;
                    }else{
                        System.out.println("\nPlease select from the options: ");
                        toppingsOptions.regularToppingsType();
                    }
                }catch(Exception e){
                    System.out.println("\nYour input is invalid. Please enter a number between 1 and 9\n");
                    System.out.println("Please select from the options:");
                    toppingsOptions.regularToppingsType();
                }
            }

            switch(userOption){
                case 1:
                    userChoice = "lettuce";
                    selectedToppings.add(userChoice);
                    break;
                case 2:
                    userChoice = "peppers";
                    selectedToppings.add(userChoice);
                    break;
                case 3:
                    userChoice = "onions";selectedToppings.add(userChoice);
                    break;
                case 4:
                    userChoice = "tomatoes";
                    selectedToppings.add(userChoice);
                    break;
                case 5:
                    userChoice = "jalapenos";
                    selectedToppings.add(userChoice);
                    break;
                case 6:
                    userChoice = "cucumbers";
                    selectedToppings.add(userChoice);
                    break;
                case 7:
                    userChoice = "pickles";
                    selectedToppings.add(userChoice);
                    break;
                case 8:
                    userChoice = "guacamole";
                    selectedToppings.add(userChoice);
                    break;
                case 9:
                    userChoice = "mushrooms";
                    selectedToppings.add(userChoice);
                    break;
                default:
                    System.out.println("Your choice is incorrect.");
            }
        }while(!normalToppings.contains(userChoice));
        regularToppings.addAll(selectedToppings);
        return selectedToppings;
    }

    public List<String> promptForMeatType(){
        List<String> meatToppings = new ArrayList<>();
        boolean wantMeat = Console.PromptForYesNo("\nDo you want Meat on your Sandwich?");

        if(wantMeat){
            System.out.println("Which Meat do you want?");
            List<String> availableMeat = toppingsOptions.meatTypes();

            String userChoice = "";
            do{
                int userOptions = 0;
                boolean validInput = false;

                while(!validInput){
                    try{
                        userOptions = Console.PromptForInt("Enter your choice: ");

                        if(userOptions >= 1 && userOptions <= availableMeat.size()){
                            validInput = true;
                        }else{
                            System.out.println("\nPlease select from the options: ");
                            toppingsOptions.meatTypes();
                        }
                    }catch(Exception e){
                        System.out.println("\nYour input is invalid. Please enter a number between 1 and 6.\n");
                        System.out.println("Please choose from the options:");
                        toppingsOptions.meatTypes();
                    }
                }

                switch(userOptions){
                    case 1:
                        userChoice = "steak";
                        meatToppings.add(userChoice);
                        break;
                    case 2:
                        userChoice = "ham";
                        meatToppings.add(userChoice);
                        break;
                    case 3:
                        userChoice = "salami";
                        meatToppings.add(userChoice);
                        break;
                    case 4:
                        userChoice = "roast beef";
                        meatToppings.add(userChoice);
                        break;
                    case 5:
                        userChoice = "chicken";
                        meatToppings.add(userChoice);
                        break;
                    case 6:
                        userChoice = "bacon";
                        meatToppings.add(userChoice);
                        break;
                    default:
                        System.out.println("Your choice is incorrect.");
                }
            }while(!meatToppings.contains(userChoice));
            premiumToppings.addAll(meatToppings);
        }
        return meatToppings;
    }

    public List<String> promptForCheeseType(){
        List<String> cheeseToppings = new ArrayList<>();
        boolean wantCheese = Console.PromptForYesNo("\nDo you want Cheese on your Sandwich?");

        if(wantCheese){
            System.out.println("Which Cheese do you want?");
            List<String> availableCheese = toppingsOptions.cheeseTypes();

            String userChoice = "";
            do{
                int userOptions = 0;
                boolean validInput = false;

                while(!validInput){
                    try{
                        userOptions = Console.PromptForInt("Enter your choice: ");

                        if(userOptions >= 1 && userOptions <= availableCheese.size()){
                            validInput = true;
                        }else{
                            System.out.println("\nPlease select from the options: ");
                            toppingsOptions.cheeseTypes();
                        }
                    }catch(Exception e){
                        System.out.println("\nYour input is invalid. Please enter a number between 1 and 6.\n");
                        System.out.println("Please choose from the options:");
                        toppingsOptions.cheeseTypes();
                    }
                }

                switch(userOptions){
                    case 1:
                        userChoice = "american";
                        cheeseToppings.add(userChoice);
                        break;
                    case 2:
                        userChoice = "provolone";
                        cheeseToppings.add(userChoice);
                        break;
                    case 3:
                        userChoice = "cheddar";
                        cheeseToppings.add(userChoice);
                        break;
                    case 4:
                        userChoice = "swiss";
                        cheeseToppings.add(userChoice);
                        break;
                    default:
                        System.out.println("Your choice is incorrect.");
                }
            }while(!cheeseToppings.contains(userChoice));
            premiumToppings.addAll(cheeseToppings);
        }
        return cheeseToppings;
    }

//    public List<String> promptForToppings(String type){
//        List<String> toppings = new ArrayList<>();
//        List<String> validToopings = new ArrayList<>();
//
//        boolean moreOptions = false;
//        do{
//            if(type.equalsIgnoreCase("regular")){
//                System.out.println("Please choose Toppings from the options:");
//                validToopings = new ArrayList<>(toppingsOptions.regularToppingsType());
//            }else if(type.equalsIgnoreCase("meat")){
//                System.out.println("Please choose from the Meat toppings options:");
//                validToopings = new ArrayList<>(toppingsOptions.meatTypes());
//            }else if(type.equalsIgnoreCase("cheese")){
//                System.out.println("Please choose from the Choose toppings options:");
//                validToopings = new ArrayList<>(toppingsOptions.cheeseTypes());
//            }else if(type.equalsIgnoreCase("sauce")){
//                System.out.println("Please choose from the Sauce options:");
//                validToopings = new ArrayList<>(toppingsOptions.regularSaucesTopping());
//            }
//
//            boolean validInput = false;
//            while(!validInput){
//                String topping = Console.PromptForString("Enter your Toppings: ").toLowerCase();
//
//                if(validToopings.contains(topping)){
//                    toppings.add(topping);
//                    validInput = true;
//                }else{
//                    System.out.println("\nPlease chose Toppings from the options.");
//                    if(type.equalsIgnoreCase("regular")){
//                        toppingsOptions.regularToppingsType();
//                    }else if(type.equalsIgnoreCase("meat")){
//                        toppingsOptions.meatTypes();
//                    }else if(type.equalsIgnoreCase("cheese")){
//                        toppingsOptions.cheeseTypes();
//                    }else if(type.equalsIgnoreCase("sauce")){
//                        toppingsOptions.regularSaucesTopping();
//                    }
//                }
//            }
//            if(type.equalsIgnoreCase("sauce")){
//                moreOptions = Console.PromptForYesNo("Do you want add more toppings?");
//            }
//        }while(moreOptions);
//        return toppings;
//    }

    public double calculateCost(int sandwichSize, List<String> premiumToppings, boolean extraMeat, boolean extraCheese){
        double baseCost = 0;
        double meatCost = 0;
        double extraMeatCost = 0;
        double cheeseCost = 0;
        double extraCheeseCost = 0;

        int meatCount = 0;
        int cheeseCount = 0;
        for(String topping : premiumToppings){
            if(isMeat(topping)){
                meatCount++;
            }else if(isCheese(topping)){
                cheeseCount++;
            }
        }

        switch(sandwichSize){
            case 4:
                baseCost = baseCost4;
                meatCost = meatCount * meatCost4;
                extraMeatCost = extraMeat ? extraMeatCost4 : 0;
                cheeseCost = cheeseCount * cheeseCost4;
                extraCheeseCost = extraCheese ? extraCheeseCost4 : 0;
                break;
            case 8:
                baseCost = baseCost8;
                meatCost = premiumToppings.size() * meatCost8;
                extraMeatCost = extraMeat ? extraMeatCost8 : 0;
                cheeseCost = premiumToppings.size() * cheeseCost8;
                extraCheeseCost = extraCheese ? extraCheeseCost8 : 0;
                break;
            case 12:
                baseCost = baseCost12;
                meatCost = premiumToppings.size() * meatCost12;
                extraMeatCost = extraMeat ? extraMeatCost12 : 0;
                cheeseCost = premiumToppings.size() * cheeseCost12;
                extraCheeseCost = extraCheese ? extraCheeseCost12 : 0;
                break;
        }
        return baseCost + meatCost + extraMeatCost + cheeseCost + extraCheeseCost;
    }

    public boolean isMeat(String topping){
        List<String> meats = Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon");
        return meats.contains(topping.toLowerCase().trim());
    }
    public boolean isCheese(String topping){
        List<String> cheese = Arrays.asList("american", "provolone", "cheddar", "swiss");
        return cheese.contains(topping.toLowerCase().trim());
    }

    private void showOrderSummery(AddSandwich addSandwich) {
        System.out.println("\nYour Order:");
        System.out.println("Size " + addSandwich.getSize() + " inches");
        System.out.println("Bread " + addSandwich.getBreadType());
        System.out.println("Toasted " + (addSandwich.isToasted() ? "Yes" : "No"));
        System.out.println("Regular toppings " + addSandwich.getRegularToppings());
        System.out.println("Premium toppings " + addSandwich.getPremiumToppings());
        System.out.println("Total $" + addSandwich.getPrice());
    }
}
