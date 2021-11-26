package com.pistis.vdoc.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.pistis.vdoc.database.DataBaseStorage
import com.pistis.vdoc.entities.Doenca
import symptomsme.symptomsme.empsoft.projeto.symptomsme.R

class DiagnosticoActivity : AppCompatActivity() {
    private var mDb: DataBaseStorage? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_diagnostico)

        mDb = DataBaseStorage(applicationContext)

//        if(mDb.getAllDoencas().size() == 0){
//            DBSPopulater populater = new DBSPopulater(getApplicationContext());
//            populater.populateBD();
//        }

        val doenca = intent.extras?.getSerializable("doenca") as Doenca?
        val especialidade = doenca?.getEspecialista()
        val toolbar = findViewById<Toolbar?>(R.id.Mytoolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (doenca != null) {
            title = doenca.getName()
        }

        val descricaoTv = findViewById<TextView?>(R.id.textViewDescription)
        if (doenca != null) {
            descricaoTv.text = doenca.getDescription()
        }

        val causasTv = findViewById<TextView?>(R.id.textViewCausasT)
        if (doenca != null) {
            causasTv.text = doenca.getCausas()
        }

        val sintomas: Array<String?> = doenca?.getSintomas()?.split(",")!!.toTypedArray()
        val verMedicosBt = findViewById<View?>(R.id.button_medicos) as Button
        verMedicosBt.setOnClickListener {
            val medicos = mDb!!.getMedicoByEspecialidade(especialidade)
            if (medicos != null) {
                if (medicos.size == 0) {
                    Toast.makeText(applicationContext, "No Doctors found", Toast.LENGTH_LONG).show()
                } else {
                    val i = Intent(applicationContext, MedicosActivity::class.java)
                    i.putExtra("medicos", medicos)
                    startActivity(i)
                }
            }
        }

        var sintomasFormatted = ""
        for (i in 0 until sintomas.size - 1) {
            sintomasFormatted = """
                $sintomasFormatted${sintomas[i]}
                
                """.trimIndent()
        }
        sintomasFormatted += sintomas[sintomas.size - 1]

        val sintomasTv = findViewById<View?>(R.id.textViewSintomasL) as TextView
        sintomasTv.text = sintomasFormatted

        val prevencoesTv = findViewById<View?>(R.id.textViewPrevencoesL) as TextView
        prevencoesTv.text = doenca.getPrevencao()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}