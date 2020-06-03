package com.rc;

import com.rc.recipes.Ingredient;
import com.rc.recipes.Recipe;
import com.rc.users.Guest;
import com.rc.users.Registered;
import com.rc.users.User;
import com.rc.util.Input;

import java.util.ArrayList;

public class App {

    static ArrayList<Ingredient> sampleIngredients;
    static ArrayList<Recipe> recipes = new ArrayList<>();

    public static void main(String[] args) {
//        User noAbstract = new User();
        Registered fer = new Registered("Fernando", "Mendoza", "fer@mail.com", "fer", "pass");
        buildDummyData();


        Input input = new Input();

        System.out.println("Welcome to Recipe Catcher");
        //Register or Login or Proceed as guest
        System.out.println("How do you want to proceed?\n" +
                "1 - Register as a new user\n" +
                "2 - Login\n" +
                "3 - Proceed as Guest");
        int userStatus = input.getInt(1, 3);
        User currentUser = null;
        switch (userStatus)  {
            case 1:
                System.out.println("Register as a new user.");
                String firstName = input.getString("First Name: ");
                String lastName = input.getString("Last Name: ");
                String email = input.getString("Email: ");
                String username = input.getString("Username: ");
                String password = input.getString("Password: ");
                currentUser = new Registered(firstName, lastName, email, username, password);
                break;
            case 2:
                System.out.println("Logged in");

                do{
                    recipeMenu(fer);
                    switch(input.getInt(1,2)){
                        case 1:
                            // view recipes
                            viewRecipes();
                            break;
                        case 2:
                            String recipeName = input.getString("What's the name of the recipe");
                            System.out.println("What's the time of the recipe");
                            double recipeTime = input.getDouble();
                            String recipeInstructions = input.getString("What are the instructions of the recipe");
                            String timeUnit = input.getString("What is the time unit of the recipe");
                            Recipe newRecipe = new Recipe(recipeName, recipeTime, recipeInstructions, timeUnit,  sampleIngredients, fer);
                            recipes.add(newRecipe);
                            break;
                    }
                    System.out.println("Continue?");
                }while(input.yesNo());

                break;
            case 3:
                System.out.println("Proceeding as guest.");
                currentUser = new Guest(input.getString("First Name: "), input.getString("Last Name: "), input.getString("Email: "));

                do {
                    recipeMenu(currentUser);
                    switch (input.getInt(1,1)){
                        case 1:
                                viewRecipes();
                    }
                } while(input.yesNo());
                break;
        }

        System.out.println("currentUser = " + currentUser);
    }

    private static void viewRecipes() {
        for (Recipe recipe: recipes) {
            recipe.display();
        }
    }

    public static void recipeMenu(User user){
        System.out.println("What do you want to do?");
        System.out.println("1. View a recipe");
        if(user instanceof Registered) {
            System.out.println("2. Create a recipe");
        }
    }

    public static void buildDummyData(){
        sampleIngredients = new ArrayList<>();
        sampleIngredients.add(new Ingredient("Eggs", 3, "egg"));
        sampleIngredients.add(new Ingredient("Cheese", 0.5, "kg"));

        Registered douglas = new Registered("Douglas", "hirsh", "d@d.com", "d", "pass");

        //String name, double time, String instructions, String timeUnit, ArrayList<Ingredient> ingredients, Registered owner
        recipes.add(new Recipe("Chicken soup", 50, "cook", "mins", sampleIngredients, douglas));
    }

}
