package com.perusudroid.shree;

import com.perusudroid.shree.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Intel on 23-03-2018.
 */

public interface ApiInterface {

    //@GET("android/jsonandroid")
    @GET("sri.php")
    Call<ResponseData> getJSON();


}
