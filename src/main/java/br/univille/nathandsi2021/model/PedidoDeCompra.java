package br.univille.nathandsi2021.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PedidoDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemPedido> itemPedido = new ArrayList<>();
    
    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }
    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }    
}
