package com.jungmok.multiple_linegraph_manifest_test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import org.achartengine.*;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lineGraphHandler (View view)
    {
        LineGraph line = new LineGraph();
        Intent lineIntent = line.getIntent(this);
        startActivity(lineIntent);

        //intent activity information
    }
}
