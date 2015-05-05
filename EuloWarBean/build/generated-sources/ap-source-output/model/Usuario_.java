package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Campamento;
import model.FabricaDefensiva;
import model.FabricaOfensiva;
import model.Mina;
import model.Recurso;
import model.TropaAtaque;
import model.TropaDefensa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-04T20:22:23")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile CollectionAttribute<Usuario, Campamento> campamentoCollection;
    public static volatile CollectionAttribute<Usuario, FabricaDefensiva> fabricaDefensivaCollection;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile CollectionAttribute<Usuario, Recurso> recursoCollection;
    public static volatile CollectionAttribute<Usuario, TropaDefensa> tropaDefensaCollection;
    public static volatile SingularAttribute<Usuario, Date> fechaRegistro;
    public static volatile CollectionAttribute<Usuario, TropaAtaque> tropaAtaqueCollection;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile CollectionAttribute<Usuario, Mina> minaCollection;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;
    public static volatile CollectionAttribute<Usuario, FabricaOfensiva> fabricaOfensivaCollection;

}