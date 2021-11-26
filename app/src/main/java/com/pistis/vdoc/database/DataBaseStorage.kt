package com.pistis.vdoc.database

import android.annotation.SuppressLint
import com.pistis.vdoc.entities.Doenca
import com.pistis.vdoc.entities.Medico
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.Throws
import android.content.ContentValues
import android.content.Context
import android.database.SQLException
import android.util.Log
import java.util.*

/**
 * Created by Wesley Brenno on 14/05/2016.
 */ // TODO: Auto-generated Javadoc
/**
 * The Class DataBaseStorage.
 */
class DataBaseStorage(
    /** The m context.  */
    private val mContext: Context?
) {
    /** The m db helper.  */
    private var mDbHelper: DatabaseHelper? = null

    /** The m db.  */
    private var mDb: SQLiteDatabase? = null

    /**
     * The Class DatabaseHelper.
     */
    class DatabaseHelper
    /**
     * Instantiates a new database helper.
     *
     * @param context
     * the context
     */
    internal constructor(context: Context?) :
        SQLiteOpenHelper(context, DB_NAME, null, DATABASE_VERSION) {
        /*
         * (non-Javadoc)
         *
         * @see
         * android.database.sqlite.SQLiteOpenHelper#onOpen(android.database.
         * sqlite.SQLiteDatabase)
         */
        override fun onOpen(db: SQLiteDatabase?) {
            super.onOpen(db)
            Log.v(DB_NAME, "onOpenDB")
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database
         * .sqlite.SQLiteDatabase)
         */
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(DOENCA_CREATE_TABLE)
            db.execSQL(MEDICO_CREATE_TABLE)
            Log.d("Create TABLE_DOENCA", DOENCA_CREATE_TABLE)
            Log.d("Create TABLE_MEDICO", MEDICO_CREATE_TABLE)
            Log.w("DataBaseStorage", "DB created sucefully!")
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database
         * .sqlite.SQLiteDatabase, int, int)
         */
        override fun onUpgrade(
            db: SQLiteDatabase, oldVersion: Int,
            newVersion: Int
        ) {
            Log.w(
                TAG, "Updating database from version " + oldVersion + " to "
                        + newVersion + ", all data will be lost!"
            )
            db.execSQL("DROP TABLE IF EXISTS $TABLE_MEDICO")
            db.execSQL("DROP TABLE IF EXISTS $TABLE_DOENCA")
            onCreate(db)
        }
    }

    /**
     * Open.
     *
     * @return the data base storage
     * @throws SQLException
     * the SQL exception
     */
    @Throws(SQLException::class)
    fun open(): DataBaseStorage {
        mDbHelper = DatabaseHelper(mContext)
        mDb = mDbHelper!!.writableDatabase
        return this
    }

    /**
     * Close.
     */
    fun close() {
        mDb?.close()
    }
    /*---------DOENCA DATABASE METHODS----------*/
    /**
     * Adds the doenca
     *
     * @param doenca
     * the doenca
     */
    fun addDoenca(doenca: Doenca) {
        val values = ContentValues()

        //  values.put(COLUMN_DOENCA_ID, doenca.getId());
        values.put(COLUMN_DOENCA_NAME, doenca.getName())
        values.put(COLUMN_DOENCA_DESCRIPTION, doenca.getDescription())
        values.put(COLUMN_DOENCA_SINTOMAS, doenca.getSintomas())
        values.put(COLUMN_DOENCA_CAUSAS, doenca.getCausas())
        values.put(COLUMN_DOENCA_PREVENCAO, doenca.getPrevencao())
        values.put(COLUMN_DOENCA_ESPECIALISTA, doenca.getEspecialista())
        mDb?.insert(TABLE_DOENCA, null, values)
    }

    /**
     * Edits the doenca.
     *
     * @param doenca
     * the doenca
     */
    fun editDoenca(doenca: Doenca) {
        val values = ContentValues()
        values.put(COLUMN_DOENCA_ID, doenca.getId())
        values.put(COLUMN_DOENCA_NAME, doenca.getName())
        values.put(COLUMN_DOENCA_DESCRIPTION, doenca.getDescription())
        values.put(COLUMN_DOENCA_SINTOMAS, doenca.getSintomas())
        values.put(COLUMN_DOENCA_CAUSAS, doenca.getCausas())
        values.put(COLUMN_DOENCA_PREVENCAO, doenca.getPrevencao())
        values.put(COLUMN_DOENCA_ESPECIALISTA, doenca.getEspecialista())
        mDb?.update(
            TABLE_DOENCA, values, COLUMN_DOENCA_ID + "="
                    + doenca.getId(), null
        )
    }

    /**
     * Gets the all weeks.
     *
     *
     * the order
     * @return the all DoencasActivity
     */
    @SuppressLint("Range")
    fun getAllDoencas(): ArrayList<Doenca?>? {
        val doencas = ArrayList<Doenca?>()
        val query = ("SELECT " + COLUMN_DOENCA_ID + ", "
                + COLUMN_DOENCA_NAME + ", "
                + COLUMN_DOENCA_DESCRIPTION + ", "
                + COLUMN_DOENCA_SINTOMAS + ", "
                + COLUMN_DOENCA_PREVENCAO + ", "
                + COLUMN_DOENCA_CAUSAS + ", "
                + COLUMN_DOENCA_ESPECIALISTA
                + " FROM " + TABLE_DOENCA
                + " ORDER BY DOENCA_NAME" + " ASC ")
        Log.d("Query", query)
        val mCursor = mDb?.rawQuery(query, null)
        mCursor?.moveToFirst() ?: return null
        while (!mCursor.isAfterLast) {
            val id = mCursor.getInt(
                mCursor.getColumnIndex(COLUMN_DOENCA_ID)
            ).toLong()
            val name = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_NAME)
            )
            val description = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_DESCRIPTION)
            )
            val sintomas = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_SINTOMAS)
            )
            val prevencao = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_PREVENCAO)
            )
            val causas = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_CAUSAS)
            )
            val especialista = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_ESPECIALISTA)
            )
            val doenca = Doenca(id, name, sintomas, description, causas, prevencao, especialista)
            doencas.add(doenca)
            mCursor.moveToNext()
        }
        return doencas
    }

    /**
     * Gets the discipline by name.
     *
     * @param sintomas
     * the name sintomas
     * @return the discipline by sintomas
     */
    @SuppressLint("Range")
    fun getDoencasBySintomas(
        sintomas: Array<String?>
    ): ArrayList<Doenca?>? {
        val doencas = ArrayList<Doenca?>()
        var where = " WHERE UPPER(" + COLUMN_DOENCA_SINTOMAS + ") LIKE "
        for (i in 0 until sintomas.size - 1) {
            where = where + "'%" + sintomas.get(i)
                ?.uppercase(Locale.getDefault()) + "%'" + "AND UPPER(" + COLUMN_DOENCA_SINTOMAS + ") LIKE "
        }
        where = where + "'%" + (sintomas.get(sintomas.size - 1)?.uppercase(Locale.getDefault())) + "%' "
        Log.d("Where", where)
        val query = ("SELECT " + COLUMN_DOENCA_ID + ", "
                + COLUMN_DOENCA_NAME + ", "
                + COLUMN_DOENCA_DESCRIPTION + ", "
                + COLUMN_DOENCA_SINTOMAS + ", "
                + COLUMN_DOENCA_PREVENCAO + ", "
                + COLUMN_DOENCA_CAUSAS + ", "
                + COLUMN_DOENCA_ESPECIALISTA
                + " FROM " + TABLE_DOENCA + where
                + " ORDER BY DOENCA_NAME" + " ASC ")
        Log.d("Query", query)
        val mCursor = mDb?.rawQuery(query, null)
        mCursor?.moveToFirst() ?: return null
        while (!mCursor.isAfterLast) {
            val id = mCursor.getInt(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_ID)
            ).toLong()
            val name = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_NAME)
            )
            val description = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_DESCRIPTION)
            )
            val sintomasN = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_SINTOMAS)
            )
            val prevencao = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_PREVENCAO)
            )
            val causas = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_CAUSAS)
            )
            val especialista = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_DOENCA_ESPECIALISTA)
            )
            val doenca = Doenca(id, name, sintomasN, description, causas, prevencao, especialista)
            doencas.add(doenca)
            mCursor.moveToNext()
        }
        return doencas
    }
    /*---------MEDICO DATABASE METHODS----------*/
    /**
     * Adds the medico.
     *
     * @param medico
     * the medico
     */
    fun addMedico(medico: Medico) {
        val values = ContentValues()

        //  values.put(COLUMN_MEDICO_ID, medico.getId());
        values.put(COLUMN_MEDICO_NAME, medico.getNome())
        values.put(COLUMN_MEDICO_ENDERECO, medico.getEndereco())
        values.put(COLUMN_MEDICO_HORARIOS, medico.getHorarios())
        values.put(COLUMN_MEDICO_TELEFONE, medico.getTelefone())
        values.put(COLUMN_MEDICO_ESPECIALIDADE, medico.getEspecialidade())
        values.put(COLUMN_MEDICO_MAPS, medico.getMaps())
        mDb?.insert(TABLE_MEDICO, null, values)
    }

    /**
     * Edits the medico.
     *
     * @param medico
     * the medico
     */
    fun editMedico(medico: Medico) {
        val values = ContentValues()
        values.put(COLUMN_MEDICO_ID, medico.getId())
        values.put(COLUMN_MEDICO_NAME, medico.getNome())
        values.put(COLUMN_MEDICO_ENDERECO, medico.getEndereco())
        values.put(COLUMN_MEDICO_HORARIOS, medico.getHorarios())
        values.put(COLUMN_MEDICO_TELEFONE, medico.getTelefone())
        values.put(COLUMN_MEDICO_ESPECIALIDADE, medico.getEspecialidade())
        values.put(COLUMN_MEDICO_MAPS, medico.getMaps())
        mDb?.update(
            TABLE_MEDICO, values,
            COLUMN_MEDICO_ID + "=" + medico.getId(), null
        )
    }

    @SuppressLint("Range")
    fun getAllMedicos(): ArrayList<Medico?>? {
        val medicos = ArrayList<Medico?>()
        val query = ("SELECT " + COLUMN_MEDICO_ID + ", "
                + COLUMN_MEDICO_NAME + ", " + COLUMN_MEDICO_ENDERECO + ", "
                + COLUMN_MEDICO_HORARIOS + ", "
                + COLUMN_MEDICO_TELEFONE + ", "
                + COLUMN_MEDICO_ESPECIALIDADE + ", " + COLUMN_MEDICO_MAPS
                + " FROM " + TABLE_MEDICO
                + " ORDER BY MEDICO_NAME" + " ASC ")
        Log.d("Query", query)
        val mCursor = mDb?.rawQuery(query, null)
        mCursor?.moveToFirst() ?: return null
        while (!mCursor.isAfterLast) {
            val id = mCursor
                .getLong(mCursor.getColumnIndex(COLUMN_MEDICO_ID))
            val nome = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_NAME)
            )
            val endereco = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_ENDERECO)
            )
            val horarios = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_HORARIOS)
            )
            val telefone = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_TELEFONE)
            )
            val especialidade = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_ESPECIALIDADE)
            )
            val maps = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_MAPS)
            )
            val medico = Medico(id, nome, especialidade, endereco, horarios, telefone, maps)
            medicos.add(medico)
            mCursor.moveToNext()
        }
        return medicos
    }

    @SuppressLint("Range")
    fun getMedicoByEspecialidade(especialidadeBuscada: String?): ArrayList<Medico?>? {
        val medicos = ArrayList<Medico?>()
        val query = ("SELECT " + COLUMN_MEDICO_ID + ", "
                + COLUMN_MEDICO_NAME + ", " + COLUMN_MEDICO_ENDERECO + ", "
                + COLUMN_MEDICO_HORARIOS + ", "
                + COLUMN_MEDICO_TELEFONE + ", "
                + COLUMN_MEDICO_ESPECIALIDADE + ", " + COLUMN_MEDICO_MAPS
                + " FROM " + TABLE_MEDICO + " WHERE '" + (especialidadeBuscada?.uppercase(Locale.getDefault())) + "' = UPPER(" + COLUMN_MEDICO_ESPECIALIDADE + ")"
                + " ORDER BY MEDICO_NAME" + " ASC ")
        Log.d("Query", query)
        val mCursor = mDb?.rawQuery(query, null)
        mCursor?.moveToFirst() ?: return null
        while (!mCursor.isAfterLast) {
            val id = mCursor
                .getLong(mCursor.getColumnIndex(COLUMN_MEDICO_ID))
            val nome = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_NAME)
            )
            val endereco = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_ENDERECO)
            )
            val horarios = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_HORARIOS)
            )
            val telefone = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_TELEFONE)
            )
            val especialidade = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_ESPECIALIDADE)
            )
            val maps = mCursor.getString(
                mCursor
                    .getColumnIndex(COLUMN_MEDICO_MAPS)
            )
            val medico = Medico(id, nome, especialidade, endereco, horarios, telefone, maps)
            medicos.add(medico)
            mCursor.moveToNext()
        }
        return medicos
    }

    companion object {
        /*------------DOENCA TABLE----------------------*/
        /** The Constant TABLE_DOENCA.  */
        val TABLE_DOENCA: String? = "DOENCA"

        /** The Constant COLUMN_DOENCA_ID.  */
        val COLUMN_DOENCA_ID: String? = "_id_DOENCA"

        /** The Constant COLUMN_DOENCA_NAME.  */
        val COLUMN_DOENCA_NAME: String? = "DOENCA_NAME"

        /** The Constant COLUMN_DOENCA_SINTOMAS.  */
        val COLUMN_DOENCA_SINTOMAS: String? = "DOENCA_SINTOMAS"

        /** The Constant COLUMN_DOENCA_DESCRIPTION.  */
        val COLUMN_DOENCA_DESCRIPTION: String? = "DOENCA_DESCRIPTION"

        /** The Constant COLUMN_DOENCA_CAUSAS.  */
        val COLUMN_DOENCA_CAUSAS: String? = "DOENCA_CAUSAS"

        /** The Constant COLUMN_DOENCA_PREVENCAO.  */
        val COLUMN_DOENCA_PREVENCAO: String? = "DOENCA_PREVENCAO"

        /** The Constant COLUMN_DOENCA_ESPECIALISTA.  */
        val COLUMN_DOENCA_ESPECIALISTA: String? = "DOENCA_MEDICO_ESPECIALISTA"
        /*------------MEDICO TABLE----------------------*/
        /** The Constant TABLE_MEDICO.  */
        val TABLE_MEDICO: String? = "MEDICO"

        /** The Constant COLUMN_MEDICO_ID.  */
        val COLUMN_MEDICO_ID: String? = "_id_MEDICO"

        /** The Constant COLUMN_MEDICO_NAME.  */
        val COLUMN_MEDICO_NAME: String? = "MEDICO_NAME"

        /** The Constant COLUMN_MEDICO_ESPECIALIDADE.  */
        val COLUMN_MEDICO_ESPECIALIDADE: String? = "MEDICO_ESPECIALIDADE"

        /** The Constant COLUMN_MEDICO_ENDERECO.  */
        val COLUMN_MEDICO_ENDERECO: String? = "MEDICO_ENDERECO"

        /** The Constant COLUMN_MEDICO_HORARIOS.  */
        val COLUMN_MEDICO_HORARIOS: String? = "MEDICO_HORARIOS"

        /** The Constant COLUMN_MEDICO_TELEFONE.  */
        val COLUMN_MEDICO_TELEFONE: String? = "MEDICO_TELEFONE"

        /** The Constant COLUMN_MEDICO_MAPS.  */
        val COLUMN_MEDICO_MAPS: String? = "COLUMN_MEDICO_MAPS"
        /*----------------SQL_CREATE_COMANDS--------------*/
        /** The Constant DOENCA_CREATE_TABLE.  */
        private val DOENCA_CREATE_TABLE: String = ("CREATE TABLE "
                + TABLE_DOENCA + "  (" + COLUMN_DOENCA_ID
                + " INTEGER NOT NULL PRIMARY KEY," + COLUMN_DOENCA_NAME
                + " STRING, " + COLUMN_DOENCA_DESCRIPTION + " STRING, "
                + COLUMN_DOENCA_SINTOMAS + " STRING, "
                + COLUMN_DOENCA_CAUSAS + " STRING, "
                + COLUMN_DOENCA_PREVENCAO + " STRING, "
                + COLUMN_DOENCA_ESPECIALISTA + " STRING);")

        /** The Constant MEDICO_CREATE_TABLE.  */
        private val MEDICO_CREATE_TABLE: String = ("CREATE TABLE "
                + TABLE_MEDICO + "  (" + COLUMN_MEDICO_ID
                + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_MEDICO_NAME + " STRING, "
                + COLUMN_MEDICO_ENDERECO + " STRING, "
                + COLUMN_MEDICO_HORARIOS + " STRING, "
                + COLUMN_MEDICO_TELEFONE + " STRING, "
                + COLUMN_MEDICO_ESPECIALIDADE + " STRING, "
                + COLUMN_MEDICO_MAPS + " STRING);")

        /** The Constant TAG.  */
        private val TAG: String = "DataBaseStorage"

        /** The Constant DB_NAME.  */
        private val DB_NAME: String = "DBP"

        /** The Constant DATABASE_VERSION.  */
        private const val DATABASE_VERSION = 1
    }

    /**
     * Instantiates a new data base storage.
     *
     * @param context
     * the context
     */
    init {
        open()
    }
}