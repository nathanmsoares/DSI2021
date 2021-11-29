package br.univille.nathandsi2021.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrdemDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private PedidoDeCompra pedidoDeCompra;
    private double preco;
    private String aprovado;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public PedidoDeCompra getPedidoDeCompra() {
        return pedidoDeCompra;
    }
    public void setPedidoDeCompra(PedidoDeCompra pedidoDeCompra) {
        this.pedidoDeCompra = pedidoDeCompra;
    }
    
    public double getPreco() {
        return pedidoDeCompra.getTotalPreco();
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getAprovado() {
        return aprovado;
    }
    public void setAprovado(String aprovado) {
        this.aprovado = aprovado;
    }   

    
}
