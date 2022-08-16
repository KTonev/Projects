import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private String name;
    private double income;
    private double expense;
    private List<Pizza> madePizzas = new ArrayList<>();
    private List<Pizza> soldPizzas = new ArrayList<>();

    public Pizzeria(String name) {
        this.name = name;
    }

    public void makePizza(Pizza pizza) {
        madePizzas.add(pizza);
    }

    public void sellPizza(Pizza pizza) {
        soldPizzas.add(pizza);
    }

    public Double pizzeriaIncome() {
        for (Pizza p : soldPizzas) {
            this.income += p.getPizzaPrice();
        }
        return this.income;
    }

    public Double pizzeriaExpense() {
        for (Pizza p : madePizzas) {
            this.expense += p.getPizzaCost();
        }
        return this.expense;
    }

    public Double incomeFromPizzaType(PizzaType pizzaType) {
        double income = 0;
        for (Pizza p : soldPizzas) {
            if (p.getPizzaType() == pizzaType) {
                income += p.getPizzaPrice();
            }
        }
        return income;
    }
}
