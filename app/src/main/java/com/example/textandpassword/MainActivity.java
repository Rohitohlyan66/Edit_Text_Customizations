package com.example.textandpassword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout passwordLayout;
    TextInputEditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordLayout = findViewById(R.id.passwordLayout);
        passwordEditText = findViewById(R.id.passwordEditText);


        //When the text in the field changes, this tracks the text -------->
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            //When text is changing,use this method------>
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                //If length is zero---->
                if (s.length() == 0) {
                    passwordLayout.setHelperTextEnabled(false);
                    passwordLayout.setHintTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
                    passwordLayout.setBoxStrokeColor(getResources().getColor(R.color.colorPrimaryDark));


                }

                //If length is less than six---->
                else if (s.length() < 6) {
                    passwordLayout.setHelperTextEnabled(true);
                    passwordLayout.setHelperText("Password is weak");
                    passwordLayout.setHelperTextColor(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    passwordLayout.setHintTextColor(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    passwordLayout.setBoxStrokeColor(getResources().getColor(R.color.red));

                }

                //for other cases---->
                else {
                    passwordLayout.setHelperTextEnabled(true);
                    passwordLayout.setHelperText("Password is Strong");
                    passwordLayout.setHelperTextColor(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                    passwordLayout.setHintTextColor(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                    passwordLayout.setBoxStrokeColor(getResources().getColor(R.color.green));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}