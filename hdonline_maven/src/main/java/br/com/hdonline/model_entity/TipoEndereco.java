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
@Table (name="tipoendereco")
public class TipoEndereco implements Serializable{
    
    private static final long SerialVersionUID = 1L;
    
    @Id  
    @GeneratedValue
    @Column(name="idTipoEnd", nullable = false)
    private Integer idTipoEnd;
    @Column(name="DescricaoTipoEnd",length = 80, nullable = false)
    private String descricaoTipoEnd;

    @OneToMany(mappedBy = "tipoendereco", fetch = FetchType.LAZY)
    @ForeignKey(name = "Endereco_Tipo")
    private List<Endereco> enderecos;

    public TipoEndereco() {
    }

    public Integer getIdTipoEnd() {
        return idTipoEnd;
    }

    public void setIdTipoEnd(Integer idTipoEnd) {
        this.idTipoEnd = idTipoEnd;
    }

    public String getDescricaoTipoEnd() {
        return descricaoTipoEnd;
    }

    public void setDescricaoTipoEnd(String descricaoTipoEnd) {
        this.descricaoTipoEnd = descricaoTipoEnd;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
   
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.idTipoEnd);
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (!Objects.equals(this.idTipoEnd, other.idTipoEnd)) {
            return false;
        }
        return true;
    }
}
    

    
