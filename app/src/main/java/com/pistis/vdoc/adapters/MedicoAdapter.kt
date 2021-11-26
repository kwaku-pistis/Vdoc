package com.pistis.vdoc.adapters

import android.widget.BaseAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.LinearLayout
import symptomsme.symptomsme.empsoft.projeto.symptomsme.R
import android.widget.TextView
import com.pistis.vdoc.entities.Medico
import android.content.Context
import android.view.View
import java.util.ArrayList

/**
 * Created by Wesley Brenno on 15/05/2016.
 */
class MedicoAdapter(private val context: Context?, private val medicos: ArrayList<Medico?>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return medicos.size
    }

    override fun getItem(arg0: Int): Any? {
        return medicos[arg0]
    }

    override fun getItemId(arg0: Int): Long {
        return 0
    }

    override fun getView(arg0: Int, arg1: View?, arg2: ViewGroup?): View? {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(
            R.layout.medico_adapter, null
        ) as LinearLayout
        val name = layout.findViewById<View?>(R.id.nameDoctor) as TextView
        name.text = medicos[arg0]?.getNome()
        return layout
    }
}