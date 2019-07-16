package com.pistis.vdoc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pistis.vdoc.adapters.DoencaAdapter;
import com.pistis.vdoc.entities.Doenca;

import java.util.ArrayList;

import symptomsme.symptomsme.empsoft.projeto.symptomsme.R;


public class DoencasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_doencas);

     //  final Toolbar toolbar = (Toolbar) findViewById(R.id.Mytoolbar);
    //    setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Doenca> doencas = (ArrayList<Doenca>) getIntent().getExtras().getSerializable("doencas");

        ListView mListDoencas = (ListView) findViewById(R.id.listViewDoencas);

        mListDoencas.setAdapter(new DoencaAdapter(DoencasActivity.this, doencas));

        mListDoencas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Doenca doenca = (Doenca) parent.getItemAtPosition(position);

                Intent i = new Intent(getApplicationContext(), DiagnosticoActivity.class);
                i.putExtra("doenca",doenca);

                startActivity(i);
            }
        });

       }

}
