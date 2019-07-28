package com.ssvtech.jalforce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {


    private Button dailyDeliveryButton;
    private Button totalCansInPlantButton;
    private Button totalCansWithCustomersButton;
    private Button paymentButton;
    private Button reportButton;
    public final static String EXTRA_STRING ="";


    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        Intent intent = getIntent();
        String textValue = ((Intent) intent).getStringExtra(MainActivity.EXTRA_STRING);

        System.out.println("Value  :: "+textValue);

        //textViewResult = findViewById(R.id.textView3);
        //   textViewResult.setText(textValue);




        dailyDeliveryButton = (Button) findViewById(R.id.button1);
        dailyDeliveryButton.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View view) {
                                                       System.out.println("HEllooooooooo in dailyDeliveryButton");
                                                       openDailiDevliery();
                                                   }
                                               });



            totalCansInPlantButton = (Button) findViewById(R.id.button2);
        totalCansInPlantButton.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View view) {
                                                          System.out.println("HEllooooooooo in totalCansInPlantButton");
                                                          openTotalCansInPlant();
                                                      }
        });


        totalCansWithCustomersButton = (Button) findViewById(R.id.button3);
        totalCansWithCustomersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("HEllooooooooo in totalCansWithCustomersButton");
                openTotalCansWithCustomers();

            }
        });






/*

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
        */





    }


    public void openDailiDevliery(){
        Intent dailyDevliveryIntent = new Intent(this, DailyDeliveryActivity.class);
        dailyDevliveryIntent.putExtra(EXTRA_STRING, "In Daily Delivery Page");
        startActivity(dailyDevliveryIntent);
    }

    public void openTotalCansInPlant(){
        Intent totalCansInPlantIntent = new Intent(this, TotalCansInPlantActivity.class);
        totalCansInPlantIntent.putExtra(EXTRA_STRING, "TotalCansInPlantIntent Page");
        startActivity(totalCansInPlantIntent);
    }

    public void openTotalCansWithCustomers(){
        Intent intent = new Intent(this, TotalCansWithCustomersActivity.class);
        intent.putExtra(EXTRA_STRING, "TotalCansWithCustomersActivity Page ");
        startActivity(intent);
    }


}

