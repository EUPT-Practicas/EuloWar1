package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Recurso;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-04T20:22:23")
@StaticMetamodel(Mina.class)
public class Mina_ { 

    public static volatile SingularAttribute<Mina, String> tipoMina;
    public static volatile SingularAttribute<Mina, Integer> nivelMina;
    public static volatile SingularAttribute<Mina, Usuario> fKMinaUsuario;
    public static volatile SingularAttribute<Mina, Integer> idMina;
    public static volatile SingularAttribute<Mina, Recurso> fKMinaRecurso;

}