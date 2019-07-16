package com.pistis.vdoc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pistis.vdoc.entities.Doenca;

import java.util.ArrayList;

import symptomsme.symptomsme.empsoft.projeto.symptomsme.R;

/**
 * Created by Wesley Brenno on 15/05/2016.
 */
public class DoencaAdapter extends BaseAdapter{



        private Context context;
        private ArrayList<Doenca> doencas;

        public DoencaAdapter(Context context, ArrayList<Doenca> doencas) {
            this.context = context;
            this.doencas = doencas;

        };

        @Override
        public int getCount() {
            return doencas.size();
        }

        @Override
        public Object getItem(int arg0) {
            return doencas.get(arg0);
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
                    R.layout.doenca_adapter, null);

            TextView title = (TextView) layout.findViewById(R.id.titleDoenca);
            title.setText(doencas.get(arg0).getName());

            return layout;
        }

    }

