package com.punbook.storeinfo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText emailField, phoneField;
    private TextView status,role,method;
 public static final String LOGTAG = "Details: ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = (EditText)findViewById(R.id.editText1);
        phoneField = (EditText)findViewById(R.id.editText2);

        status = (TextView)findViewById(R.id.textView6);
        role = (TextView)findViewById(R.id.textView7);
        method = (TextView)findViewById(R.id.textView9);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void login(View view){
        String email = emailField.getText().toString();
        String phone = phoneField.getText().toString();
        method.setText("Get Method");
        new SigninActivity(this,status,role,0).execute(email,phone);

    }

    public void loginPost(View view){
        String email = emailField.getText().toString();
        String phone = phoneField.getText().toString();
        method.setText("Post Method");
        Log.d(LOGTAG, "STARTED THE LOGIN POST");
        new SigninActivity(this,status,role,1).execute(email,phone);
    }
}
