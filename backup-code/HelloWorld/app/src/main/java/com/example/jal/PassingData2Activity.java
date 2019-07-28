package com.example.jal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PassingData2Activity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String textValue = ((Intent) intent).getStringExtra(MainActivity.EXTRA_STRING);

        System.out.println("Value  :: "+textValue);

        textViewResult = findViewById(R.id.textView3);
     //   textViewResult.setText(textValue);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-13-233-108-179.ap-south-1.compute.amazonaws.com:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlcaeHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlcaeHolderApi.class);

        Call<List<Dailydelivery>> call = jsonPlaceHolderApi.getDailydelivery();

        call.enqueue(new Callback<List<Dailydelivery>>() {
            @Override
            public void onResponse(Call<List<Dailydelivery>> call, Response<List<Dailydelivery>> response) {

                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    // textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Dailydelivery> posts = response.body();

                for (Dailydelivery post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "CustomerId: " + post.getCustomerId() + "\n";
                    content += "DeliveredCanCount: " + post.getDeliveredCanCount() + "\n";
                    content += "ReturnCanCount: " + post.getReturnCanCount() + "\n\n";

                    textViewResult.append(content);
                    System.out.println("content: " + content);
                }
            }

            @Override
            public void onFailure(Call<List<Dailydelivery>> call, Throwable t) {
                // textViewResult.setText(t.getMessage());
                System.out.println("t.getMessage(): " + t.getMessage());
            }
        });
    }

}
