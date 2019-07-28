package com.ssvtech.jalforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.ssvtech.jalforce.adapter.CustomerListAdapter;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.ssvtech.jalforce.entity.CustomerBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import java.util.Map;
import java.util.HashMap;


public class DailyDeliveryActivity extends AppCompatActivity {


    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_delivery);



      //  textViewResult = findViewById(R.id.textView3);
        //   textViewResult.setText(textValue);


        Retrofit retrofit = RetrofitFactory.getRetrofit();
        JsonPlcaeHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlcaeHolderApi.class);

        Call<List<CustomerBean>> call = jsonPlaceHolderApi.getAllCustomerList();
        call.enqueue(new Callback<List<CustomerBean>>() {
            @Override
            public void onResponse(Call<List<CustomerBean>> call, Response<List<CustomerBean>> response) {

                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<CustomerBean> posts = response.body();


       /* Call<CustomerBean> call = jsonPlaceHolderApi.getCustomer(3);
        call.enqueue(new Callback<CustomerBean>() {
            @Override
            public void onResponse(Call<CustomerBean> call, Response<CustomerBean> response) {

                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }
                CustomerBean posts1 = response.body();

                List<CustomerBean> posts = new ArrayList<CustomerBean>();
                posts.add(posts1);*/







                final ListView lv = (ListView) findViewById(R.id.user_list);
                lv.setAdapter(new CustomerListAdapter( getApplicationContext(), posts));
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                        CustomerBean customerBean = (CustomerBean) lv.getItemAtPosition(position);
                        Toast.makeText(DailyDeliveryActivity.this, "Selected :" + " " + customerBean.getFirstName()
                                        +", "+ customerBean.getLastName(),
                                Toast.LENGTH_SHORT).show();
                       // String custname = customerBean.getFirstName()+" "+customerBean.getLastName();
                        //String custAddress = customerBean.getAddress();

                        openCanDevliery(customerBean);
                    }
                });


            }

            @Override
            public void onFailure(Call<List<CustomerBean>> call, Throwable t) {
          // public void onFailure(Call<CustomerBean> call, Throwable t) {
                // textViewResult.setText(t.getMessage());
                System.out.println("t.getMessage(): " + t.getMessage());
            }
        });



    }



    public void openCanDevliery(CustomerBean customerBean){
        Intent canDevliveryIntent = new Intent(this, CanDeliveryActivity.class);
        canDevliveryIntent.putExtra("customerBean", customerBean);
        startActivity(canDevliveryIntent);
    }
}
