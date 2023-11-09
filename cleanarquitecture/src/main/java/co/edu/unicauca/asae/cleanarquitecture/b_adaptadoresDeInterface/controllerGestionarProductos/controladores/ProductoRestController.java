package co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.controllerGestionarProductos.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.controllerGestionarProductos.DTOPeticion.ProductoDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.controllerGestionarProductos.DTORespuesta.ProductoDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.c_reglasDeNegocioAplicacion.casosDeUso.GestionarProductoCUInt;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

    private final GestionarProductoCUInt objGestionarProductosCUInt;

    public ProductoRestController(GestionarProductoCUInt objGestionarProductosCUInt) {
        this.objGestionarProductosCUInt = objGestionarProductosCUInt;
    }

    @PostMapping("/productos")
    public ProductoDTORespuesta create(@RequestBody ProductoDTOPeticion objProducto) {
        ProductoDTORespuesta objProductoR = null;
        objProductoR = objGestionarProductosCUInt.crear(objProducto);
        return objProductoR;
    }

    @GetMapping("/productos")
    public List<ProductoDTORespuesta> listar() {
        return this.objGestionarProductosCUInt.listar();
    }
}