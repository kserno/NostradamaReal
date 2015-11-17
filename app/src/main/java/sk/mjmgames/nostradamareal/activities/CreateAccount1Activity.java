package sk.mjmgames.nostradamareal.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sk.mjmgames.nostradamareal.R;

/**
 * Created by Filip on 27.7.2015.
 */
public class CreateAccount1Activity extends Activity{

    private EditText etName, etPassword;
    private Button btNext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account1);

        initWidgets();


    }

    private void initWidgets() {
        etName=(EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btNext1 = (Button) findViewById(R.id.btNext1);

        btNext1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPassword.getText().length() > 7 && !etName.getText().equals("")) {

                    startActivity(myIntent());

                } else if (etName.getText().equals("")) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.tv_fill), Toast.LENGTH_LONG).show();
                } else if (etPassword.getText().length() < 7) {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_shortpassword), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private Intent myIntent() {
        Intent intent = new Intent(CreateAccount1Activity.this, CreateAccount2Activity.class);
        intent.putExtra("username", etName.getText());
        intent.putExtra("password", etPassword.getText());
        return intent;
    }




}
