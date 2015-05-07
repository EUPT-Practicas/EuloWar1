package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TropaAtaque;
import model.TropaDefensa;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-07T17:27:20")
@StaticMetamodel(Campamento.class)
public class Campamento_ { 

    public static volatile SingularAttribute<Campamento, Integer> idCampamento;
    public static volatile SingularAttribute<Campamento, Integer> tropasLibres;
    public static volatile CollectionAttribute<Campamento, TropaDefensa> tropaDefensaCollection;
    public static volatile SingularAttribute<Campamento, Usuario> fKCampamentoUsuario;
    public static volatile CollectionAttribute<Campamento, TropaAtaque> tropaAtaqueCollection;
    public static volatile SingularAttribute<Campamento, Integer> tropasAlmacenadas;

}