package com.fmarcheni.projetoaula;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.txt_email)
    EditText userEmail;
    @Bind(R.id.txt_password)
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Prefs.getBoolean("isAuth", false)){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }


    @OnClick(R.id.btn_login)
    void login(){
        if(senha.getText().toString().equalsIgnoreCase("1") && userEmail.getText().toString().equalsIgnoreCase("1")){
            Prefs.putBoolean("isAuth", true);
            Prefs.putString("user", userEmail.getText().toString());
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Usuário ou senha inválidos.",Toast.LENGTH_SHORT).show();
            senha.setText("");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
