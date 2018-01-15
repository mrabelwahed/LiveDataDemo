package com.ramadan_apps.livedatademo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mahmoud Ramadan on 1/15/18.
 */

public interface StoreApi {
    @GET("storeOffers/")
    Call<StoreInfo> getStoreInfo();
}