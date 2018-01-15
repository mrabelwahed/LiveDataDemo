package com.ramadan_apps.livedatademo;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DataRepo.getData().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                ((TextView)findViewById(R.id.textView)).setText(String.valueOf(aLong));
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTime();
            }
        });
    }

    public void getTime(){
        DataRepo.getData();
    }
}
