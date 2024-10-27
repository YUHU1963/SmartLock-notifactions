
package com.example.smartlock;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            boolean isValid = databaseHelper.checkUser(username, password);
            if (isValid) {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                // Proceed to the next activity
            } else {
                Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnCreateAccount).setOnClickListener(v -> {

            FragmentManager fragmentManager = getSupportFragmentManager();
            CreateAccountDialogFragment createAccountDialog = new CreateAccountDialogFragment();
            createAccountDialog.show(fragmentManager, "create_account_dialog");
        });
    }
}
