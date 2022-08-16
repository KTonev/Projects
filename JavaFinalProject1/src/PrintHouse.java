import java.util.ArrayList;
import java.util.List;

public class PrintHouse {
    private List<Workers> workersList = new ArrayList<>();
    private List<PrintingMachine> machinesList = new ArrayList<>();
    private double income = 0;
    private double salaryCost;
    private double consumablesCost;
    private double salaryForWorker;
    private double incomeForBonus;
    private double percent;
    private int printedPublications = 0;

    public void addWorker (Workers worker) {
        this.workersList.add(worker);
    }

    public void addMachine (PrintingMachine machine) {
        this.machinesList.add(machine);
    }

    public void setSalaryCost() {
        for (Workers worker : this.workersList) {
            this.salaryCost += worker.getSalary();
        }
    }

    public double getSalaryCost() {
        return salaryCost;
    }

    public void setBonus(double percent) {
        this.percent = percent;
        for (Workers w : workersList) {
            w.increaseSalary(this);
        }
        salaryCost += (salaryCost * percent / 100) * workersList.size();
    }

    public List<Workers> getWorkers() {
        return workersList;
    }

    public List<PrintingMachine> getMachines() {
        return machinesList;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income += income;
    }

    public double getConsumablesCost() {
        return consumablesCost;
    }

    public void setConsumablesCost(double consumablesCost) {
        this.consumablesCost += consumablesCost;
    }

    public double getSalaryForWorker() {
        return salaryForWorker;
    }

    public void setSalaryForWorker(double salaryForWorker) {
        this.salaryForWorker = salaryForWorker;
    }

    public double getIncomeForBonus() {
        return incomeForBonus;
    }

    public void setIncomeForBonus(double incomeForBonus) {
        this.incomeForBonus = incomeForBonus;
    }

    public double getPercent() {
        return percent;
    }

    public int getPrintedPublications() {
        return printedPublications;
    }

    public void setPrintedPublications(int printedPublications) {
        this.printedPublications += printedPublications;
    }

}
