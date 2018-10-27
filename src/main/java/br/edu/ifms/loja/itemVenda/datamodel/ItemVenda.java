package br.edu.ifms.loja.itemVenda.datamodel;

import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.usuario.datamodel.Usuario;
import br.edu.ifms.loja.venda.datamodel.Venda;

import com.towel.el.annotation.Resolvable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "ID")
    private Long idItemVenda;

    @Resolvable(colName = "Valor")
    private Double valorVenda;

    @Resolvable(colName = "Quantidade")
    private Integer qtdeVenda;

    @ManyToOne
    private Produto produto;
    
    @ManyToOne
    private Venda venda;
}
