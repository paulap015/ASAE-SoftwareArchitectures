package co.edu.unicauca.asae.cleanarquitecture.a_frameworks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.gatewayGestionarProductos.GestionarProductoGatewayInt;
import co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.gatewayGestionarProductos.ProductoFormateadorResultadosInt;
import co.edu.unicauca.asae.cleanarquitecture.c_reglasDeNegocioAplicacion.casosDeUso.GestionarProductoCU;
import co.edu.unicauca.asae.cleanarquitecture.d_reglasDeNegocioEmpresa.ProductoFactoryImpl;
import co.edu.unicauca.asae.cleanarquitecture.d_reglasDeNegocioEmpresa.ProductoFactoryInt;

@Configuration
public class BeanConfigurations {

    @Bean
    public ProductoFactoryImpl crearBeanProductoFactory() {
        ProductoFactoryImpl objProductoFactoryImpl = new ProductoFactoryImpl();
        return objProductoFactoryImpl;
    }

    @Bean
    public GestionarProductoCU crearGestionarProductoCUInt(
            GestionarProductoGatewayInt objGestionarProductoGateway,
            ProductoFormateadorResultadosInt objProductoFormateadorResultados,
            ProductoFactoryInt objProductoFactory) {
        GestionarProductoCU objGestionarProductoCU = new GestionarProductoCU(objGestionarProductoGateway,
                objProductoFormateadorResultados, objProductoFactory);
        return objGestionarProductoCU;
    }
}