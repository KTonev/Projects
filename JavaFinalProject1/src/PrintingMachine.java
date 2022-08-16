public class PrintingMachine implements Runnable {
    private static int counter = 1;
    private int id;
    private final int capacity;
    private final int pagesPerMinute;
    private TypePrinting typePrinting;
    private Publication publication;
    private double incomeFromMachine = 0;
    private int printedPublications = 0;

    public PrintingMachine(int capacity, int pagesPerMinute, Publication publication) {
        this.id = counter;
        this.capacity = capacity;
        this.pagesPerMinute = pagesPerMinute;
        this.publication = publication;
        counter++;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPagesPerMinute() {
        return pagesPerMinute;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setTypePrinting(TypePrinting typePrinting) {
        this.typePrinting = typePrinting;
    }

    @Override
    public String toString() {
        return "PrintingMachine{" +
                "capacity=" + capacity +
                ", pagesPerMinute=" + pagesPerMinute +
                ", publication=" + publication +
                '}';
    }

    public int getId() {
        return id;
    }

    public double getIncomeFromMachine() {
        return incomeFromMachine;
    }

    public int getPrintedPublications() {
        return printedPublications;
    }

    @Override
    public void run() {
        double consumables = publication.getPaper().getPrice();
        int listsPrinted = 0;
        for (int i = 1; i <= publication.getNumber(); i++) {
            for (int j = 1; j <= publication.getNumPages(); j++) {
                System.out.println("Page: " + j + " from " + i + " print ;" + " Machine: " + id + " ; Publication: " + publication.getTitle());
                listsPrinted++;

                //printHouse.setConsumablesCost(consumables);

                if (listsPrinted >= capacity) {
                    try {
                        throw new OutOfMaterialException("Max capacity of machine "+ id + " is: " + capacity);
                    } catch (OutOfMaterialException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
            incomeFromMachine += (consumables * publication.getNumPages() * 2);
            printedPublications++;
        }
    }

    enum TypePrinting {
        COLOR,BLACK_WHITE
    }
}
