public class Main {
    public static void main(String[] args) throws IllegalRatingException {
        Restaurant restaurant1 = new Restaurant("Mehanata");
        Restaurant restaurant2 = new Restaurant("Garden");

        restaurant1.setIncome(2000.0);
        restaurant2.setIncome(1000.0);

        restaurant1.setRating(5);
        restaurant2.setRating(4);

        System.out.println(restaurant1.isFirstRestaurantMoreProfitable(restaurant2));

        Pizza pizza1 = new Pizza(PizzaType.TOMATO,10.0,20.0);
        Pizza pizza2 = new Pizza(PizzaType.WHITE,15.0,25.0);

        Pizzeria pizzeria1 = new Pizzeria("LaBocca");

        pizzeria1.makePizza(pizza1);
        pizzeria1.makePizza(pizza2);
        pizzeria1.sellPizza(pizza1);
        pizzeria1.sellPizza(pizza2);

        System.out.println("This is the cost of the pizzas: " + pizzeria1.pizzeriaExpense());
        System.out.println("This is the profit from the pizzas: " + pizzeria1.pizzeriaIncome());
    }
}
