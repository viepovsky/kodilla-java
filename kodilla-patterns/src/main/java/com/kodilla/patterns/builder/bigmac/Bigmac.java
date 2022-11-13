package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients = new ArrayList<>();

    public static class BigmacBuilder{
        public static final String BUN_WITH_SESAME = "Bun with sesame";
        public static final String BUN_WITHOUT_SESAME = "Bun without sesame";
        public static final String SAUCE_STANDARD = "Standard";
        public static final String SAUCE_1000ISLANDS = "1000 Islands";
        public static final String SAUCE_BARBECUE = "Barbecue";
        public static final String INGREDIENTS_LETTUCE = "Lettuce";
        public static final String INGREDIENTS_ONION = "Onion";
        public static final String INGREDIENTS_BACON = "Bacon";
        public static final String INGREDIENTS_CUCUMBER = "Cucumber";
        public static final String INGREDIENTS_CHILLIPEPPERS = "Chilli peppers";
        public static final String INGREDIENTS_MUSHROOM = "Mushroom";
        public static final String INGREDIENTS_SHRIMP = "Shrimp";
        public static final String INGREDIENTS_CHEESE = "Cheese";
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();
        public BigmacBuilder bun(String bun){
            if (bun.equals(BUN_WITH_SESAME) || bun.equals(BUN_WITHOUT_SESAME)){
                this.bun = bun;
            }else {
                throw new IllegalStateException("You can only choose bun with or without sesame.");
            }
             return this;
        }
        public BigmacBuilder burgers(int burgers){
            if (burgers >= 0 && burgers <= 3){
                this.burgers = burgers;
            }else {
                throw new IllegalStateException("You can only choose burgers amount from 0 to 3");
            }
             return this;
        }
        public BigmacBuilder sauce(String sauce){
            if (sauce.equals(SAUCE_STANDARD) || sauce.equals(SAUCE_BARBECUE) || sauce.equals(SAUCE_1000ISLANDS)){
                this.sauce = sauce;
            } else {
                throw new IllegalStateException("You chose wrong sauce.");
            }
             return this;
        }
        public BigmacBuilder ingredients(String ingredients){
            if (ingredients.equals(INGREDIENTS_BACON) || ingredients.equals(INGREDIENTS_CUCUMBER) || ingredients.equals(INGREDIENTS_MUSHROOM)
            || ingredients.equals(INGREDIENTS_LETTUCE) || ingredients.equals(INGREDIENTS_ONION) || ingredients.equals(INGREDIENTS_CHILLIPEPPERS)
            || ingredients.equals(INGREDIENTS_SHRIMP) || ingredients.equals(INGREDIENTS_CHEESE)){
                this.ingredients.add(ingredients);
            } else {
                throw new IllegalStateException("You chose wrong ingredient.");
            }
            return this;
        }
        public Bigmac build(){
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }
    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients){
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }
    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers='" + burgers + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
    public List<String> getIngredients() {
        return ingredients;
    }
}
