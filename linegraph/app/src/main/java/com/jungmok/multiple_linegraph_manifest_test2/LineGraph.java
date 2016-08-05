package com.jungmok.multiple_linegraph_manifest_test2;

import android.content.Context;
import android.content.Intent;

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

        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};// x values
        int[] y = {30, 34, 45, 57, 77, 89, 100, 111, 123, 145}; // y values

        // conversion to object

        TimeSeries series = new TimeSeries("Line 1"); // create line
        for (int i = 0 ; i<x.length; i++)
        {
            series.add(x[i], y[i]);
        }


        // add to dataseries

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset(); // 1 group of object
        dataset.addSeries(series);

        //dataset.addSeries(series2); -> add more than 2 line graph

        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer renderer = new XYSeriesRenderer(); // customise to line properties
        // To specify, 1 series is matched 1 Renderer
        // for example, XYSeriesRenderer is matched dataset.addSeries(series)
        mRenderer.addSeriesRenderer(renderer);


        Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer, "Line Graph Title");
        // ChartFactory.getLineChartIntent ???
        //org.achartengine.GraphicalActivity
        return intent;
    }



}
