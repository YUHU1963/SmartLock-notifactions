package com.example.smartlock;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.smartlock.R;

public class CreateAccountDialogFragment extends DialogFragment {

    private EditText etUsername, etPassword, etReenterPassword;
    private Button btnCreateAccount;
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_create_account, container, false);

        databaseHelper = new DatabaseHelper(getContext());

        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        etReenterPassword = view.findViewById(R.id.etReenterPassword);
        btnCreateAccount = view.findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            String reenterPassword = etReenterPassword.getText().toString();

            if (password.equals(reenterPassword)) {
                boolean isAdded = databaseHelper.addUser(username, password);
                if (isAdded) {
                    Toast.makeText(getContext(), "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    dismiss();
                } else {
                    Toast.makeText(getContext(), "Error creating account", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}