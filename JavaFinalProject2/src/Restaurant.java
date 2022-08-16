public class Restaurant {
    protected String name;
    protected Integer Rating;
    protected static Integer maxRating = 5;
    protected Double income;
    protected Double expense;

    public Restaurant(String name) {
        this.name = name;
    }

    public void setRating(Integer rating) throws IllegalRatingException {
        if (rating > maxRating) {
            throw new IllegalRatingException();
        }
        Rating = rating;
    }

    public boolean isFirstRestaurantMoreProfitable(Restaurant restaurant) {
        return this.income > restaurant.getIncome();
    }

    public String getName() {
        return name;
    }

    public Integer getRating() {
        return Rating;
    }

    public static Integer getMaxRating() {
        return maxRating;
    }

    public Double getIncome() {
        return income;
    }

    public Double getExpense() {
        return expense;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", Rating=" + Rating +
                ", income=" + income +
                ", expense=" + expense +
                '}';
    }
}
