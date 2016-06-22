package com.fmarcheni.projetoaula;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.fmarcheni.projetoaula.model.User;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateUserActivity extends AppCompatActivity {

    @Bind(R.id.txt_nome)
    TextView emailTxt;
    @Bind(R.id.txt_email)
    TextView nomeTxt;
    @Bind(R.id.txt_password)
    TextView senhaTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_save)
    public void salvar(){
        try {
            User u = new User(emailTxt.getText().toString().trim(), nomeTxt.getText().toString().trim(), senhaTxt.getText().toString().toString());
            User userCheck = User.findByEmail(u.getEmail());
            if(userCheck!=null){
                throw new Exception("O email informado já existe.");
            }
            u.save();
            Toast.makeText(this, "Usuário salvo com sucesso.",Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
}
