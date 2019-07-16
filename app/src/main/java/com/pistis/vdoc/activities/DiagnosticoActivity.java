package com.pistis.vdoc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pistis.vdoc.database.DataBaseStorage;
import com.pistis.vdoc.entities.Doenca;
import com.pistis.vdoc.entities.Medico;

import java.util.ArrayList;

import symptomsme.symptomsme.empsoft.projeto.symptomsme.R;

public class DiagnosticoActivity extends AppCompatActivity {

    private DataBaseStorage mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_diagnostico);

        mDb = new DataBaseStorage(getApplicationContext());

//        if(mDb.getAllDoencas().size() == 0){
//            DBSPopulater populater = new DBSPopulater(getApplicationContext());
//            populater.populateBD();
//        }

        Doenca doenca = (Doenca) getIntent().getExtras().getSerializable("doenca");
        final String especialidade = doenca.getEspecialista();

        final Toolbar toolbar = findViewById(R.id.Mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(doenca.getName());


        TextView descricaoTv = findViewById(R.id.textViewDescription);
        descricaoTv.setText(doenca.getDescription());

        TextView causasTv = findViewById(R.id.textViewCausasT);
        causasTv.setText(doenca.getCausas());

        String[] sintomas = doenca.getSintomas().split(",");

        Button verMedicosBt = (Button) findViewById(R.id.button_medicos);

        verMedicosBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Medico> medicos = mDb.getMedicoByEspecialidade(especialidade);
                if(medicos.size() == 0 ){
                    Toast.makeText(getApplicationContext(), "No Doctors found", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent i = new Intent(getApplicationContext(), MedicosActivity.class);
                    i.putExtra("medicos",medicos);

                    startActivity(i);
                }
            }
        });

        String sintomasFormatted = "";

        for(int i = 0; i < sintomas.length - 1; i++){
            sintomasFormatted = sintomasFormatted + sintomas[i] + "\n";
        }

        sintomasFormatted = sintomasFormatted + sintomas[sintomas.length - 1];

        TextView sintomasTv = (TextView) findViewById(R.id.textViewSintomasL);
        sintomasTv.setText(sintomasFormatted);

        TextView prevencoesTv = (TextView) findViewById(R.id.textViewPrevencoesL);
        prevencoesTv.setText(doenca.getPrevencao());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}