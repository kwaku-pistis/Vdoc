package com.pistis.vdoc.activities

import symptomsme.symptomsme.empsoft.projeto.symptomsme.R
import com.pistis.vdoc.database.DataBaseStorage
import com.pistis.vdoc.database.DBSPopulater
import android.os.Bundle
import android.content.Intent
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SintomaActivity : AppCompatActivity() {
    private var mDb: DataBaseStorage? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sintoma)

        mDb = DataBaseStorage(applicationContext)
        if (mDb!!.getAllDoencas()?.size == 0) {
            val populater = DBSPopulater(applicationContext)
            DBSPopulater.Companion.populateBD()
        }
        val etSintomas = findViewById<View?>(R.id.et_sintoma) as EditText
        val btPesquisar = findViewById<View?>(R.id.bt_pesquisar) as ImageView
        btPesquisar.setOnClickListener {
            if (etSintomas.text.toString().trim { it <= ' ' } == "") {
                Toast.makeText(applicationContext, "Type any symptom", Toast.LENGTH_LONG).show()
            } else {
                val sintomas: Array<String?> = etSintomas.text.toString().trim { it <= ' ' }
                    .split(",").toTypedArray()
                val doencas = mDb!!.getDoencasBySintomas(sintomas)
                if (doencas != null) {
                    if (doencas.size == 0) Toast.makeText(
                        applicationContext,
                        "No disease found",
                        Toast.LENGTH_LONG
                    ).show() else {
                        val i = Intent(applicationContext, DoencasActivity::class.java)
                        i.putExtra("doencas", doencas)
                        startActivity(i)
                    }
                }
            }
        }
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