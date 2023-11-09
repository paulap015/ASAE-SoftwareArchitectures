package co.edu.unicauca.asae.ejemplo_relaciones_jpa;

import java.util.Date;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Direccion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Perfil;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Solicitud;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Usuario;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.DireccionesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.SolicitudesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.UsuariosRepository;

@SpringBootApplication
@Transactional
public class EjemploRelacionesJpaApplication implements CommandLineRunner{

	@Autowired
	private DireccionesRepository servicioBDDirecciones;
	
	@Autowired
	private UsuariosRepository servicioBDUsuarios;

	@Autowired
	private SolicitudesRepository servicioDBSolicitudes;

	public static void main(String[] args) {
		SpringApplication.run(EjemploRelacionesJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		consultarDirecciones();
		
	}

	private void consultarDirecciones()
	{
		Iterable<Direccion> listaDirecciones= this.servicioBDDirecciones.findAll();
		for (Direccion direccion : listaDirecciones) {
			System.out.println("Calle: " +  direccion.getCalle());
			System.out.println("Ciudad: " +  direccion.getCiudad());
			System.out.println("Pais: " +  direccion.getPais());
			System.out.println("usuario asociado: " + direccion.getObjUsuario().getNombre());
			System.out.println(" ---- ---- -----");
		}
	}

	/*private void consultarUsuarios() {
		Iterable<Usuario> listaUsuarios= this.servicioBDUsuarios.findAll();
		
		for (Usuario usuario : listaUsuarios) {
			System.out.println("Usuario");
			System.out.println("Nombres: " + usuario.getNombre());
			System.out.println("Dirección");
			System.out.println("Calle: " +  usuario.getObjDireccion().getCalle());
			System.out.println("Ciudad: " +  usuario.getObjDireccion().getCiudad());
			System.out.println("Pais: " +  usuario.getObjDireccion().getPais());			
			System.out.println(" ---- ---- ----");
		}
		
	}*/

	private void eliminarUsuario()
	{
		Optional<Usuario> optional = this.servicioBDUsuarios.findById(13);
		Usuario user=optional.get();
		this.servicioBDUsuarios.delete(user);
	}
	
	private void almacenarUsuario()
	{
		Usuario user = new Usuario();
		user.setNombre("Andrea Sanchez");
		user.setEmail("Andrea@unicauca.edu.co");
		user.setFechaRegistro(new Date());
		user.setUsername("Andrea");
		user.setPassword("12345");
		user.setEstatus(1);
		
		
		Direccion objDireccion= new Direccion();
		objDireccion.setCalle("calle 8 no 23 A 34");
		objDireccion.setCiudad("palmira");
		objDireccion.setPais("Colombia");

		user.setObjDireccion(objDireccion);
		objDireccion.setObjUsuario(user);
		
		this.servicioBDUsuarios.save(user);
		
		
	}

	private void consultarUsuariosSolicitudes()
	{
		Iterable<Usuario> listaUsuarios= this.servicioBDUsuarios.findAll();
		
		for (Usuario usuario : listaUsuarios) {
			System.out.println("Usuario");
			System.out.println("Nombres: " + usuario.getNombre());
			System.out.println("Solicitudes");
			Iterable<Solicitud> listaSolicitudes=usuario.getSolicitudes();
			for (Solicitud solicitud : listaSolicitudes) {
				System.out.println("id de la solicitud: " + solicitud.getId());
				System.out.println("Fecha de la solicitud: " + solicitud.getFecha());
				System.out.println("Ruta a la hoja de vida: " + solicitud.getArchivo());
				System.out.println("Comentarios: " + solicitud.getComentarios());
			}
			
			System.out.println(" ---- ---- ----");
		}
	}

	private void almacenarSolicitudes()
	{
		Usuario objUsuario= new Usuario();		
		objUsuario.setNombre("Tatiana Acosta");
		objUsuario.setEmail("tatiana@unicauca.edu.co");
		objUsuario.setFechaRegistro(new Date());
		objUsuario.setUsername("Tatiana");
		objUsuario.setPassword("123456");
		objUsuario.setEstatus(2);

		this.servicioBDUsuarios.save(objUsuario);

		Solicitud objSolicitud1= new Solicitud();
		objSolicitud1.setObjUsuario(objUsuario);
		objSolicitud1.setFecha(new Date());
		objSolicitud1.setArchivo("Ruta al archivo de la solicitud 1");
		objSolicitud1.setComentarios("Comentarios de la solicitud 1");
		this.servicioDBSolicitudes.save(objSolicitud1);

		Solicitud objSolicitud2= new Solicitud();
		objSolicitud2.setObjUsuario(objUsuario);
		objSolicitud2.setFecha(new Date());
		objSolicitud2.setArchivo("Ruta al archivo de la solicitud 2");
		objSolicitud2.setComentarios("Comentarios de la solicitud 2");
		this.servicioDBSolicitudes.save(objSolicitud2);

		Solicitud objSolicitud3= new Solicitud();
		objSolicitud3.setObjUsuario(objUsuario);
		objSolicitud3.setFecha(new Date());
		objSolicitud3.setArchivo("Ruta al archivo de la solicitud 3");
		objSolicitud3.setComentarios("Comentarios de la solicitud 3");
		this.servicioDBSolicitudes.save(objSolicitud3);
	}

	
	

}
