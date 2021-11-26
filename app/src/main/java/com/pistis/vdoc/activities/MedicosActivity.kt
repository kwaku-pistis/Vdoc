package com.pistis.vdoc.activities

import symptomsme.symptomsme.empsoft.projeto.symptomsme.R
import com.pistis.vdoc.entities.Medico
import android.os.Bundle
import android.content.Intent
import android.widget.AdapterView.OnItemClickListener
import com.pistis.vdoc.adapters.MedicoAdapter
import android.view.View
import android.view.Window
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.util.ArrayList

class MedicosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_medicos)

        val toolbar = findViewById<View?>(R.id.Mytoolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val medicos = intent.extras?.getSerializable("medicos") as ArrayList<*>
        val mListMedicos = findViewById<View?>(R.id.listViewMedicos) as ListView
        val medicoAdapter = MedicoAdapter(this, medicos as ArrayList<Medico?>)

        mListMedicos.adapter = medicoAdapter
        mListMedicos.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val medico = medicoAdapter.getItem(position) as Medico
            val i = Intent(applicationContext, MedicoActivity::class.java)
            i.putExtra("medico", medico)
            startActivity(i)
        }
    }
}