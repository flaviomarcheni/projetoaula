package com.fmarcheni.projetoaula.fragments;

import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fmarcheni.projetoaula.R;

import java.text.DecimalFormat;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by flavi on 23/04/2016.
 */
public class CreateUserFragment extends BaseFragment {

    @Bind(R.id.altura)  EditText txtAltura;
    @Bind(R.id.peso)  EditText txtPeso;
    @Bind(R.id.txtResult) TextView txtResult;
    @Override
    protected int getLayout() {
        return R.layout.create_user_fragment;
    }

    @OnClick(R.id.btn_calcular)
    public void calcuclar(){
        String result ="";
        if(txtAltura.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"Informe o valor da Altura",Toast.LENGTH_SHORT).show();
        }else  if(txtPeso.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"Informe o valor do Peso",Toast.LENGTH_SHORT).show();
        }else{
            Float alt = Float.parseFloat(txtAltura.getText().toString());
            Float peso = Float.parseFloat(txtPeso.getText().toString());
            Float  imc = (peso)/(alt*alt);

            if (imc <= 19)
                result = "Abaixo do Peso";
            else
            if (imc <= 25)
                result = "Peso ideal";
            else
            if (imc <= 30)
                result = "Acima do Peso";
            else
            if (imc <= 35)
                result = "Obesidade Leve";
            else
                result = "Obesidade";

            DecimalFormat df = new DecimalFormat("#.00");
            txtResult.setText("IMC: "+df.format(imc)+"\nResultado: "+result);
        }

    }

    @Override
    protected int getTitle() {
        return R.string.calcular_imc;
    }

    @OnClick(R.id.btn_limpar)
    public void limparTela(){
        txtPeso.setText("");
        txtAltura.setText("");
        txtResult.setText("");
    }

}
