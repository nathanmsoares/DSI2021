package br.univille.nathandsi2021.model;


import javax.persistence.Entity;

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

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getDepedentes() {
        return depedentes;
    }

    public void setDepedentes(String depedentes) {
        this.depedentes = depedentes;
    }

    private String endereco;

    private String data_nascimento;
    
    private String depedentes;

}
