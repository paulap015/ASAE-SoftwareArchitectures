package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(nullable = false, length = 45)
	private String username;
	@Column(unique=true, name="nombre", nullable = false, length = 45)
	private String nombreUsuario;
	@Column( unique=true, nullable = false, length = 100)
	private String email;
	private String password;
	private Integer estatus;
	@Column( nullable = true)	
	private Date fechaRegistro;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="objUsuario")
	private List<Solicitud> solicitudes;
		
	
	@OneToOne(cascade={CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy = "objUsuario")
	private Direccion objDireccion;


	public Usuario()
	{		
		this.solicitudes=new ArrayList<Solicitud>();
	}

	public void agregarSolicitud(Solicitud objSolicitud)
	{
		this.solicitudes.add(objSolicitud);
	}

	public List<Solicitud> getSolicitudes()
	{
		return this.solicitudes;
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
		return nombreUsuario;
	}
	public void setNombre(String nombre) {
		this.nombreUsuario = nombre;
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
	public List<Perfil> getListaPerfiles() {
		return listaPerfiles;
	}
	public void setListaPerfiles(List<Perfil> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}*/
	
	
}
