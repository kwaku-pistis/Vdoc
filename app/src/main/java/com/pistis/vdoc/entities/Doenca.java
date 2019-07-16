package com.pistis.vdoc.entities;

import java.io.Serializable;

/**
 * Created by Wesley Brenno on 14/05/2016.
 */
public class Doenca implements Serializable{

    private long id;
    private String name;
    private String sintomas;
    private String description;
    private String causas;
    private String prevencao;
    private String especialista;

    public Doenca(long id, String name, String sintomas, String description, String causas, String prevencao, String especialista) {
        this.id = id;
        this.name = name;
        this.sintomas = sintomas;
        this.description = description;
        this.causas = causas;
        this.prevencao = prevencao;
        this.especialista = especialista;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getCausas() {
        return causas;
    }

    public void setCausas(String causas) {
        this.causas = causas;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrevencao() {
        return prevencao;
    }

    public void setPrevencao(String prevencao) {
        this.prevencao = prevencao;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }
}
