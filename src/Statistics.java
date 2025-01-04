class Statistics {
    private final int minAttackPower;
    private final int maxAttackPower;
    private final double averageAttackPower;
    private final double standardDeviation;

    public Statistics(int min, int max, double avg, double stdDev) {
        this.minAttackPower = min;
        this.maxAttackPower = max;
        this.averageAttackPower = avg;
        this.standardDeviation = stdDev;
    }

    @Override
    public String toString() {
        return String.format("Min: %d, Max: %d, Avg: %.2f, StdDev: %.2f", minAttackPower, maxAttackPower,
                averageAttackPower, standardDeviation);
    }
}