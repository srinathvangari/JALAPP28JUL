package com.example.jal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;




public class MainActivity extends AppCompatActivity {

    private EditText editViewResult;
    private EditText editViewResult1;
    private Button button;
    public final static String EXTRA_STRING ="";

    FirebaseAuth firebaseAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("UUuuuuuuuuu: " );
        firebaseAuth = FirebaseAuth.getInstance();

        //for registration
       /* firebaseAuth.createUserWithEmailAndPassword("srinathvangari2@yahoo.com", "xyz12345").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                System.out.println("createUserWithEmailAndPassword :: "+task.isSuccessful());
            }
        }); */







        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               System.out.println("HEllooooooooo");

                editViewResult = findViewById(R.id.editText);
                editViewResult1 = findViewById(R.id.editText2);


                  /*  String username = "srinathvangari1@yahoo.com";
                    String pwd= "xyz12345";*/

                String username = editViewResult.getText().toString();
                String pwd= editViewResult1.getText().toString();

                System.out.println("Username 3 : "+editViewResult.getText() +"  pass : "+editViewResult1.getText());


                //for Authentication
                final Task<AuthResult> xyz12345 = firebaseAuth.signInWithEmailAndPassword(username, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        System.out.println("signInWithEmailAndPassword  :: " + task.isSuccessful());

                       // EXTRA_STRING = task.getResult().getUser().getEmail();
                        if(task.isSuccessful()) {
                            System.out.println("Email  :: " + task.getResult().getUser().getEmail());

                            openActivity2();
                        }else{
                            System.out.println("LOGIN FAILED");
                        }
                    }
                });

            }
        });



         //calling Rest Api cand fetching data
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

    public void openActivity2(){
        Intent intent = new Intent(this, PassingData2Activity.class);
        intent.putExtra(EXTRA_STRING, editViewResult.getText().toString());
        startActivity(intent);
    }
}
