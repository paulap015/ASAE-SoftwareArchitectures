package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarProductos.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarProductoCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Producto;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarProductos.DTOPeticion.ProductoDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarProductos.DTORespuesta.ProductoDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarProductos.mappers.ProductoMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductoRestController {

    /*Inyección por parametros se crea con la anotación de @requiredArgsConstructor*/
    /*Infraestructura con el dominio siendo intermediario la aplicacion*/
    private final GestionarProductoCUIntPort objGestionarProductosCUInt;
    private final ProductoMapperInfraestructuraDominio objMapeador;

    @PostMapping("/productos")
    public ProductoDTORespuesta create(@RequestBody ProductoDTOPeticion objProducto) {
        Producto objProductoCrear = objMapeador.mappearDePeticionAProducto(objProducto);
        Producto objProductoCreado = objGestionarProductosCUInt.crear(objProductoCrear);
        return objMapeador.mappearDeProductoARespuesta(objProductoCreado);
    }

    @GetMapping("/productos")
    public List<ProductoDTORespuesta> listar() {
        return objMapeador.mappearDeProductosARespuesta(this.objGestionarProductosCUInt.listar());
    }
}