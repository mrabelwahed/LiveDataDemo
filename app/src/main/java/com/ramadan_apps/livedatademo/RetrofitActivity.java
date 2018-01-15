package com.ramadan_apps.livedatademo;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class RetrofitActivity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        RetrofitRepo.getData().observe(this, new Observer<StoreInfo>() {
            @Override
            public void onChanged(@Nullable StoreInfo storeInfo) {
                ((TextView)findViewById(R.id.textView)).setText(""+storeInfo.getStore());
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitRepo.getStoreInfo();
            }
        });
    }
}
