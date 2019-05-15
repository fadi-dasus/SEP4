package com.example.sensorsproject.application.views;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sensorsproject.R;
import com.example.sensorsproject.application.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.login_mail)
    EditText userMail;
    @BindView(R.id.login_password)
    EditText userPassword;
    @BindView(R.id.login_button)
    Button btnLogin;
    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.login_photo)
    ImageView loginPhoto;

    private FirebaseAuth mAuth;
    private Fragment roomChoice;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        Button button = view.findViewById(R.id.login_button);
        button.setOnClickListener((View v) -> {
            MainActivity.navController.navigate(R.id.action_loginFragment_to_roomChoiceFragment);
        });


        mAuth = FirebaseAuth.getInstance();

        // start

        loginProgress.setVisibility(View.INVISIBLE);
        btnLogin.setOnClickListener(v -> {
            loginProgress.setVisibility(View.VISIBLE);
             btnLogin.setVisibility(View.INVISIBLE);

            final String mail = userMail.getText().toString();
            final String password = userPassword.getText().toString();

            if (mail.isEmpty() || password.isEmpty()) {
                showMessage("Please Verify All Fields");
                btnLogin.setVisibility(View.VISIBLE);
                loginProgress.setVisibility(View.INVISIBLE);
            } else {
                signIn(mail, password);
            }
        });
        // end

        view.findViewById(R.id.login_button).setOnClickListener((View v) -> {
            MainActivity.navController.navigate(R.id.action_loginFragment_to_roomChoiceFragment);
        });

        return view;
    }

    private void signIn(String mail, String password) {

        mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    loginProgress.setVisibility(View.INVISIBLE);
                    btnLogin.setVisibility(View.VISIBLE);


                    Toast.makeText(getContext(), "Logged in successfully!", Toast.LENGTH_LONG).show();
                    MainActivity.navController.navigate(R.id.action_loginFragment_to_roomChoiceFragment);
                } else {
                    showMessage(task.getException().getMessage());
                    btnLogin.setVisibility(View.VISIBLE);
                    loginProgress.setVisibility(View.INVISIBLE);

                }

            }
        });

    }
//
//
        private void showMessage (String text){

            Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();

        }
//
        @Override
        public void onStart() {
            super.onStart();

            FirebaseUser user = mAuth.getCurrentUser();

            if (user != null) {
                // user is already connected so need to redirect him to home page

                Toast.makeText(getContext(), "Logged in successfully!", Toast.LENGTH_LONG).show();
                btnLogin.setOnClickListener((View v) -> MainActivity.navController.navigate(R.id.action_loginFragment_to_roomChoiceFragment));
            }

        }


    }
