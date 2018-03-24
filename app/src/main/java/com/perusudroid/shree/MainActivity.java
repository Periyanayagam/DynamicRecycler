package com.perusudroid.shree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.perusudroid.shree.model.ResponseData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ResponseData> {

    private static final String TAG = MainActivity.class.getSimpleName();
    List<Country> myData;
    private RecyclerView mRecyclerView;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myData = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recycler_view);


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseData> call = apiInterface.getJSON();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {


        for (int i = 0; i < response.body().getData().size(); i++) {

            if (i % 3 == 1) {
                myData.add(new Country(response.body().getData().get(i).getName(), 2));
            } else {
                myData.add(new Country(response.body().getData().get(i).getName(), 1));
            }
        }


        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 2);
        mGridLayoutManager.setSpanSizeLookup(onSpanSizeLookup);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        customAdapter = new CustomAdapter(myData);
        mRecyclerView.setAdapter(customAdapter);

    }


    /**
     * Helper class to set span size for grid items based on orientation and device type
     */
    GridLayoutManager.SpanSizeLookup onSpanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
        @Override
        public int getSpanSize(int position) {
            return customAdapter.getItemViewType(position) == 2 ? 2 : 1;
        }
    };

    @Override
    public void onFailure(Call<ResponseData> call, Throwable t) {
        Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
    }



    public String getStringFromByte(InputStream paramInputStream) {
        StringBuilder localStringBuilder = new StringBuilder();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
        try {
            while (true) {
                String str = localBufferedReader.readLine();
                if (str == null)
                    break;
                localStringBuilder.append(str);
            }
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
        return localStringBuilder.toString();
    }


}
