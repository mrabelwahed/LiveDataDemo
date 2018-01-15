package com.ramadan_apps.livedatademo;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;

/**
 * Created by Mahmoud Ramadan on 1/15/18.
 */


public class ConnectivityLiveData extends LiveData {



    public ConnectivityManager connectivityManager;
    public ConnectivityLiveData(Context context) {
        //get connectivity system service
        connectivityManager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Override
    protected void onActive() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(listener);
        }
    }

    @Override
    protected void onInactive() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectivityManager.unregisterNetworkCallback(listener);
        }
    }

    public ConnectivityManager.NetworkCallback listener =
            new ConnectivityManager.NetworkCallback(){
                @Override
                public void onLosing(Network network, int maxMsToLive) {
                    postValue(network);
                }

                @Override
                public void onLost(Network network) {
                    postValue(network);
                }

                @Override
                public void onAvailable(Network network) {
                    postValue(network);
                }
            };
}
