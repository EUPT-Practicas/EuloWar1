package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Mina;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-07T17:27:20")
@StaticMetamodel(Recurso.class)
public class Recurso_ { 

    public static volatile SingularAttribute<Recurso, String> tipoRecurso;
    public static volatile SingularAttribute<Recurso, Integer> idRecurso;
    public static volatile SingularAttribute<Recurso, Usuario> fKUsuario;
    public static volatile SingularAttribute<Recurso, Integer> unidades;
    public static volatile CollectionAttribute<Recurso, Mina> minaCollection;

}