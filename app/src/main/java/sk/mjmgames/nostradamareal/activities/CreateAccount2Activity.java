package sk.mjmgames.nostradamareal.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import sk.mjmgames.nostradamareal.R;

/**
 * Created by Filip on 27.7.2015.
 */
public class CreateAccount2Activity extends Activity implements View.OnClickListener {

    private Button btNext2;
    private EditText etCity, etEmail;
    private ImageButton ibBack1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account2);

        initWidgets();




    }

    private void initWidgets() {

        btNext2 = (Button) findViewById(R.id.btNext2);
        etCity = (EditText) findViewById(R.id.etCity);
        etEmail = (EditText) findViewById(R.id.etEmail);
        btNext2.setOnClickListener(this);
        //ibBack1 = (ImageButton) findViewById(R.id);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btNext2:
                if (!etEmail.getText().equals("") && !etCity.getText().equals(""))   {
                    startActivity(myIntent());
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.tv_fill), Toast.LENGTH_SHORT).show();
                }
            break;
            /*case : ibBack2
                finish();
            break;
        */
        }

    }

    private Intent myIntent() {
        Intent intent = getIntent();
        intent.setClass(CreateAccount2Activity.this, CreateAccount3Activity.class);
        System.out.println(intent.getAction() + intent.getPackage());
        intent.putExtra("city", etCity.getText());
        intent.putExtra("email", etCity.getText());
        return intent;
    }
}
