package com.ngonyoku.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SubmissionActivity extends AppCompatActivity {

    private TextInputLayout mFirstName;
    private TextInputLayout mLastName;
    private TextInputLayout mEmail;
    private TextInputLayout mGithublink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        setSupportActionBar(findViewById(R.id.submission_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.project_submission));

        mFirstName = findViewById(R.id.first_name);
        mLastName = findViewById(R.id.last_name);
        mEmail = findViewById(R.id.email_address);
        mGithublink = findViewById(R.id.github_link);
    }

    public void submitDetails(View view) {
        String fistName = mFirstName.getEditText().getText().toString().trim();
        String lastName = mLastName.getEditText().getText().toString().trim();
        String email = mEmail.getEditText().getText().toString().trim();
        String link = mGithublink.getEditText().getText().toString().trim();

        if (validateInputs(fistName, mFirstName) && validateInputs(lastName, mLastName)
                && validateInputs(email, mEmail) && validateInputs(link, mGithublink)) {

        }

    }

    private boolean validateInputs(String value, TextInputLayout view) {
        if (value.isEmpty()) {
            view.setError("Field must not be empty");
            view.requestFocus();
            return false;
        } else {
            view.setError(null);
            return true;
        }
    }
}