package com.fmarcheni.projetoaula.fragments;

import android.widget.TextView;

import com.fmarcheni.projetoaula.R;
import com.pixplicity.easyprefs.library.Prefs;

import butterknife.Bind;

/**
 * Created by flavi on 23/04/2016.
 */
public class MainFragment extends BaseFragment {

    @Bind(R.id.txt_inicio)
    TextView textInicio;
    @Override
    protected int getLayout() {
        return R.layout.main_fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        textInicio.setText("Bem vindo: "+ Prefs.getString("user",""));
    }
}
