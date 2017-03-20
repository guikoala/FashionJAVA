package dl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Publicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Publicacion.findAll", query="SELECT p FROM Publicacion p")
public class Publicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPublicacion;

	private String descripcion;

	@Lob
	private byte[] multimedia;

	private int nVisualizaciones;

	private String titulo;

	//bi-directional many-to-one association to Etiqueta
	@OneToMany(mappedBy="publicacion")
	private List<Etiqueta> etiquetas;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuarioPublica")
	private Usuario usuario;

	public Publicacion() {
	}

	public int getIdPublicacion() {
		return this.idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getMultimedia() {
		return this.multimedia;
	}

	public void setMultimedia(byte[] multimedia) {
		this.multimedia = multimedia;
	}

	public int getNVisualizaciones() {
		return this.nVisualizaciones;
	}

	public void setNVisualizaciones(int nVisualizaciones) {
		this.nVisualizaciones = nVisualizaciones;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Etiqueta> getEtiquetas() {
		return this.etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Etiqueta addEtiqueta(Etiqueta etiqueta) {
		getEtiquetas().add(etiqueta);
		etiqueta.setPublicacion(this);

		return etiqueta;
	}

	public Etiqueta removeEtiqueta(Etiqueta etiqueta) {
		getEtiquetas().remove(etiqueta);
		etiqueta.setPublicacion(null);

		return etiqueta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}