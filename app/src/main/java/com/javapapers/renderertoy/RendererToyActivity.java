package com.javapapers.renderertoy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.javapapers.renderertoy.model.ButtonModel;
import com.javapapers.renderertoy.model.TextModel;
import com.javapapers.renderertoy.ui.RecyclerViewController;

import javax.inject.Inject;

public class RendererToyActivity extends BaseActivity {

    @Inject
    RecyclerViewController recyclerViewController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_renderer_toy);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fillContent();
            }
        });
        recyclerViewController.setRecyclerView((RecyclerView) findViewById(R.id.root_container));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_renderer_toy, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void fillContent() {
        recyclerViewController.addItems(new ButtonModel("button"), new TextModel("hello",
                Color.RED));
    }
}
