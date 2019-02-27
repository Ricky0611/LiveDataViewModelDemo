package com.example.rikki.livedataviewmodeldemo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private NameViewModel model;
    private TextView nameText;
    private EditText inputText;
    private Observer<String> nameObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.username);
        inputText = findViewById(R.id.inputText);

        model = ViewModelProviders.of(this).get(NameViewModel.class);
        nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@NonNull final String newName) {
                nameText.setText(newName);
            }
        };
        model.getName().observe(this, nameObserver);

        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                model.getName().setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        model.getName().removeObservers(this);
    }
}
