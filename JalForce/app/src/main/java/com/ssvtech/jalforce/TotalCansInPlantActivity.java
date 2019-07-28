package com.ssvtech.jalforce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import android.graphics.Typeface;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TotalCansInPlantActivity extends AppCompatActivity {

    private TextView tv1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_cans_in_plant);



        Retrofit retrofit = RetrofitFactory.getRetrofit();
        JsonPlcaeHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlcaeHolderApi.class);

        Call<Integer> call = jsonPlaceHolderApi.getTotalCansInPlant();

        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {

                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    // textViewResult.setText("Code: " + response.code());
                    return;
                }

                Integer posts = response.body();
                System.out.println("posts  TOTALCANS in PLANT: " + posts.intValue());
                 tv1 = (TextView) findViewById(R.id.text_view3);
                //set text style bold on current font
                tv1.setTypeface(tv1.getTypeface(), Typeface.BOLD);
                tv1.setText("TOTAL CANS IN PLANT : "+posts.intValue());

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                // textViewResult.setText(t.getMessage());
                System.out.println("t.getMessage(): " + t.getMessage());
            }
        });


    }
}
