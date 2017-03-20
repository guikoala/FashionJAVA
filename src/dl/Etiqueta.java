package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Etiqueta database table.
 * 
 */
@Entity
@NamedQuery(name="Etiqueta.findAll", query="SELECT e FROM Etiqueta e")
public class Etiqueta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEtiqueta;

	private String color;

	private String descripcion;

	private String estilo;

	private String genero;

	private String marca;

	private String material;

	private String tipo;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="Publicacion_idPublicacion")
	private Publicacion publicacion;

	public Etiqueta() {
	}

	public int getIdEtiqueta() {
		return this.idEtiqueta;
	}

	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstilo() {
		return this.estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

}