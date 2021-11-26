package com.pistis.vdoc.entities

import java.io.Serializable

/**
 * Created by Wesley Brenno on 14/05/2016.
 */
class Doenca(
    private var id: Long,
    private var name: String?,
    private var sintomas: String?,
    private var description: String?,
    private var causas: String?,
    private var prevencao: String?,
    private var especialista: String?
) : Serializable {
    fun getId(): Long {
        return id
    }

    fun setId(id: Long) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getSintomas(): String? {
        return sintomas
    }

    fun setSintomas(sintomas: String?) {
        this.sintomas = sintomas
    }

    fun getCausas(): String? {
        return causas
    }

    fun setCausas(causas: String?) {
        this.causas = causas
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getPrevencao(): String? {
        return prevencao
    }

    fun setPrevencao(prevencao: String?) {
        this.prevencao = prevencao
    }

    fun getEspecialista(): String? {
        return especialista
    }

    fun setEspecialista(especialista: String?) {
        this.especialista = especialista
    }
}