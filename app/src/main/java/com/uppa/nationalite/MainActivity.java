package com.uppa.nationalite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.uppa.nationalite.databinding.ActivityMainBinding;
import com.uppa.nationalite.network.APi;
import com.uppa.nationalite.network.CountryItem;
import com.uppa.nationalite.network.NationaliteResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding ui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        Retrofit retrofit = new Retrofit.Builder()

                .addConverterFactory( GsonConverterFactory.create())
                .baseUrl("https://api.nationalize.io/")
                .build();
        APi service = retrofit.create(APi.class);

        ui.searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<NationaliteResponse> planetsCall = service.getNationalite(ui.search.getText().toString());
planetsCall.enqueue(new Callback<NationaliteResponse>() {
    @Override
    public void onResponse(Call<NationaliteResponse> call, Response<NationaliteResponse> response) {
        ArrayList<CountryItem> list = new ArrayList(response.body().getCountry());
        for (CountryItem countryItem : list) {
            ui.result.setText(ui.result.getText()+" : "+countryItem.getCountryId());
        }
    }

    @Override
    public void onFailure(Call<NationaliteResponse> call, Throwable t) {

    }
});
            }
        });

        setContentView(ui.getRoot());
    }
}