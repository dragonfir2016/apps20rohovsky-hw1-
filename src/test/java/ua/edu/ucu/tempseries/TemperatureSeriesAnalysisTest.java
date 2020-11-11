package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    private TemperatureSeriesAnalysis emptySeries;
    private TemperatureSeriesAnalysis oneElSeries;
    private TemperatureSeriesAnalysis commonSeries;
    private TemperatureSeriesAnalysis bigSeries;
    private TemperatureSeriesAnalysis smallSeries;
    private TemperatureSeriesAnalysis sameSeries;

    @Before
    public void setUp() {
        emptySeries = new TemperatureSeriesAnalysis();
        oneElSeries = new TemperatureSeriesAnalysis(new double[]{-22});
        commonSeries = new TemperatureSeriesAnalysis(new double[]{-2, -1, 0, 1, 2, 2});
        bigSeries = new TemperatureSeriesAnalysis(new double[]{200000, 3000000, 10000000});
        smallSeries = new TemperatureSeriesAnalysis(new double[]{0.02, 0.1, 0.002, -0.002, 0.1});
        sameSeries = new TemperatureSeriesAnalysis(new double[]{2, 2, 2, -1, -1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageEmpty() {
        emptySeries.average();
    }

    @Test
    public void testAverageCommon() {
        double expected = 1.0/3.0;
        double actual = commonSeries.average();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testAverageOneEl() {
        double expected = -22.0;
        double actual = oneElSeries.average();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testAverageBig() {
        double expected = 4400000.0;
        double actual = bigSeries.average();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testAverageSmall() {
        double expected = 0.044000000000000004;
        double actual = smallSeries.average();

        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testAverageSame() {
        double expected = 0.8;
        double actual = sameSeries.average();

        assertEquals(expected, actual, 0.0001);
    }




    @Test(expected = IllegalArgumentException.class)
    public void testDeviationEmpty() {
        emptySeries.deviation();
    }

    @Test
    public void testDeviationCommon() {
        double expected = 1.49071198499986;
        double actual = commonSeries.deviation();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testDeviationOneEl() {
        double expected = 0;
        double actual = oneElSeries.deviation();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testDeviationBig() {
        double expected = 4121488.4042863282;
        double actual = bigSeries.deviation();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testDeviationSmall() {
        double expected = 0.04632062175748508;
        double actual = smallSeries.deviation();

        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testDeviationSame() {
        double expected = 1.469693845669907;
        double actual = sameSeries.deviation();

        assertEquals(expected, actual, 0.0001);
    }





    @Test(expected = IllegalArgumentException.class)
    public void testMinEmpty() {
        emptySeries.min();
    }

    @Test
    public void testMinCommon() {
        double expected = -2.0;
        double actual = commonSeries.min();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testMinOneEl() {
        double expected = -22.0;
        double actual = oneElSeries.min();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testMinBig() {
        double expected = 1.0E7;
        double actual = bigSeries.max();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testMinSmall() {
        double expected = -0.002;
        double actual = smallSeries.min();

        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMinSame() {
        double expected = -1.0;
        double actual = sameSeries.min();

        assertEquals(expected, actual, 0.0001);
    }




    @Test(expected = IllegalArgumentException.class)
    public void testMaxEmpty() {
        emptySeries.max();
    }

    @Test
    public void testMaxCommon() {
        double expected = 2.0;
        double actual = commonSeries.max();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testMaxOneEl() {
        double expected = -22.0;
        double actual = oneElSeries.max();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testMaxBig() {
        double expected = 1.0E7;
        double actual = bigSeries.max();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testMaxSmall() {
        double expected = 0.1;
        double actual = smallSeries.max();

        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMaxSame() {
        double expected = 2.0;
        double actual = sameSeries.max();

        assertEquals(expected, actual, 0.0001);
    }




    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueEmpty() {
        emptySeries.findTempClosestToValue(1.0);
    }

    @Test
    public void testClosestToValueCommon() {
        double expected = 1.0;
        double actual = commonSeries.findTempClosestToValue(1.0);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testClosestToValueOneEl() {
        double expected = -22.0;
        double actual = oneElSeries.findTempClosestToValue(1.0);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testClosestToValueBig() {
        double expected = 200000.0;
        double actual = bigSeries.findTempClosestToValue(1.0);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testClosestToValueSmall() {
        double expected = 0.1;
        double actual = smallSeries.findTempClosestToValue(1.0);

        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testClosestToValueSame() {
        double expected = 2.0;
        double actual = sameSeries.findTempClosestToValue(1.0);

        assertEquals(expected, actual, 0.0001);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroEmpty() {
        emptySeries.findTempClosestToZero();
    }

    @Test
    public void testClosestToZeroCommon() {
        double expected = 0;
        double actual = commonSeries.findTempClosestToZero();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testClosestToZeroOneEl() {
        double expected = -22.0;
        double actual = oneElSeries.findTempClosestToZero();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testClosestToZeroBig() {
        double expected = 200000.0;
        double actual = bigSeries.findTempClosestToZero();

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testClosestToZeroSmall() {
        double expected = 0.002;
        double actual = smallSeries.findTempClosestToZero();

        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testClosestToZeroSame() {
        double expected = -1.0;
        double actual = sameSeries.findTempClosestToZero();

        assertEquals(expected, actual, 0.0001);
    }



    @Test
    public void testLessThanEmpty() {
        emptySeries.findTempsLessThan(0.05);
    }

    @Test
    public void testLessThanCommon() {
        double[] expected = {-2.0, -1.0, 0.0};
        double[] actual = commonSeries.findTempsLessThan(0.05);

        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void testLessThanOneEl() {
        double[] expected = {-22.0};
        double[] actual = oneElSeries.findTempsLessThan(0.05);

        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void testLessThanBig() {
        double[] expected = {};
        double[] actual = bigSeries.findTempsLessThan(0.05);

        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void testLessThanSmall() {
        double[] expected = {0.02, 0.002, -0.002};
        double[] actual = smallSeries.findTempsLessThan(0.05);

        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void testLessThanSame() {
        double[] expected = {-1.0, -1.0};
        double[] actual = sameSeries.findTempsLessThan(0.05);

        assertArrayEquals(expected, actual, 0.001);
    }




    @Test
    public void testGreaterThanEmpty() {
        emptySeries.findTempsGreaterThan(-0.001);
    }

    @Test
    public void testGreaterThanCommon() {
        double[] expected = {0.0, 1.0, 2.0, 2.0};
        double[] actual = commonSeries.findTempsGreaterThan(-0.001);

        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void testGreaterThanOneEl() {
        double[] expected = {};
        double[] actual = oneElSeries.findTempsGreaterThan(-0.001);

        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void testGreaterThanBig() {
        double[] expected = {200000.0, 3000000.0, 1.0E7};
        double[] actual = bigSeries.findTempsGreaterThan(-0.001);

        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void testGreaterThanSmall() {
        double[] expected = {0.02, 0.1, 0.002, 0.1};
        double[] actual = smallSeries.findTempsGreaterThan(-0.001);

        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void testGreaterThanSame() {
        double[] expected = {2.0, 2.0, 2.0};
        double[] actual = sameSeries.findTempsGreaterThan(-0.001);

        assertArrayEquals(expected, actual, 0.001);
    }



    @Test(expected = InputMismatchException.class)
    public void testConstructorWrongTemp() {
        new TemperatureSeriesAnalysis(new double[]{1, -300});
    }



    @Test(expected = InputMismatchException.class)
    public void testAddWrongTempEmpty() {
        commonSeries.addTemps(1, -274);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddWrongTempCommon() {
        commonSeries.addTemps(1, -274);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddWrongTempOneEl() {
        oneElSeries.addTemps(1, -274);
    }



    @Test
    public void testAddTempsBig() {
        double expected = 1.3200401E7;
        double actual = bigSeries.addTemps(-1, 2, 400);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testAddTempsSmall() {
        double expected = 401.22;
        double actual = smallSeries.addTemps(-1, 2, 400);

        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testAddTempsSame() {
        double expected = 405.0;
        double actual = sameSeries.addTemps(-1, 2, 400);

        assertEquals(expected, actual, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTempSumStatEmpty(){
        emptySeries.summaryStatistics();
    }

    @Test
    public void testTempSumStatCommon(){
        double av = commonSeries.average();
        double dv = commonSeries.deviation();
        double min = commonSeries.min();
        double max = commonSeries.max();

        TempSummaryStatistics sum_st = commonSeries.summaryStatistics();
        assertEquals(av, sum_st.getAvgTemp(), 0.0001);
        assertEquals(dv, sum_st.getDevTemp(), 0.0001);
        assertEquals(min, sum_st.getMinTemp(), 0.0001);
        assertEquals(max, sum_st.getMaxTemp(), 0.0001);
    }

    @Test
    public void testTempSumStatOneEl(){
        double av = oneElSeries.average();
        double dv = oneElSeries.deviation();
        double min = oneElSeries.min();
        double max = oneElSeries.max();

        TempSummaryStatistics sum_st =  oneElSeries.summaryStatistics();
        assertEquals(av, sum_st.getAvgTemp(), 0.0001);
        assertEquals(dv, sum_st.getDevTemp(), 0.0001);
        assertEquals(min, sum_st.getMinTemp(), 0.0001);
        assertEquals(max, sum_st.getMaxTemp(), 0.0001);
    }

    @Test
    public void testTempSumStatSame(){
        double av = sameSeries.average();
        double dv = sameSeries.deviation();
        double min = sameSeries.min();
        double max = sameSeries.max();

        TempSummaryStatistics sum_st = sameSeries.summaryStatistics();
        assertEquals(av, sum_st.getAvgTemp(), 0.0001);
        assertEquals(dv, sum_st.getDevTemp(), 0.0001);
        assertEquals(min, sum_st.getMinTemp(), 0.0001);
        assertEquals(max, sum_st.getMaxTemp(), 0.0001);
    }

    @Test
    public void testTempSumStatBig(){
        double av = bigSeries.average();
        double dv = bigSeries.deviation();
        double min = bigSeries.min();
        double max = bigSeries.max();

        TempSummaryStatistics sum_st = bigSeries.summaryStatistics();
        assertEquals(av, sum_st.getAvgTemp(), 0.0001);
        assertEquals(dv, sum_st.getDevTemp(), 0.0001);
        assertEquals(min, sum_st.getMinTemp(), 0.0001);
        assertEquals(max, sum_st.getMaxTemp(), 0.0001);
    }

    @Test
    public void testTempSumStatSmall(){
        double av = smallSeries.average();
        double dv = smallSeries.deviation();
        double min = smallSeries.min();
        double max = smallSeries.max();

        TempSummaryStatistics sum_st = smallSeries.summaryStatistics();
        assertEquals(av, sum_st.getAvgTemp(), 0.0001);
        assertEquals(dv, sum_st.getDevTemp(), 0.0001);
        assertEquals(min, sum_st.getMinTemp(), 0.0001);
        assertEquals(max, sum_st.getMaxTemp(), 0.0001);
    }
}