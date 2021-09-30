package br.univille.nathandsi2021.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class PedidoDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="pedido_de_compra_id")
    private List<ItemPedido> listaItemPedido = new ArrayList<>();
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Funcionario funcionario;
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date data;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public List<ItemPedido> getListaItemPedido() {
        return listaItemPedido;
    }
    public void setListaItemPedido(List<ItemPedido> listaItemPedido) {
        this.listaItemPedido = listaItemPedido;
    }
    
}
