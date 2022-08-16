public class Workers {
    private static int counter = 1;
    private final int id;
    private double salary;
    private JobPosition jobPosition;

    enum JobPosition {
        MANAGER, OPERATOR
    }

    public Workers(JobPosition jobPosition, Double salary) {
        this.id = counter;
        this.salary = salary;
        this.jobPosition = jobPosition;
        counter++;
    }

    public void increaseSalary(PrintHouse printHouse) {
        if (jobPosition == JobPosition.MANAGER) {
            salary += (printHouse.getPercent() / 100) * salary;
        }
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "id=" + id +
                ", salary=" + salary +
                ", jobPosition=" + jobPosition +
                '}';
    }
}
