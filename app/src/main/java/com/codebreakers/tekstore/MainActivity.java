package com.codebreakers.tekstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.WindowManager;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    DotsIndicator dotsIndicator;
    ViewAdapter viewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        viewPager = findViewById(R.id.view_pager);
        dotsIndicator = findViewById(R.id.dot);

        viewAdapter = new ViewAdapter(this);
        viewPager.setAdapter(viewAdapter);
        dotsIndicator.setViewPager(viewPager);
    }
}
