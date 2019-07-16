package com.pistis.vdoc.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.pistis.vdoc.entities.Medico;

import symptomsme.symptomsme.empsoft.projeto.symptomsme.R;

public class MedicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_medico);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.Mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Medico medico = (Medico) getIntent().getExtras().getSerializable("medico");

        TextView tvNomeMedico = (TextView)findViewById(R.id.textViewDoctorName);
        TextView tvEnderecoT = (TextView)findViewById(R.id.textViewEnderecoT);
        TextView tvInformacoesT = (TextView)findViewById(R.id.textViewInformacoesT);

        tvNomeMedico.setText(medico.getNome());
        tvEnderecoT.setText(medico.getEndereco() + ", " + medico.getTelefone());
        tvInformacoesT.setText(medico.getInformacoes());

        Button verNoMapa = (Button) findViewById(R.id.button_mapa);

        verNoMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(medico.getMaps()));
                startActivity(intent);
            }
        });
    }
}
