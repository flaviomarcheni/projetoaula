package com.fmarcheni.projetoaula.fragments;

import android.widget.EditText;
import android.widget.Toast;

import com.fmarcheni.projetoaula.R;
import com.fmarcheni.projetoaula.model.User;
import com.pixplicity.easyprefs.library.Prefs;


import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by flavi on 23/04/2016.
 */
public class UpdateUserFragment extends BaseFragment {
    @Bind(R.id.txt_nome)
    EditText txtName;
    @Bind(R.id.txt_email)
    EditText txtEmail;
    @Bind(R.id.txt_new_password)
    EditText txtNewPassword;
    @Bind(R.id.txt_old_password)
    EditText txtOldPassword;
    User user;
    @Override
    protected int getTitle() {
        return R.string.update_data;
    }

    @Override
    public void onResume() {
        super.onResume();
        try{
            user = User.findById(Prefs.getLong("user_id", 0));
            txtName.setText(user.getName());
            txtEmail.setText(user.getEmail());
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    protected int getLayout() {
        return R.layout.update_user_fragment;
    }

    @OnClick(R.id.btn_save)
    public void salvar() {
        try {
            User u = new User(txtName.getText().toString().trim(),txtEmail.getText().toString().trim());
            // informou um email diferente, deverá validar se existe no banco alguém com  o novo email
            if (!u.getEmail().equalsIgnoreCase(user.getEmail())) {
                User check = User.findByEmail(u.getEmail());
                if (check != null) {
                    throw new Exception("O email informado já existe.");
                }
            }
            user.setName(u.getName());
            user.setEmail(u.getEmail());
            // informou uma nova senha. deverá ser validada.
            String newPassword = txtNewPassword.getText().toString().trim();
            String oldPassword = txtOldPassword.getText().toString().trim();
            if (!oldPassword.isEmpty() || !newPassword.isEmpty()) {
                if (!user.getPassword().equalsIgnoreCase(oldPassword)) {
                    throw new Exception("Senha atual não confere.");
                }
                if (newPassword.length() < 6) {
                    throw new Exception("A senha deve ter no mínimo 6 caracters.");
                }
                user.setPassword(newPassword);
            }
            user.save();
            txtNewPassword.setText("");
            txtOldPassword.setText("");
            Toast.makeText(getContext(),"Dados alterados com sucesso.",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {e.printStackTrace();
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }



}
