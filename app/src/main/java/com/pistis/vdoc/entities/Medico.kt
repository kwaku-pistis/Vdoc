package com.pistis.vdoc.entities

import java.io.Serializable

/**
 * Created by Wesley Brenno on 14/05/2016.
 */
class Medico(
    private var id: Long,
    private var nome: String?,
    private var especialidade: String?,
    private var endereco: String?,
    private var horarios: String?,
    private var telefone: String?,
    private var maps: String?
) : Serializable {
    fun getNome(): String? {
        return nome
    }

    fun setNome(nome: String?) {
        this.nome = nome
    }

    fun getId(): Long {
        return id
    }

    fun setId(id: Long) {
        this.id = id
    }

    fun getEspecialidade(): String? {
        return especialidade
    }

    fun setEspecialidade(especialidade: String?) {
        this.especialidade = especialidade
    }

    fun getHorarios(): String? {
        return horarios
    }

    fun setHorarios(horarios: String?) {
        this.horarios = horarios
    }

    fun getEndereco(): String? {
        return endereco
    }

    fun setEndereco(endereco: String?) {
        this.endereco = endereco
    }

    fun getTelefone(): String? {
        return telefone
    }

    fun setTelefone(telefone: String?) {
        this.telefone = telefone
    }

    fun getMaps(): String? {
        return maps
    }

    fun setMaps(maps: String?) {
        this.maps = maps
    }

    fun getInformacoes(): String? {
        return getEspecialidade() + ", " + getHorarios()
    }
}