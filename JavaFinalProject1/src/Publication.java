import papers.Paper;

public class Publication {
    private String title;
    private int number;
    private int numPages;
    private Paper paper;
    private double price;

    public Publication(String title, int number, int numOfPages, Paper paper) {
        this.title = title;
        this.number = number;
        this.numPages = numOfPages;
        this.paper = paper;
        this.price = paper.getPrice() * numPages;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public int getNumPages() {
        return numPages;
    }

    public Paper getPaper() {
        return paper;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", number=" + number +
                ", numPages=" + numPages +
                ", paper=" + paper +
                ", price=" + price +
                '}';
    }
}
