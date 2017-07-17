package br.com.hdonline.model_entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table (name="tipologradouro")
public class TipoLogradouro implements Serializable{
    
    private static final long SerialVersionUID = 1L;
    
    @Id  
    @GeneratedValue
    @Column(name="idTipologradouro", nullable = false)
    private Integer idTipologradouro;
    @Column(name="DescTipoLogradouro",length = 40, nullable = false)
    private String DescTipoLogradouro;

    @OneToMany(mappedBy = "tipologradouro", fetch = FetchType.LAZY)
    @ForeignKey(name = "Endereco_logradouro")
    private List<Endereco> enderecos;

    public TipoLogradouro() {
    }

    public Integer getIdTipologradouro() {
        return idTipologradouro;
    }

    public void setIdTipologradouro(Integer idTipologradouro) {
        this.idTipologradouro = idTipologradouro;
    }

    public String getDescTipoLogradouro() {
        return DescTipoLogradouro;
    }

    public void setDescTipoLogradouro(String DescTipoLogradouro) {
        this.DescTipoLogradouro = DescTipoLogradouro;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idTipologradouro);
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
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (!Objects.equals(this.idTipologradouro, other.idTipologradouro)) {
            return false;
        }
        return true;
    }

    
    
} 

    
