package co.edu.unicauca.asae.ejemplo_relaciones_jpa;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Empleado;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Estudiante;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Lapiz;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Libro;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Perro;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Persona;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Producto;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.EmpleadosRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.EstudiantesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.LibrosRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.PerrosRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.PersonasRepositoy;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.ProductosRepository;

@SpringBootApplication
@Transactional
public class EjemploRelacionesJpaApplication implements CommandLineRunner {

	@Autowired
	private EmpleadosRepository servicioBDEmpleados;

	@Autowired
	private ProductosRepository servicioBDProductos;

	@Autowired
	private PerrosRepository servicioBDPerros;

	@Autowired
	private LibrosRepository servicioBDLibros;

	@Autowired
	private EstudiantesRepository servicioBDEstudiantes;

	@Autowired
	private PersonasRepositoy servicioBDPersonas;

	public static void main(String[] args) {
		SpringApplication.run(EjemploRelacionesJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* single table */
		/*almacenarLapiz();
		almacenarLibro();
		consultarProductos();
		consultarLibros();*/

		// joined
		/*almacenarPerros();
		consultarPerros();*/

		// table per class

		almacenarEmpleados();
		almacenarEstudiantes();
		consultarPersonas();

	}

	private void almacenarEmpleados() {
		Empleado objEmpleado1 = new Empleado("Andres", "Perez", "Exito");
		Empleado objEmpleado2 = new Empleado("Juan", "Lopez", "Jumbo");
		List<Empleado> listaEmpleados = new LinkedList();
		listaEmpleados.add(objEmpleado1);
		listaEmpleados.add(objEmpleado2);
		this.servicioBDEmpleados.saveAll(listaEmpleados);
	}

	private void almacenarEstudiantes() {
		Estudiante objEstudiane1 = new Estudiante("Catalina", "Delgado", (float) 5.0);
		Estudiante objEstudiane2 = new Estudiante("Hector", "Sanchez", (float) 4.8);
		List<Estudiante> listaEstudiantes = new LinkedList();
		listaEstudiantes.add(objEstudiane1);
		listaEstudiantes.add(objEstudiane2);
		this.servicioBDEstudiantes.saveAll(listaEstudiantes);
	}

	private void consultarEmpleados() {
		Iterable<Empleado> listaEmpleados = this.servicioBDEmpleados.findAll();
		for (Empleado objEmpleado : listaEmpleados) {
			System.out.println("Id: " + objEmpleado.getId());
			System.out.println("Nombres: " + objEmpleado.getNombres());
			System.out.println("Apellidos: " + objEmpleado.getApellidos());
			System.out.println("Empresa donde trabaja: " + objEmpleado.getEmpresa());
			System.out.println(" ---- ---- -----");
		}
	}

	private void consultarEstudiantes() {
		Iterable<Estudiante> listaEstudiantes = this.servicioBDEstudiantes.findAll();
		for (Estudiante objEstudiante : listaEstudiantes) {
			System.out.println("Id: " + objEstudiante.getId());
			System.out.println("Nombres: " + objEstudiante.getNombres());
			System.out.println("Apellidos: " + objEstudiante.getApellidos());
			System.out.println("Promedio: " + objEstudiante.getPromedio());
			System.out.println(" ---- ---- -----");
		}
	}

	private void consultarPersonas() {
		Iterable<Persona> listaPersonas = this.servicioBDPersonas.findAll();
		for (Persona objPersona : listaPersonas) {

			System.out.println("Id: " + objPersona.getId());
			System.out.println("Nombres: " + objPersona.getNombres());
			System.out.println("Apellidos: " + objPersona.getApellidos());

			if (objPersona instanceof Empleado)
				System.out.println("Empresa donde trabaja: " + ((Empleado) objPersona).getEmpresa());
			else
				System.out.println("Promedio: " + ((Estudiante) objPersona).getPromedio());

			System.out.println(" ---- ---- -----");
		}
	}

	private void almacenarLibro() {
		Libro objLibro = new Libro(1, "Cien años de soledad", "Gabriel Garcia Marquez");

		this.servicioBDProductos.save(objLibro);
	}

	private void almacenarLapiz() {
		Lapiz objLapiz = new Lapiz(2, "Lapiz B1", "Negro");

		this.servicioBDProductos.save(objLapiz);
	}

	private void consultarProductos() {
		Iterable<Producto> listaProductos = this.servicioBDProductos.findAll();
		for (Producto objProducto : listaProductos) {
			System.out.println("Id producto: " + objProducto.getIdProducto());
			System.out.println("Nombre: " + objProducto.getNombre());
			if (objProducto instanceof Libro) {
				System.out.println("El producto es un libro");
				System.out.println("Autor: " + ((Libro) objProducto).getAutor());

			} else {
				System.out.println("El producto es un lapiz");
				System.out.println("Color: " + ((Lapiz) objProducto).getColor());
			}
		}
	}

	private void consultarLibros() {
		Iterable<Libro> listaLibros = this.servicioBDLibros.findAll();
		for (Libro libro : listaLibros) {
			System.out.println("Id producto: " + libro.getIdProducto());
			System.out.println("Nombre: " + libro.getNombre());
			System.out.println("Autor: " + libro.getAutor());
		}
	}

	private void almacenarPerros() {
		Perro objPerro1 = new Perro(1, "mamifero", "Pluto");
		this.servicioBDPerros.save(objPerro1);

		Perro objPerro2 = new Perro(2, "mamifero", "Mateo");
		this.servicioBDPerros.save(objPerro2);
	}

	private void consultarPerros() {
		Iterable<Perro> listaPerros = this.servicioBDPerros.findAll();
		for (Perro perro : listaPerros) {
			System.out.println("Id animal: " + perro.getIdAnimal());
			System.out.println("Especie: " + perro.getEspecie());
			System.out.println("Nombre: " + perro.getNombre());
		}
	}

}
