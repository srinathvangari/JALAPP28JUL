package com.ssvtech.jalforce;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ssvtech.jalforce.entity.CustomerBean;

import android.content.Intent;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Path;

public class CanDeliveryActivity extends AppCompatActivity {

  //  public  static String CUST_ID ="CUST_ID";
   // public  static String EMP_ID ="EMP_ID";


    public  static String CUST_ID ="CUST_ID";
    public  static String EMP_ID ="EMP_ID";

    public  static String CUST_FIRST_NAME ="CUST_ID";
    public  static String CUST_LAST_NAME ="EMP_ID";


    public  static String EMP_FIRST_NAME ="CUST_ID";
    public  static String EMP_LAST_NAME ="EMP_ID";


    public  static String CUST_MOBILE_NO ="CUST_ID";
    public  static String EMP_MOBILE_NO ="EMP_ID";


    public  static String CUST_ADDRESS ="CUST_ID";
    public  static String EMP_ADDRESS ="EMP_ID";


    public  static String RETURN_CAN ="CUST_ID";
    public  static String DELIVERED_CAN ="EMP_ID";


    private TextView textViewResult;
    private TextView textViewResult1;
    private TextView pendingCansWithCustomer;
    private Button dailyCanDeliveryButton;
    private EditText canDailyReturn;
    private EditText canDailyDeliver;
    CustomerBean customerBean = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_delivery);
        System.out.println("in CanDeliveryActivity ");

        textViewResult = (TextView) findViewById(R.id.textView1);


        // Get the transferred data from source activity.
        Intent intent = getIntent();
         customerBean = (CustomerBean)intent.getSerializableExtra("customerBean");

        System.out.println("in CanDeliveryActivity :FIrstNamw "+customerBean.getFirstName()+ " , LastName : "+customerBean.getLastName());

        textViewResult.setText("Customer Name  : "+customerBean.getFirstName() + " "+customerBean.getLastName());

        textViewResult1 = (TextView) findViewById(R.id.textView2);
        textViewResult1.setText("Customer Address  : "+customerBean.getAddress());

        pendingCansWithCustomer = (TextView) findViewById(R.id.pendingCansWithCustomer);
        pendingCansWithCustomer.setText("Pending Cans With Customer : "+customerBean.getPendingCans());



        dailyCanDeliveryButton = (Button) findViewById(R.id.btnSend);
        dailyCanDeliveryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("HEllooooooooo in dailyCanDeliveryButton");

                canDailyReturn = findViewById(R.id.canReturn);
                canDailyDeliver = findViewById(R.id.canDeliver);

                String returnString= canDailyReturn.getText().toString();
                int returnInt=Integer.parseInt(returnString);
                String deliverString= canDailyDeliver.getText().toString();
                int deliverInt=Integer.parseInt(deliverString);

                System.out.println("Can Return Daily: " + canDailyReturn.getText() + " : Can Deliver Daily : " + canDailyDeliver.getText()+ " Pending Cans :"+pendingCansWithCustomer.getText());
                Retrofit retrofit = RetrofitFactory.getRetrofit();
                JsonPlcaeHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlcaeHolderApi.class);


                Call<CustomerBean> call = jsonPlaceHolderApi.insertDD(returnInt, deliverInt,
                        customerBean.getId(), 2, customerBean.getFirstName(), customerBean.getLastName(),
                        "Chinna", "Chippa", "Ashok CHock", customerBean.getAddress(),
                        customerBean.getMobileNo(), "99993333",customerBean.getPendingCans());
                call.enqueue(new Callback<CustomerBean>() {
                    @Override
                    public void onResponse(Call<CustomerBean> call, Response<CustomerBean> response) {
                        CustomerBean customerBean = response.body();
                        System.out.println("CustomerBean != NULL : "+(customerBean!=null));
                        if (!response.isSuccessful()) {
                            //textViewResult.setText("Code: " + response.code());\
                            System.out.println("EZXCEPTION : INSERTED NOT SUCCESFULLY");
                            return;
                        }else{
                            System.out.println("INSERTED SUCCESFULLY");
                            openCanDevliery();
                        }

                    }

                    @Override
                    public void onFailure(Call<CustomerBean> call, Throwable t) {
                        System.out.println("t.getMessage(): " + t.getMessage());
                    }
                });
            }
        });

    }


    public void openCanDevliery(){
        Intent dailyDeliveryActivity = new Intent(this, DailyDeliveryActivity.class);
         startActivity(dailyDeliveryActivity);
    }
}
