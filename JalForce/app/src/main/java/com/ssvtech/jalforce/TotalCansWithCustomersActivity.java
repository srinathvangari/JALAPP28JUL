package com.ssvtech.jalforce;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TotalCansWithCustomersActivity extends AppCompatActivity {

    private TextView tv1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_cans_with_customers);



        Retrofit retrofit = RetrofitFactory.getRetrofit();
        JsonPlcaeHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlcaeHolderApi.class);

        Call<Integer> call = jsonPlaceHolderApi.getTotalCansWithCustomers();

        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {

                if (!response.isSuccessful()) {
                    return;
                }

                Integer posts = response.body();
                System.out.println("posts  CANS with Customers : " + posts.intValue());
                tv1 = (TextView) findViewById(R.id.text_view3);
                //set text style bold on current font
                tv1.setTypeface(tv1.getTypeface(), Typeface.BOLD);
                tv1.setText("Total CANS with Customers :  "+posts.intValue());

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                // textViewResult.setText(t.getMessage());
                System.out.println("t.getMessage(): " + t.getMessage());
            }
        });

    }
}
