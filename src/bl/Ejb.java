package bl;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.*;


@LocalBean
@PermitAll
@Singleton
public class Ejb {
	
	@PersistenceContext
	EntityManager em;
	
	
	public boolean addPublicacion(Publicacion publicacion)
	{
		boolean added=false;
		if(publicacion.getDescripcion()!=null || publicacion.getMultimedia()!=null)
		{
			em.persist(publicacion);
			added=true;
		}
		return added;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Publicacion> getListaPublicaciones()
	{
		List<Publicacion> listaPublicaciones=(List<Publicacion>)em.createNamedQuery("publicacion.findAll").getResultList();
		return listaPublicaciones;
	}
	
	public void addEtiqueta(Etiqueta etiqueta)
	{
		em.persist(etiqueta);
	}

}
