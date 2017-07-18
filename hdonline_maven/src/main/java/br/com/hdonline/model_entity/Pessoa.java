package br.com.hdonline.model_entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table (name="pessoa")
public class Pessoa implements Serializable{

    private static final long SerialVersionUID = 1L;
    
    @Id  
    @GeneratedValue
    @Column(name="idPessoa", nullable = false)
    private Integer idPessoa;
    @Column(name="Name",nullable = false, length = 80)
    private String nome;
    @Column(name="Email",nullable = false, length = 80)
    private String email;
    @Column(name="Telefone",nullable = false, length = 16)//(063)99219-1128
    private String telefone;
    @Column(name="CPF",nullable = false, length = 14)
    private String cpf;
    @Column(name="DataDeNasc",nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNasc;
    @Column(name="DataCad",nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCad;   

    @OneToOne(mappedBy = "pessoa", fetch=FetchType.LAZY)
    @ForeignKey(name = "Endereco_pessoa")
    private Endereco endereco;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "PessoaSexo")
    @JoinColumn(name="idSexo", referencedColumnName = "idSexo")
    private Sexo sexo;
    
    
    public Pessoa() {
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNasc() {
        return dataDeNasc;
    }

    public void setDataDeNasc(Date dataDeNasc) {
        this.dataDeNasc = dataDeNasc;
    }

    public Date getDataDeCad() {
        return dataDeCad;
    }

    public void setDataDeCad(Date dataDeCad) {
        this.dataDeCad = dataDeCad;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idPessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.idPessoa, other.idPessoa)) {
            return false;
        }
        return true;
    }
    
    
    
}
