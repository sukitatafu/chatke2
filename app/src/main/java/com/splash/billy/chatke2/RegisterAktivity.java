package com.splash.billy.chatke2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Billy on 09/01/2018.
 */

public class RegisterAktivity extends AppCompatActivity {
    User user;
    EditText nama,nohp,email;
    Button regis;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nama = (EditText) findViewById(R.id.etnama);
        nohp = (EditText) findViewById(R.id.ettlpn);
        email = (EditText) findViewById(R.id.etemail);
        regis = (Button) findViewById(R.id.btregis);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = new User();
                user.setTelepon(nohp.getText().toString());
                user.setNama(nama.getText().toString());
                user.setEmail(email.getText().toString());
                user.register();
                Toast.makeText(getApplicationContext(),"Register sukses",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterAktivity.this, LoginAktivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

}
