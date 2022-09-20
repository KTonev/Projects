import papers.Paper;
import papers.SizePaper;
import papers.TypePaper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        PrintHouse printHouse = new PrintHouse();

        Paper paper1 = new Paper(SizePaper.A1, TypePaper.GLOSSY_PAPER,0.05);
        Paper paper2 = new Paper(SizePaper.A5, TypePaper.NEWSPAPER_PAPER,0.05);

        Publication pub1 = new Publication("Book",10,100,paper1);
        Publication pub2 = new Publication("Newspaper",10,100,paper2);

        PrintingMachine machine1 = new PrintingMachine(10000,20,pub1);
        PrintingMachine machine2 = new PrintingMachine(10000,10,pub2);
        printHouse.addMachine(machine1);
        printHouse.addMachine(machine2);

        Workers worker1 = new Workers(Workers.JobPosition.OPERATOR, printHouse.getSalaryForWorker());
        Workers worker2 = new Workers(Workers.JobPosition.MANAGER, printHouse.getSalaryForWorker());

        Thread thread1 = new Thread(machine1);
        Thread thread2 = new Thread(machine2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println();
        printHouse.setIncome(machine1.getIncomeFromMachine());
        printHouse.setConsumablesCost(machine1.getIncomeFromMachine() / 2);
        printHouse.setPrintedPublications(machine1.getPrintedPublications());

        printHouse.setIncome(machine2.getIncomeFromMachine());
        printHouse.setConsumablesCost(machine2.getIncomeFromMachine() / 2);
        printHouse.setPrintedPublications(machine2.getPrintedPublications());


        fileWriting(printHouse);
        fileReading();
    }

    public static void fileWriting (PrintHouse printHouse) throws IOException {
        FileWriter writer = new FileWriter("results.txt");
        writer.write("Income: " + Math.round(printHouse.getIncome()) + "\n");
        writer.write("Cost: " + Math.round(printHouse.getSalaryCost() + printHouse.getConsumablesCost()) + "\n");
        writer.write("Printed publications: " + printHouse.getPrintedPublications() + "\n");
        writer.close();
    }

    public static void fileReading () throws IOException {
        FileReader reader = new FileReader("results.txt");
        int i;
        while ((i = reader.read()) != -1) {
            System.out.print((char)i);
        }
        reader.close();
    }
}
