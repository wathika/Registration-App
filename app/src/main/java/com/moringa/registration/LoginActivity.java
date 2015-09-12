package com.moringa.registration;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginActivity extends Activity {

    protected EditText mUsername;
    protected EditText mPassword;
    protected Button mLoginBtn;
    protected Button mCreateAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialize
        mUsername = (EditText)findViewById(R.id.usernameLoginTextBox);
        mPassword = (EditText)findViewById(R.id.passwordLoginTextBox);
        mLoginBtn = (Button)findViewById(R.id.loginButton);
        mCreateAccountBtn = (Button)findViewById(R.id.createAccountButton);


        //listen to when mLoginBtn  is clicked
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the user inputs and convert to string
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                //login the user using parse(parse checks for User if the user is logged in)
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (e == null) {
                            //success: we have a user loggedin
                            Toast.makeText(LoginActivity.this, "Welcome Back.", Toast.LENGTH_LONG).show();

                            //take user to homepage
                            Intent takeUserHome = new Intent(LoginActivity.this, HomepageActivity.class);
                            startActivity(takeUserHome);

                        } else {
                            //sorry there was a problem logging in
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            builder.setMessage(e.getMessage());
                            builder.setTitle("Sorry!");
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //close the dialog
                                    dialog.dismiss();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();

                        }

                    }
                });
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
