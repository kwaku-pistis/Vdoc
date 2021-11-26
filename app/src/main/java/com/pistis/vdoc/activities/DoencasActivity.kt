package com.pistis.vdoc.activities

import com.pistis.vdoc.entities.Doenca
import symptomsme.symptomsme.empsoft.projeto.symptomsme.R
import android.os.Bundle
import android.content.Intent
import com.pistis.vdoc.adapters.DoencaAdapter
import android.widget.AdapterView.OnItemClickListener
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class DoencasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_doencas)

        //  final Toolbar toolbar = (Toolbar) findViewById(R.id.Mytoolbar);
        //    setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        val doencas = intent.extras?.getSerializable("doencas") as ArrayList<Doenca?>
        val mListDoencas = findViewById<View?>(R.id.listViewDoencas) as ListView
        mListDoencas.adapter = DoencaAdapter(this@DoencasActivity, doencas)
        mListDoencas.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val doenca = parent.getItemAtPosition(position) as Doenca
            val i = Intent(applicationContext, DiagnosticoActivity::class.java)
            i.putExtra("doenca", doenca)
            startActivity(i)
        }
    }
}