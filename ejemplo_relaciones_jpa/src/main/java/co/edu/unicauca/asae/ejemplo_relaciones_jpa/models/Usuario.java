package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String nombre;
	private String email;
	private String password;
	private Integer estatus;
	private Date fechaRegistro;

	@OneToOne(mappedBy = "objUsuario")
	private Direccion objDireccion;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "objUsuario")
	private List<Solicitud> solicitudes;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarioPerfil", joinColumns = @JoinColumn(name = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "idPerfil"))
	private List<Perfil> listaPerfiles;

	public Usuario() {
		this.solicitudes = new ArrayList<Solicitud>();
		this.listaPerfiles = new ArrayList<Perfil>();
	}

	public void agregarSolicitud(Solicitud objSolicitud) {
		this.solicitudes.add(objSolicitud);
	}

	public List<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void agregarPerfil(Perfil objPerfil) {
		this.listaPerfiles.add(objPerfil);
	}

	public List<Perfil> getListaPerfiles() {
		return this.listaPerfiles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Direccion getObjDireccion() {
		return objDireccion;
	}

	public void setObjDireccion(Direccion objDireccion) {
		this.objDireccion = objDireccion;
	}

	/*
	 * public List<Perfil> getListaPerfiles() {
	 * return listaPerfiles;
	 * }
	 * public void setListaPerfiles(List<Perfil> listaPerfiles) {
	 * this.listaPerfiles = listaPerfiles;
	 * }
	 */

}
