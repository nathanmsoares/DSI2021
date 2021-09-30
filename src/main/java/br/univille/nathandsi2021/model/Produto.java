package br.univille.nathandsi2021.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idd;
    private String nome;
    private float peso;
    private String dimensao;

    public long getIdd() {
        return idd;
    }
    public void setIdd(long idd) {
        this.idd = idd;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public String getDimensao() {
        return dimensao;
    }
    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }
    @Override
    public String toString() {
        return "Produto [dimensao=" + dimensao + ", id=" + idd + ", nome=" + nome + ", peso=" + peso + "]";
    }

    
}