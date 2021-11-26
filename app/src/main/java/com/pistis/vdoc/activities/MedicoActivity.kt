package com.pistis.vdoc.activities

import symptomsme.symptomsme.empsoft.projeto.symptomsme.R
import com.pistis.vdoc.entities.Medico
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MedicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_medico)

        val toolbar = findViewById<View?>(R.id.Mytoolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val medico = intent.extras?.getSerializable("medico") as Medico?
        val tvNomeMedico = findViewById<View?>(R.id.textViewDoctorName) as TextView
        val tvEnderecoT = findViewById<View?>(R.id.textViewEnderecoT) as TextView
        val tvInformacoesT = findViewById<View?>(R.id.textViewInformacoesT) as TextView

        if (medico != null) {
            tvNomeMedico.text = medico.getNome()
        }
        if (medico != null) {
            tvEnderecoT.text = medico.getEndereco() + ", " + medico.getTelefone()
        }
        if (medico != null) {
            tvInformacoesT.text = medico.getInformacoes()
        }

        val verNoMapa = findViewById<View?>(R.id.button_mapa) as Button
        verNoMapa.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            if (medico != null) {
                intent.data = Uri.parse(medico.getMaps())
            }
            startActivity(intent)
        }
    }
}