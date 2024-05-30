package com.example.assignment03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
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

public class FourthActivity extends AppCompatActivity {

    EditText nameText;
    public String TAG = "demo";

    final static public String USER_KEY = "USER";

    String name;

    String email;

    String role;
    User user;
    EditText emailText;

    RadioGroup radioGroup;

    String userType;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        Log.d(TAG, "onCreate: ");
        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        radioGroup = findViewById(R.id.radioGroup);



        /*
        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(SecondActivity.USER_KEY)){
            User user = (User)getIntent().getSerializableExtra(SecondActivity.USER_KEY);
            nameText.setText(user.name);
            Log.d(TAG, "Name is: " + user.name);
            emailText.setText(user.email);

            //receieving data sent from third
*/      if(getIntent() != null && getIntent().hasExtra(ThirdActivity.USER_KEY)){
            User profile = (User) getIntent().getSerializableExtra(SecondActivity.USER_KEY);
            nameText.setText(profile.getName());
            emailText.setText(profile.getEmail());
            if(profile.getTypeButton().equals("Student")){
                Log.d(TAG, profile.getTypeButton());
                radioGroup.check(R.id.studentButton);
            } else if (profile.getTypeButton().equals("Employee")) {
                radioGroup.check(R.id.employeeButton);
            } else if (profile.getTypeButton().equals("Other")) {
                radioGroup.check(R.id.otherButton);
            }

        }

        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

        findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameText.getText().toString();
                email = emailText.getText().toString();
                int selectId = radioGroup.getCheckedRadioButtonId();
                if (selectId == R.id.studentButton) {
                    userType = getString(R.string.student_label);
                } else if (selectId == R.id.employeeButton) {
                    userType = getString(R.string.employee_label);
                } else if (selectId == R.id.otherButton) {
                    userType = getString(R.string.other_label);
                }

                if (name.isEmpty()) {
                    Toast.makeText(FourthActivity.this, "Enter a Name Please!", Toast.LENGTH_SHORT).show();

                } else if (email.isEmpty()) {
                    Toast.makeText(FourthActivity.this, "Enter an Email Please!", Toast.LENGTH_SHORT).show();
                } else if (userType == null) {
                    Toast.makeText(FourthActivity.this, "Select a button!", Toast.LENGTH_SHORT).show();

                } else {
                    User profile = new User(name, email, userType);
                    Intent intent = new Intent();
                    intent.putExtra(USER_KEY, profile);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
        }
