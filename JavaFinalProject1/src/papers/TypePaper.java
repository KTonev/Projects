package papers;

public enum TypePaper {
    NORMAL_PAPER(0.1),GLOSSY_PAPER(0.2),NEWSPAPER_PAPER(0.3);

    private double price;

    public double getPrice() {
        return price;
    }

    TypePaper (double price) {
        this.price = price;
    }
}
