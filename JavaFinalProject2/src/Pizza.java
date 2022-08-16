public class Pizza {
    private static Integer counter = 0;
    private Integer id;
    private PizzaType pizzaType;
    private Double pizzaCost;
    private Double pizzaPrice;

    public Pizza(PizzaType pizzaType, Double pizzaCost, Double pizzaPrice) {
        counter++;
        this.id = counter;
        this.pizzaType = pizzaType;
        this.pizzaCost = pizzaCost;
        this.pizzaPrice = pizzaPrice;
    }

    public Integer getId() {
        return id;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public Double getPizzaCost() {
        return pizzaCost;
    }

    public Double getPizzaPrice() {
        return pizzaPrice;
    }
}

