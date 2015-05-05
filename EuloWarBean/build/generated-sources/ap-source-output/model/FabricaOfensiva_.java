package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TropaAtaque;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-04T20:22:23")
@StaticMetamodel(FabricaOfensiva.class)
public class FabricaOfensiva_ { 

    public static volatile CollectionAttribute<FabricaOfensiva, TropaAtaque> tropaAtaqueCollection;
    public static volatile SingularAttribute<FabricaOfensiva, Integer> idFabricaOfensiva;
    public static volatile SingularAttribute<FabricaOfensiva, Integer> nivelFabricaOfensiva;
    public static volatile SingularAttribute<FabricaOfensiva, Usuario> fKFabricaOfensivaUsuario;

}