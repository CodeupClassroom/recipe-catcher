package com.rc.recipes;

import com.rc.users.Registered;

import java.util.ArrayList;

public class Recipe {

    private String name;
    private double time;
    private String instructions;
    private String timeUnit;
    private ArrayList<Ingredient> ingredients;
    private Registered owner;

    public Recipe(String name, double time, String instructions, String timeUnit, ArrayList<Ingredient> ingredients, Registered owner) {
        this.name = name;
        this.time = time;
        this.instructions = instructions;
        this.timeUnit = timeUnit;
        this.ingredients = ingredients;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Registered getOwner() {
        return owner;
    }

    public void setOwner(Registered owner) {
        this.owner = owner;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void display(){
        System.out.println("--------------");
        System.out.println("name = " + this.name);
        System.out.println("time = " + this.time);
        System.out.println("instructions = " + this.instructions);
        System.out.println("timeUnit = " + this.timeUnit);
        for (Ingredient ingredient: this.ingredients) {
            System.out.println("ingredient = " + ingredient.getName());
        }
        System.out.println("owner = " + this.owner.getUsername());
    }
}
