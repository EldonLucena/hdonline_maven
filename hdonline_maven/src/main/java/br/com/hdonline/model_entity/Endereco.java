package br.com.hdonline.model_entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table (name="endereco")
public class Endereco implements Serializable{
    
     private static final long SerialVersionUID = 1L;
    
    @Id  
    @GeneratedValue
    @Column(name="idEndereco", nullable = false)
    private Integer idEndereco;
    @Column(name="Bairro", length = 80)
    private String bairro;
    @Column(name="NomeLogradouro",length = 80)
    private String nomeLogradouro;
    @Column(name="CEP",length = 9)
    private String cep;
    @Column(name="Numero")
    private  Integer numero;
    @Column(name="Complemento")
    private  Integer complemento;
    
    @OneToOne(optional =true, fetch=FetchType.LAZY)
    @ForeignKey(name = "Endereco_pessoa")
    @JoinColumn(name="idPessoa", referencedColumnName = "idPessoa")
    private Pessoa pessoa;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoTipoLogradouro")
    @JoinColumn(name="idTipologradouro", referencedColumnName = "idTipologradouro")
    private TipoLogradouro tipoLogradouro;
     
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoEstado")
    @JoinColumn(name="idEstado", nullable = false)
    private Estado estado;
     
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoTipoEndereco")
    @JoinColumn(name="idTipoEndereco", referencedColumnName = "idTipoEndereco")
    private TipoLogradouro tipoendereco;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoCidade")
    @JoinColumn(name="idCidade", referencedColumnName = "idCidade")
    private Cidade cidade;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoTipoLogradouro")
    @JoinColumn(name="idTipologradouro", referencedColumnName = "idTipologradouro")
    private TipoLogradouro tipoEndereco;
   
     

    public Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();        
        this.tipoLogradouro = new TipoLogradouro();
        this.tipoendereco = new TipoLogradouro();
        this.pessoa = new Pessoa();
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getComplemento() {
        return complemento;
    }

    public void setComplemento(Integer complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoLogradouro getTipoendereco() {
        return tipoendereco;
    }

    public void setTipoendereco(TipoLogradouro tipoendereco) {
        this.tipoendereco = tipoendereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public TipoLogradouro getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoLogradouro tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.idEndereco);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.idEndereco, other.idEndereco)) {
            return false;
        }
        return true;
    }
     
     
}
