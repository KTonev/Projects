package papers;

public class Paper {
    private SizePaper size;
    private TypePaper type;
    private double price;

    public Paper(SizePaper size, TypePaper type, double price) {
        this.size = size;
        this.type = type;
        this.price = type.getPrice() + size.getPrize();
    }

    public SizePaper getSize() {
        return size;
    }

    public TypePaper getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "size=" + size +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
