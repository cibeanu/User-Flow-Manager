package com.example.assignment03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    public String TAG = "demo";
    final static public String USER_KEY = "USER";
EditText nameText;
EditText emailText;
String name;

String email;

String userType;
RadioGroup radioGroup;

String department;

    User user;

    ActivityResultLauncher<Intent> startThirdActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK ){

                nameText.setText(user.getName());
                emailText.setText(user.getEmail());

            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameText = findViewById(R.id.nameText);
        Log.d(TAG, String.valueOf(nameText));

        emailText = findViewById(R.id.emailText);

        radioGroup = findViewById(R.id.radioGroup);

        findViewById(R.id.updateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameText.getText().toString();
                email = emailText.getText().toString();
                int selectId = radioGroup.getCheckedRadioButtonId();
                if(selectId == R.id.studentButton){
                    userType = getString(R.string.student_label);
                } else if(selectId == R.id.employeeButton){
                    userType = getString(R.string.employee_label);
                } else if(selectId == R.id.otherButton){
                    userType = getString(R.string.other_label);
                }
                //Intent intent = new Intent();


                if(name.isEmpty()){
                    Toast.makeText(SecondActivity.this, "Enter a Name Please!", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Enter an Email Please!", Toast.LENGTH_SHORT).show();
                }else if (userType == null){
                        Toast.makeText(SecondActivity.this, "Select a button!", Toast.LENGTH_SHORT).show();

                    }
                else{
                    User profile = new User(name, email, userType);
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra(USER_KEY, profile);
                    startActivity(intent);
                    finish();




                }
            }
        });



    }
}