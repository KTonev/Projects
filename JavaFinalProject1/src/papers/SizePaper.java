package papers;

public enum SizePaper {
   A1(0.05),A2(0.1),A3(0.15),A4(0.20),A5(0.25);

    private double prize;

    public double getPrize() {
        return prize;
    }

    SizePaper (double prize) {
        this.prize = prize;
    }
}
