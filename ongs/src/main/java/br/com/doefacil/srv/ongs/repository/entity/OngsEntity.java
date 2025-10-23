package br.com.doefacil.srv.ongs.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ongs")
public class OngsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "")
    private String nome;
    @Column(name = "")
    private String cnpj;
    @Column(name = "")
    private String email;
    @Column(name = "")
    private String telefone;
    @Column(name = "area_atuacao")
    private String area_atuacao;
    @Column(name = "senha")
    private String senha;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

    public OngsEntity(String nome, String cnpj, String email, String telefone, String area_atuacao, String senha ,EnderecoEntity endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.area_atuacao = area_atuacao;
        this.senha = senha;
        this.endereco = endereco;
    }

    @Deprecated
    public OngsEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getcnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getAreaAtuacao() {
        return area_atuacao;
    }

    public String getSenha() {
        return senha;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.area_atuacao = areaAtuacao;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
