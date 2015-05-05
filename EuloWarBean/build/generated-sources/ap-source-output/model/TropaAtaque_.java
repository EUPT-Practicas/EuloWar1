package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Campamento;
import model.FabricaOfensiva;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-04T20:22:23")
@StaticMetamodel(TropaAtaque.class)
public class TropaAtaque_ { 

    public static volatile SingularAttribute<TropaAtaque, Integer> idTropaAtaque;
    public static volatile SingularAttribute<TropaAtaque, FabricaOfensiva> fKTropaAtaqueFabricaOfensiva;
    public static volatile SingularAttribute<TropaAtaque, Integer> nivelTropaAtaque;
    public static volatile SingularAttribute<TropaAtaque, Campamento> fKTropaAtaqueCampamento;
    public static volatile SingularAttribute<TropaAtaque, String> tipoTropaAtaque;
    public static volatile SingularAttribute<TropaAtaque, Usuario> fKTropaAtaqueUsuario;

}