package com.pistis.vdoc.adapters

import com.pistis.vdoc.entities.Doenca
import android.widget.BaseAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.LinearLayout
import symptomsme.symptomsme.empsoft.projeto.symptomsme.R
import android.widget.TextView
import android.content.Context
import android.view.View
import java.util.ArrayList

/**
 * Created by Wesley Brenno on 15/05/2016.
 */
class DoencaAdapter(private val context: Context?, private val doencas: ArrayList<Doenca?>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return doencas.size
    }

    override fun getItem(arg0: Int): Any? {
        return doencas[arg0]
    }

    override fun getItemId(arg0: Int): Long {
        return 0
    }

    override fun getView(arg0: Int, arg1: View?, arg2: ViewGroup?): View? {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(
            R.layout.doenca_adapter, null
        ) as LinearLayout
        val title = layout.findViewById<View?>(R.id.titleDoenca) as TextView
        title.text = doencas[arg0]?.getName()
        return layout
    }
}