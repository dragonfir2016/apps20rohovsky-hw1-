package ua.edu.ucu.tempseries;

import lombok.Getter;

public final class TempSummaryStatistics {
    @Getter
    private final double avgTemp;
    @Getter
    private final double devTemp;
    @Getter
    private final double minTemp;
    @Getter
    private final double maxTemp;

    public TempSummaryStatistics(double average, double deviation, double min, double max) {
        this.avgTemp = average;
        this.devTemp = deviation;
        this.minTemp = min;
        this.maxTemp = max;
    }

}