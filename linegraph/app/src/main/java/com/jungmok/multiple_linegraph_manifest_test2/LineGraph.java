package com.jungmok.multiple_linegraph_manifest_test2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 * Created by Jungmok on 16. 8. 4..
 */
public class LineGraph
{
    public Intent getIntent(Context context)
    {
        // Data points
        // Data points

        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};// x values
        int[] y = {30, 34, 45, 57, 77, 89, 100, 111, 123, 145}; // y values
        int[] y2 = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000}; // y2 values
        // a number of x and y must be matched


        // conversion to object

        TimeSeries series1 = new TimeSeries("Line 1"); // create line
        TimeSeries series2 = new TimeSeries("Line 2");
        // Using for TimeSeries
        for (int i = 0 ; i<x.length; i++)
        {
            series1.add(x[i], y[i]);
            series2.add(x[i], y2[i]);
        }

        // add to dataseries

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset(); // 1 group of object
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        //dataset.addSeries(series2); -> add more than 2 line graph

        XYSeriesRenderer renderer1 = new XYSeriesRenderer();// customise to line properties
        renderer1.setColor(Color.RED);

        XYSeriesRenderer renderer2 = new XYSeriesRenderer();
        renderer2.setColor(Color.BLUE);

        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();

        mRenderer.addSeriesRenderer(renderer1);
        mRenderer.addSeriesRenderer(renderer2);




        // To specify, 1 series is matched 1 Renderer
        // for example, XYSeriesRenderer is matched dataset.addSeries(series)



        Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer, "Line Graph Title");
        // ChartFactory.getLineChartIntent ???
        //org.achartengine.GraphicalActivity
        return intent;


    }



}
