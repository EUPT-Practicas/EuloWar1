package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TropaDefensa;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-14T19:55:35")
@StaticMetamodel(FabricaDefensiva.class)
public class FabricaDefensiva_ { 

    public static volatile SingularAttribute<FabricaDefensiva, Integer> nivelFabricaDefensiva;
    public static volatile SingularAttribute<FabricaDefensiva, Usuario> fKFabricaDefensivaUsuario;
    public static volatile CollectionAttribute<FabricaDefensiva, TropaDefensa> tropaDefensaCollection;
    public static volatile SingularAttribute<FabricaDefensiva, Integer> idFabricaDefensiva;

}