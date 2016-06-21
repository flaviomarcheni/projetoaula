package com.fmarcheni.projetoaula;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.fmarcheni.projetoaula.model.User;
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
            finish();
        }
    }


    @OnClick(R.id.btn_login)
    void login(){

        User u = User.findByUserAndPassword(userEmail.getText().toString(), senha.getText().toString());
        if(u!=null){
            Prefs.putBoolean("isAuth", true);
            Prefs.putString("user", u.getEmail());
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Usuário ou senha inválidos.",Toast.LENGTH_SHORT).show();
            senha.setText("");
        }
    }

    @OnClick(R.id.btn_novo_usuario)
    void novoUsuario(){
        Intent t = new Intent(this, CreateUserActivity.class);
        startActivity(t);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
