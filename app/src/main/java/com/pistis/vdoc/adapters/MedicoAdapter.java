package com.pistis.vdoc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pistis.vdoc.entities.Medico;

import java.util.ArrayList;

import symptomsme.symptomsme.empsoft.projeto.symptomsme.R;

/**
 * Created by Wesley Brenno on 15/05/2016.
 */
public class MedicoAdapter extends BaseAdapter{

        private Context context;
        private ArrayList<Medico> medicos;

        public MedicoAdapter(Context context, ArrayList<Medico> medicos) {
            this.context = context;
            this.medicos = medicos;

        };

        @Override
        public int getCount() {
            return medicos.size();
        }

        @Override
        public Object getItem(int arg0) {
            return medicos.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final LinearLayout layout = (LinearLayout) inflater.inflate(
                    R.layout.medico_adapter, null);

            TextView name = (TextView) layout.findViewById(R.id.nameDoctor);
            name.setText(medicos.get(arg0).getNome());

            return layout;
        }

    }