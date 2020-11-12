package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private static final int MIN_TEMP = -273;
    private static final double DELTA = 0.0000001;

    private double[] temperatures;
    private int tempNumb;
    private int size;

    public TemperatureSeriesAnalysis() {
        temperatures = new double[0];
        tempNumb = 0;
        size = 1;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        temperatures = new double[temperatureSeries.length];
        tempNumb = 0;
        size = temperatures.length;
        this.addTemps(temperatureSeries);
    }



    public double average() {
        if (tempNumb == 0) {
            throw new IllegalArgumentException();
        }
        double avg = 0;
        for (double temp : temperatures) {
            avg += temp;
        }
        return avg / tempNumb;
    }

    public double deviation() {
        double mean = average();

        double sumDev = 0;
        for (double temp : temperatures) {
            sumDev += (temp-mean)*(temp-mean);
        }
        return Math.sqrt(sumDev/ tempNumb);
    }

    public double min() {
        return findMinMax(false);
    }

    public double max() {
        return findMinMax(true);
    }

    private double findMinMax(boolean indicator) {
        if (tempNumb == 0) {
            throw new IllegalArgumentException();
        }
        double var = temperatures[0];
        for (double temp : temperatures) {
            if (indicator && temp > var || !indicator && temp < var) {
                var = temp;
            }
        }
        return var;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (tempNumb == 0) {
            throw new IllegalArgumentException();
        }

        double dist = Math.abs(tempValue - temperatures[0]);
        double closest = temperatures[0];

        for (double temp : temperatures) {
            double diff = Math.abs(tempValue - temp);

            if (Math.abs(diff - dist) < DELTA) {
                closest = Math.max(closest, temp);
            }
            else if (diff < dist) {
                dist = diff;
                closest = temp;
            }
        }
        return closest;
    }

    private double[] findLessGreater(double tempVal, boolean indicator) {
        TemperatureSeriesAnalysis tsa = new TemperatureSeriesAnalysis();
        for (double temp : temperatures) {
            if (indicator && temp > tempVal || !indicator && temp < tempVal) {
                tsa.addTemp(temp);
            }
        }
        return Arrays.copyOfRange(tsa.temperatures, 0, tsa.tempNumb);
    }

    public double[] findTempsLessThan(double tempValue) {
        return findLessGreater(tempValue, false);
    }

    public double[] findTempsGreaterThan(double tempValue) {
        return findLessGreater(tempValue, true);
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    private void addTemp(double temp) {
        if (temperatures.length == 0) {
            temperatures = new double[1];
        }
        if (tempNumb == size) {
            size = size*2;
            double[] tempArr = new double[size];
            System.arraycopy(temperatures, 0, tempArr, 0, tempNumb);
            temperatures = tempArr;
        }
        temperatures[tempNumb] = temp;
        tempNumb++;
    }

    public double addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < MIN_TEMP) {
                throw new InputMismatchException();
            }
        }
        for (double temp : temps) {
            addTemp(temp);
        }
        return average()*tempNumb;
    }
}