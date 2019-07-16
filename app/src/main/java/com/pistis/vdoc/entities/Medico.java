package com.pistis.vdoc.entities;

import java.io.Serializable;

/**
 * Created by Wesley Brenno on 14/05/2016.
 */
public class Medico implements Serializable {

    private long id;
    private String nome;
    private String especialidade;
    private String endereco;
    private String horarios;
    private String telefone;
    private String maps;

    public Medico(long id, String nome, String especialidade, String endereco, String horarios, String telefone, String maps) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.horarios = horarios;
        this.telefone = telefone;
        this.maps = maps;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getHorarios(){
        return horarios;
    }

    public void setHorarios(String horarios){
        this.horarios = horarios;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }

    public String getInformacoes(){
        return this.getEspecialidade() + ", " + this.getHorarios();
    }
}
