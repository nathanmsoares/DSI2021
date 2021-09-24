package br.univille.nathandsi2021.model;

import java.util.Date;

import javax.persistence.Entity;
// import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario extends Usuario {
    private String nome;
    private String cpf;
    private String telefone;
    // public long getId() {
    //     return id;
    // }

    // public void setId(long id) {
    //     this.id = id;
    // }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getDepedentes() {
        return depedentes;
    }

    public void setDepedentes(String depedentes) {
        this.depedentes = depedentes;
    }

    private String endereco;

    @Temporal(value = TemporalType.DATE)
    private Date data_nascimento;
    
    private String depedentes;

}
