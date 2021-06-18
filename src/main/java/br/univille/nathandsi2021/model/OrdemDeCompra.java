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
    private PedidoDeCompra pedido_de_compra;
    private float preco;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public PedidoDeCompra getPedido_de_compra() {
        return pedido_de_compra;
    }
    public void setPedido_de_compra(PedidoDeCompra pedido_de_compra) {
        this.pedido_de_compra = pedido_de_compra;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    
}
