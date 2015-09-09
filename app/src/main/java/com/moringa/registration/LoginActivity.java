package com.moringa.registration;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


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
