package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Campamento;
import model.FabricaDefensiva;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-14T19:55:35")
@StaticMetamodel(TropaDefensa.class)
public class TropaDefensa_ { 

    public static volatile SingularAttribute<TropaDefensa, Campamento> fKTropaDefensaCampamento;
    public static volatile SingularAttribute<TropaDefensa, String> tipoTropaDefensa;
    public static volatile SingularAttribute<TropaDefensa, Usuario> fKTropaDefensaUsuario;
    public static volatile SingularAttribute<TropaDefensa, FabricaDefensiva> fKTropaDefensaFabricaDefensiva;
    public static volatile SingularAttribute<TropaDefensa, Integer> idTropaDefensa;
    public static volatile SingularAttribute<TropaDefensa, Integer> nivelTropaDefensa;

}