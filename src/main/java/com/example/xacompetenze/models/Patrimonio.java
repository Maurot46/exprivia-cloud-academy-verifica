package com.example.xacompetenze.models;

import jakarta.persistence.*;

@Entity
@Table(name = "patrimonio")
public class Patrimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long value;
    private Integer annoCreazione;

    protected Patrimonio() {

    }

    public Patrimonio(String name, Long value, Integer annoCreazione) {
        this.name = name;
        this.value = value;
        this.annoCreazione = annoCreazione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Integer getAnnoCreazione() {
        return annoCreazione;
    }

    public void setAnnoCreazione(Integer annoCreazione) {
        this.annoCreazione = annoCreazione;
    }

    @Override
    public String toString() {
        return "Nome "+ this.name + " valore di: " + this.value + " creato il " + this.annoCreazione;
    }
}
