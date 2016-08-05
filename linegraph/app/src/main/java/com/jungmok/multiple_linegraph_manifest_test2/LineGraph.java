package com.jungmok.multiple_linegraph_manifest_test2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.sql.Time;

/**
 * Created by Jungmok on 16. 8. 4..
 */
public class LineGraph
{
    public Intent getIntent(Context context)
    {
        // Data points
        // Data points


        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};// x values
        int[] y = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}; // y values
        int[] y2 = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}; // y2 values
        int[] y3 = {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
        int[] y4 = {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
        int[] y5 = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        // a number of x and y must be matched


        // conversion to object

        TimeSeries series1 = new TimeSeries("pH 5"); // create line
        TimeSeries series2 = new TimeSeries("pH 6");
        TimeSeries series3 = new TimeSeries("pH 7");
        TimeSeries series4 = new TimeSeries("pH 8");
        TimeSeries series5 = new TimeSeries("pH 9");
        // Using for TimeSeries
        for (int i = 0 ; i<x.length; i++)
        {
                series1.add(x[i], y[i]);
                series2.add(x[i], y2[i]);
                series3.add(x[i], y3[i]);
                series4.add(x[i], y4[i]);
                series5.add(x[i], y5[i]);
        }

        // add to dataseries

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset(); // 1 group of object
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);

        //dataset.addSeries(series2); -> add more than 2 line graph

        XYSeriesRenderer renderer1 = new XYSeriesRenderer();// customise to line properties
        renderer1.setColor(Color.RED);
        renderer1.setLineWidth(10);

        XYSeriesRenderer renderer2 = new XYSeriesRenderer();
        renderer2.setColor(Color.BLUE);
        renderer2.setLineWidth(10);

        XYSeriesRenderer renderer3 = new XYSeriesRenderer();
        renderer3.setColor(Color.CYAN);
        renderer3.setLineWidth(10);

        XYSeriesRenderer renderer4 = new XYSeriesRenderer();
        renderer4.setColor(Color.BLACK);
        renderer4.setLineWidth(10);

        XYSeriesRenderer renderer5 = new XYSeriesRenderer();
        renderer5.setColor(Color.GREEN);
        renderer5.setLineWidth(10);

        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();  // 화면에 뿌려주기 위해서 mRenderer로 지정해준다
        mRenderer.setChartTitle("perfect pH sensor");
        mRenderer.setYTitle("VOUT(V)");
        mRenderer.setXTitle("Time(sec)");
        mRenderer.setAxisTitleTextSize(80);
        mRenderer.setChartTitleTextSize(80);
        mRenderer.setXLabelsAlign(Paint.Align.CENTER);
        mRenderer.setYLabelsAlign(Paint.Align.CENTER);
        mRenderer.setLabelsTextSize(50);
        mRenderer.setMargins(new int[]{200,200,0,200});
        mRenderer.setZoomButtonsVisible(true);
        mRenderer.setYAxisMin(0);
        mRenderer.setYAxisMax(7);

        mRenderer.addSeriesRenderer(renderer1);
        mRenderer.addSeriesRenderer(renderer2);
        mRenderer.addSeriesRenderer(renderer3);
        mRenderer.addSeriesRenderer(renderer4);
        mRenderer.addSeriesRenderer(renderer5);

        mRenderer.setZoomEnabled(true);
        mRenderer.setExternalZoomEnabled(true);
        mRenderer.setApplyBackgroundColor(true);




        // To specify, 1 series is matched 1 Renderer
        // for example, XYSeriesRenderer is matched dataset.addSeries(series)






        Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer, "Line Graph Title");
        // ChartFactory.getLineChartIntent ???
        //org.achartengine.GraphicalActivity
        return intent;


    }



}
