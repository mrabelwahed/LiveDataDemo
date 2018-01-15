package com.ramadan_apps.livedatademo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.Date;

/**
 * Created by Mahmoud Ramadan on 1/15/18.
 */

public class DataRepo {

    public static  MutableLiveData<Long> mutableLiveData = new MutableLiveData<>();

    public static LiveData<Long> getData(){
        mutableLiveData.setValue(new Date().getTime());
        return mutableLiveData;
    }


}
