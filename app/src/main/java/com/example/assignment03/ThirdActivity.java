package com.example.assignment03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {
TextView nameText;
final static public String USER_KEY = "USER";
public String TAG = "demo3";
TextView emailText;

TextView roleText;
User user;


User profile;


String userType;


    ActivityResultLauncher<Intent> startFourthActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            if(result.getResultCode() == RESULT_OK ){
                Intent intent = result.getData();
                user = (User)result.getData().getSerializableExtra(ThirdActivity.USER_KEY);

                nameText.setText(user.getName());
                emailText.setText(user.getEmail());
                roleText.setText(user.getTypeButton());

            }
            else{

            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameText = findViewById(R.id.displayNameText);
        emailText = findViewById(R.id.displayEmailText);
        roleText = findViewById(R.id.displayRoleText);

        if(getIntent() != null && getIntent().hasExtra(SecondActivity.USER_KEY)){
            user = (User) getIntent().getSerializableExtra(SecondActivity.USER_KEY);
            nameText.setText(user.getName());
            emailText.setText(user.getEmail());
            roleText.setText(user.getTypeButton());
        }
        findViewById(R.id.updateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameText.getText().toString();
                String email = emailText.getText().toString();
                String role = roleText.getText().toString();

                //User user1 = new User(name, email, role);
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                intent.putExtra(USER_KEY, user);//sending fourthactivity a user
                startFourthActivity.launch(intent);




               // Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                //intent.putExtra(USER_KEY, profile);
                //intent.putExtra()
                //startFourthActivity.launch(intent);
            }

        });
        }
    }


    /*
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:id="@+id/main"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".ThirdActivity">

    <TextView
android:id="@+id/profileText"
android:layout_width="113dp"
android:layout_height="24dp"
android:layout_marginTop="16dp"
android:text="Profile"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toTopOf="parent" />

    <TextView
android:id="@+id/textView3"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_marginStart="60dp"
android:layout_marginTop="72dp"
android:text="Name:"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toBottomOf="@+id/profileText" />

    <TextView
android:id="@+id/textView4"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_marginTop="56dp"
android:text="Email:"
app:layout_constraintEnd_toEndOf="@+id/textView3"
app:layout_constraintHorizontal_bias="1.0"
app:layout_constraintStart_toStartOf="@+id/textView3"
app:layout_constraintTop_toBottomOf="@+id/textView3" />

    <TextView
android:id="@+id/textView5"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_marginTop="72dp"
android:text="Role:"
app:layout_constraintEnd_toEndOf="@+id/textView4"
app:layout_constraintStart_toStartOf="@+id/textView4"
app:layout_constraintTop_toBottomOf="@+id/textView4" />


    <Button
android:id="@+id/updateButton"
android:layout_width="0dp"
android:layout_height="wrap_content"
android:text="Update"
app:layout_constraintBottom_toBottomOf="parent"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintHorizontal_bias="0.0"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toBottomOf="@+id/displayEmailText"
app:layout_constraintVertical_bias="0.714" />

    <TextView
android:id="@+id/displayNameText"
android:layout_width="153dp"
android:layout_height="36dp"
android:text="TextView"
app:layout_constraintBottom_toBottomOf="@+id/textView3"
app:layout_constraintEnd_toEndOf="@+id/profileText"
app:layout_constraintHorizontal_bias="0.0"
app:layout_constraintStart_toStartOf="@+id/profileText"
app:layout_constraintTop_toTopOf="@+id/textView3"
app:layout_constraintVertical_bias="1.0" />

    <TextView
android:id="@+id/displayEmailText"
android:layout_width="165dp"
android:layout_height="37dp"
android:text="TextView"
app:layout_constraintBottom_toBottomOf="@+id/textView4"
app:layout_constraintEnd_toEndOf="@+id/displayNameText"
app:layout_constraintHorizontal_bias="0.0"
app:layout_constraintStart_toStartOf="@+id/displayNameText"
app:layout_constraintTop_toTopOf="@+id/textView4"
app:layout_constraintVertical_bias="1.0" />
</androidx.constraintlayout.widget.ConstraintLayout>


     */