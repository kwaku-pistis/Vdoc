package com.pistis.vdoc.database;

/**
 * Created by Wesley Brenno on 14/05/2016.
 */
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.pistis.vdoc.entities.Doenca;
import com.pistis.vdoc.entities.Medico;

import com.pistis.vdoc.entities.Doenca;
import com.pistis.vdoc.entities.Medico;

// TODO: Auto-generated Javadoc
/**
 * The Class DataBaseStorage.
 */
public class DataBaseStorage {

	/*------------DOENCA TABLE----------------------*/

    /** The Constant TABLE_DOENCA. */
    public static final String TABLE_DOENCA = "DOENCA";

    /** The Constant COLUMN_DOENCA_ID. */
    public static final String COLUMN_DOENCA_ID = "_id_DOENCA";

    /** The Constant COLUMN_DOENCA_NAME. */
    public static final String COLUMN_DOENCA_NAME = "DOENCA_NAME";

    /** The Constant COLUMN_DOENCA_SINTOMAS. */
    public static final String COLUMN_DOENCA_SINTOMAS = "DOENCA_SINTOMAS";

    /** The Constant COLUMN_DOENCA_DESCRIPTION. */
    public static final String COLUMN_DOENCA_DESCRIPTION = "DOENCA_DESCRIPTION";

    /** The Constant COLUMN_DOENCA_CAUSAS. */
    public static final String COLUMN_DOENCA_CAUSAS = "DOENCA_CAUSAS";

    /** The Constant COLUMN_DOENCA_PREVENCAO. */
    public static final String COLUMN_DOENCA_PREVENCAO = "DOENCA_PREVENCAO";

    /** The Constant COLUMN_DOENCA_ESPECIALISTA. */
    public static final String COLUMN_DOENCA_ESPECIALISTA = "DOENCA_MEDICO_ESPECIALISTA";


	/*------------MEDICO TABLE----------------------*/

    /** The Constant TABLE_MEDICO. */
    public static final String TABLE_MEDICO = "MEDICO";

    /** The Constant COLUMN_MEDICO_ID. */
    public static final String COLUMN_MEDICO_ID = "_id_MEDICO";

    /** The Constant COLUMN_MEDICO_NAME. */
    public static final String COLUMN_MEDICO_NAME = "MEDICO_NAME";

    /** The Constant COLUMN_MEDICO_ESPECIALIDADE. */
    public static final String COLUMN_MEDICO_ESPECIALIDADE = "MEDICO_ESPECIALIDADE";

    /** The Constant COLUMN_MEDICO_ENDERECO. */
    public static final String COLUMN_MEDICO_ENDERECO = "MEDICO_ENDERECO";

    /** The Constant COLUMN_MEDICO_HORARIOS. */
    public static final String COLUMN_MEDICO_HORARIOS = "MEDICO_HORARIOS";

    /** The Constant COLUMN_MEDICO_TELEFONE. */
    public static final String COLUMN_MEDICO_TELEFONE = "MEDICO_TELEFONE";

    /** The Constant COLUMN_MEDICO_MAPS. */
    public static final String COLUMN_MEDICO_MAPS = "COLUMN_MEDICO_MAPS";


	/*----------------SQL_CREATE_COMANDS--------------*/

    /** The Constant DOENCA_CREATE_TABLE. */
    private static final String DOENCA_CREATE_TABLE = "CREATE TABLE "
            + TABLE_DOENCA + "  (" + COLUMN_DOENCA_ID
            + " INTEGER NOT NULL PRIMARY KEY," + COLUMN_DOENCA_NAME
            + " STRING, " + COLUMN_DOENCA_DESCRIPTION + " STRING, "
            + COLUMN_DOENCA_SINTOMAS + " STRING, "
            + COLUMN_DOENCA_CAUSAS + " STRING, "
            + COLUMN_DOENCA_PREVENCAO + " STRING, "
            + COLUMN_DOENCA_ESPECIALISTA + " STRING);";

    /** The Constant MEDICO_CREATE_TABLE. */
    private static final String MEDICO_CREATE_TABLE = "CREATE TABLE "
            + TABLE_MEDICO + "  (" + COLUMN_MEDICO_ID
            + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_MEDICO_NAME + " STRING, "
            + COLUMN_MEDICO_ENDERECO + " STRING, "
            + COLUMN_MEDICO_HORARIOS + " STRING, "
            + COLUMN_MEDICO_TELEFONE + " STRING, "
            + COLUMN_MEDICO_ESPECIALIDADE + " STRING, "
            + COLUMN_MEDICO_MAPS + " STRING);";


    /** The Constant TAG. */
    private static final String TAG = "DataBaseStorage";

    /** The m db helper. */
    private DatabaseHelper mDbHelper;

    /** The m db. */
    private SQLiteDatabase mDb;

    /** The Constant DB_NAME. */
    private static final String DB_NAME = "DBP";

    /** The Constant DATABASE_VERSION. */
    private static final int DATABASE_VERSION = 1;

    /** The m context. */
    private final Context mContext;

    /**
     * The Class DatabaseHelper.
     */
    public static final class DatabaseHelper extends SQLiteOpenHelper {

        /*
         * (non-Javadoc)
         *
         * @see
         * android.database.sqlite.SQLiteOpenHelper#onOpen(android.database.
         * sqlite.SQLiteDatabase)
         */
        @Override
        public void onOpen(final SQLiteDatabase db) {
            super.onOpen(db);
            Log.v(DB_NAME, "onOpenDB");
        }

        /**
         * Instantiates a new database helper.
         *
         * @param context
         *            the context
         */
        DatabaseHelper(final Context context) {
            super(context, DB_NAME, null, DATABASE_VERSION);
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database
         * .sqlite.SQLiteDatabase)
         */
        @Override
        public void onCreate(final SQLiteDatabase db) {
            db.execSQL(DOENCA_CREATE_TABLE);
            db.execSQL(MEDICO_CREATE_TABLE);

            Log.d("Create TABLE_DOENCA", DOENCA_CREATE_TABLE);
            Log.d("Create TABLE_MEDICO", MEDICO_CREATE_TABLE);

            Log.w("DataBaseStorage", "DB created sucefully!");
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database
         * .sqlite.SQLiteDatabase, int, int)
         */
        @Override
        public void onUpgrade(final SQLiteDatabase db, final int oldVersion,
                              final int newVersion) {
            Log.w(TAG, "Updating database from version " + oldVersion + " to "
                    + newVersion + ", all data will be lost!");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDICO);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOENCA);
            onCreate(db);
        }
    }

    /**
     * Instantiates a new data base storage.
     *
     * @param context
     *            the context
     */
    public DataBaseStorage(final Context context) {
        mContext = context;
        open();
    }

    /**
     * Open.
     *
     * @return the data base storage
     * @throws SQLException
     *             the SQL exception
     */
    public DataBaseStorage open() throws SQLException {
        mDbHelper = new DatabaseHelper(mContext);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    /**
     * Close.
     */
    public void close() {
        mDb.close();
    }

	/*---------DOENCA DATABASE METHODS----------*/

    /**
     * Adds the doenca
     *
     * @param doenca
     *            the doenca
     */
    public void addDoenca(final Doenca doenca) {

        final ContentValues values = new ContentValues();

      //  values.put(COLUMN_DOENCA_ID, doenca.getId());
        values.put(COLUMN_DOENCA_NAME, doenca.getName());
        values.put(COLUMN_DOENCA_DESCRIPTION, doenca.getDescription());
        values.put(COLUMN_DOENCA_SINTOMAS, doenca.getSintomas());
        values.put(COLUMN_DOENCA_CAUSAS, doenca.getCausas());
        values.put(COLUMN_DOENCA_PREVENCAO, doenca.getPrevencao());
        values.put(COLUMN_DOENCA_ESPECIALISTA, doenca.getEspecialista());

        mDb.insert(TABLE_DOENCA, null, values);
    }

    /**
     * Edits the doenca.
     *
     * @param doenca
     *            the doenca
     */
    public void editDoenca(final Doenca doenca) {

        final ContentValues values = new ContentValues();

        values.put(COLUMN_DOENCA_ID, doenca.getId());
        values.put(COLUMN_DOENCA_NAME, doenca.getName());
        values.put(COLUMN_DOENCA_DESCRIPTION, doenca.getDescription());
        values.put(COLUMN_DOENCA_SINTOMAS, doenca.getSintomas());
        values.put(COLUMN_DOENCA_CAUSAS, doenca.getCausas());
        values.put(COLUMN_DOENCA_PREVENCAO, doenca.getPrevencao());
        values.put(COLUMN_DOENCA_ESPECIALISTA, doenca.getEspecialista());

        mDb.update(TABLE_DOENCA, values, COLUMN_DOENCA_ID + "="
                + doenca.getId(), null);
    }

    /**
     * Gets the all weeks.
     *
     *
     *            the order
     * @return the all DoencasActivity
     */
    public final ArrayList<Doenca> getAllDoencas() {
        ArrayList<Doenca> doencas = new ArrayList<Doenca>();

        final String query = "SELECT " + COLUMN_DOENCA_ID + ", "
                + COLUMN_DOENCA_NAME + ", "
                + COLUMN_DOENCA_DESCRIPTION + ", "
                + COLUMN_DOENCA_SINTOMAS + ", "
                + COLUMN_DOENCA_PREVENCAO + ", "
                + COLUMN_DOENCA_CAUSAS + ", "
                + COLUMN_DOENCA_ESPECIALISTA
                + " FROM " + TABLE_DOENCA
                + " ORDER BY DOENCA_NAME" + " ASC " ;

        Log.d("Query",query);

        final Cursor mCursor = mDb.rawQuery(query, null);
        if (mCursor == null) {
            return null;
        } else {
            mCursor.moveToFirst();
        }
        while (!mCursor.isAfterLast()) {
            long id = mCursor.getInt(mCursor
                    .getColumnIndex(COLUMN_DOENCA_ID));

            String name = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_NAME));

            String description = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_DESCRIPTION));

            String sintomas = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_SINTOMAS));

            String prevencao = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_PREVENCAO));

            String causas = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_CAUSAS));

            String especialista = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_ESPECIALISTA));

            Doenca doenca = new Doenca(id, name, sintomas, description, causas, prevencao,especialista);

            doencas.add(doenca);
            mCursor.moveToNext();
        }
        return doencas;
    }

    /**
     * Gets the discipline by name.
     *
     * @param sintomas
     *            the name sintomas
     * @return the discipline by sintomas
     */
    public final ArrayList<Doenca> getDoencasBySintomas(
            final String[] sintomas) {

        ArrayList<Doenca> doencas = new ArrayList<Doenca>();

        String where = " WHERE UPPER(" + COLUMN_DOENCA_SINTOMAS + ") LIKE ";

        for(int i=0; i < sintomas.length - 1; i++){
            where = where + "'%" + sintomas[i].toUpperCase() + "%'"  + "AND UPPER(" + COLUMN_DOENCA_SINTOMAS + ") LIKE ";
        }

        where = where + "'%" + sintomas[sintomas.length - 1].toUpperCase() + "%' ";

        Log.d("Where",where);

        final String query = "SELECT " + COLUMN_DOENCA_ID + ", "
                + COLUMN_DOENCA_NAME + ", "
                + COLUMN_DOENCA_DESCRIPTION + ", "
                + COLUMN_DOENCA_SINTOMAS + ", "
                + COLUMN_DOENCA_PREVENCAO + ", "
                + COLUMN_DOENCA_CAUSAS + ", "
                + COLUMN_DOENCA_ESPECIALISTA
                + " FROM " + TABLE_DOENCA + where
                + " ORDER BY DOENCA_NAME" + " ASC " ;

        Log.d("Query",query);

        final Cursor mCursor = mDb.rawQuery(query, null);
        if (mCursor == null) {
            return null;
        } else {
            mCursor.moveToFirst();
        }
        while (!mCursor.isAfterLast()) {
            long id = mCursor.getInt(mCursor
                    .getColumnIndex(COLUMN_DOENCA_ID));

            String name = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_NAME));

            String description = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_DESCRIPTION));

            String sintomasN = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_SINTOMAS));

            String prevencao = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_PREVENCAO));

            String causas = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_CAUSAS));

            String especialista = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_DOENCA_ESPECIALISTA));

            Doenca doenca = new Doenca(id, name, sintomasN, description, causas, prevencao,especialista);

            doencas.add(doenca);
            mCursor.moveToNext();
        }
        return doencas;

    }

	/*---------MEDICO DATABASE METHODS----------*/

    /**
     * Adds the medico.
     *
     * @param medico
     *            the medico
     */
    public void addMedico(final Medico medico) {

        final ContentValues values = new ContentValues();

      //  values.put(COLUMN_MEDICO_ID, medico.getId());
        values.put(COLUMN_MEDICO_NAME, medico.getNome());
        values.put(COLUMN_MEDICO_ENDERECO, medico.getEndereco());
        values.put(COLUMN_MEDICO_HORARIOS, medico.getHorarios());
        values.put(COLUMN_MEDICO_TELEFONE, medico.getTelefone());
        values.put(COLUMN_MEDICO_ESPECIALIDADE, medico.getEspecialidade());
        values.put(COLUMN_MEDICO_MAPS, medico.getMaps());


        mDb.insert(TABLE_MEDICO, null, values);
    }

    /**
     * Edits the medico.
     *
     * @param medico
     *            the medico
     */
    public void editMedico(final Medico medico) {

        final ContentValues values = new ContentValues();

        values.put(COLUMN_MEDICO_ID, medico.getId());
        values.put(COLUMN_MEDICO_NAME, medico.getNome());
        values.put(COLUMN_MEDICO_ENDERECO, medico.getEndereco());
        values.put(COLUMN_MEDICO_HORARIOS, medico.getHorarios());
        values.put(COLUMN_MEDICO_TELEFONE, medico.getTelefone());
        values.put(COLUMN_MEDICO_ESPECIALIDADE, medico.getEspecialidade());
        values.put(COLUMN_MEDICO_MAPS, medico.getMaps());

        mDb.update(TABLE_MEDICO, values,
                COLUMN_MEDICO_ID + "=" + medico.getId(), null);
    }

    public final ArrayList<Medico> getAllMedicos() {
        ArrayList<Medico> medicos = new ArrayList<Medico>();

        final String query = "SELECT " + COLUMN_MEDICO_ID + ", "
                + COLUMN_MEDICO_NAME + ", " + COLUMN_MEDICO_ENDERECO + ", "
                + COLUMN_MEDICO_HORARIOS + ", "
                + COLUMN_MEDICO_TELEFONE + ", "
                + COLUMN_MEDICO_ESPECIALIDADE + ", " + COLUMN_MEDICO_MAPS
                +" FROM " + TABLE_MEDICO
                + " ORDER BY MEDICO_NAME" + " ASC ";

        Log.d("Query",query);

        final Cursor mCursor = mDb.rawQuery(query, null);
        if (mCursor == null) {
            return null;
        } else {
            mCursor.moveToFirst();
        }
        while (!mCursor.isAfterLast()) {
            long id = mCursor
                    .getLong(mCursor.getColumnIndex(COLUMN_MEDICO_ID));

            String nome = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_NAME));

            String endereco = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_ENDERECO));

            String horarios = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_HORARIOS));

            String telefone = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_TELEFONE));

            String especialidade = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_ESPECIALIDADE));

            String maps = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_MAPS));

            Medico medico = new Medico(id, nome, especialidade, endereco, horarios, telefone, maps);

            medicos.add(medico);
            mCursor.moveToNext();
        }
        return medicos;
    }

    public final ArrayList<Medico> getMedicoByEspecialidade(final String especialidadeBuscada) {
        ArrayList<Medico> medicos = new ArrayList<Medico>();

        final String query = "SELECT " + COLUMN_MEDICO_ID + ", "
                + COLUMN_MEDICO_NAME + ", " + COLUMN_MEDICO_ENDERECO + ", "
                + COLUMN_MEDICO_HORARIOS + ", "
                + COLUMN_MEDICO_TELEFONE + ", "
                + COLUMN_MEDICO_ESPECIALIDADE + ", " + COLUMN_MEDICO_MAPS
                +" FROM " + TABLE_MEDICO + " WHERE '"  +especialidadeBuscada.toUpperCase()  + "' = UPPER(" + COLUMN_MEDICO_ESPECIALIDADE + ")"
                + " ORDER BY MEDICO_NAME" + " ASC ";

        Log.d("Query",query);

        final Cursor mCursor = mDb.rawQuery(query, null);
        if (mCursor == null) {
            return null;
        } else {
            mCursor.moveToFirst();
        }
        while (!mCursor.isAfterLast()) {
            long id = mCursor
                    .getLong(mCursor.getColumnIndex(COLUMN_MEDICO_ID));

            String nome = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_NAME));

            String endereco = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_ENDERECO));

            String horarios = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_HORARIOS));

            String telefone = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_TELEFONE));

            String especialidade = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_ESPECIALIDADE));

            String maps = mCursor.getString(mCursor
                    .getColumnIndex(COLUMN_MEDICO_MAPS));

            Medico medico = new Medico(id, nome, especialidade, endereco, horarios, telefone, maps);

            medicos.add(medico);
            mCursor.moveToNext();
        }
        return medicos;
    }
}