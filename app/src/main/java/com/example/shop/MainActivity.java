package com.example.shop;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.ContactsContract;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView edName;
    private TextView edEmail;
    private TextView edPassword;
    private ImageView resultName;
    private ImageView resultPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName = findViewById(R.id.ed_name);
        edEmail = findViewById(R.id.ed_email);
        edPassword = findViewById(R.id.ed_password);
        resultName = findViewById(R.id.result_name);
        resultPassword = findViewById(R.id.result_password);
        resultName.setVisibility(View.GONE);
        resultPassword.setVisibility(View.GONE);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    public void reset(){
        edName.setText("");
        edPassword.setText("");
        edEmail.setText("");
        resultName.setVisibility(View.GONE);
        resultPassword.setVisibility(View.GONE);
    }

    public void test(View view) {
        final DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();;
            }
        };
        if (edName.length() < 4 && edPassword.length() < 6) {
            resultName.setVisibility(view.VISIBLE);
            resultName.setImageResource(R.drawable.wrong);
            resultPassword.setVisibility(View.VISIBLE);
            resultPassword.setImageResource(R.drawable.wrong);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Information")
                    .setMessage("Please enter again ")
                    .setPositiveButton("OK", null)
                    .show();
        }else if (edName.length() >= 4 && edPassword.length() < 6) {
            resultName.setVisibility(view.VISIBLE);
            resultName.setImageResource(R.drawable.ok);
            resultPassword.setVisibility(View.VISIBLE);
            resultPassword.setImageResource(R.drawable.wrong);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Information")
                    .setMessage("Password must > 6")
                    .setPositiveButton("OK", null)
                    .show();
        }else if (edName.length() < 4 && edPassword.length() >=6){
            resultName.setVisibility(view.VISIBLE);
            resultName.setImageResource(R.drawable.wrong);
            resultPassword.setVisibility(view.VISIBLE);
            resultPassword.setImageResource(R.drawable.ok);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Information")
                    .setMessage("Name must > 4")
                    .setPositiveButton("OK", null)
                    .show();
        }else {
            resultName.setVisibility(view.VISIBLE);
            resultName.setImageResource(R.drawable.ok);
            resultPassword.setVisibility(View.VISIBLE);
            resultPassword.setImageResource(R.drawable.ok);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Information")
                    .setMessage("Register seccessful")
                    .setPositiveButton("OK", listener)
                    .show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
