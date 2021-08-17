package br.univille.nathandsi2021.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float peso;
    private String dimensao;
    private float preco;
    @ManyToOne(cascade = CascadeType.ALL)
    private Produto produto;

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    
}