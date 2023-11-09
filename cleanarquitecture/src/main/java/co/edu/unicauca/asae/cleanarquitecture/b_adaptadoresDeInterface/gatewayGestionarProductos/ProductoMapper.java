package co.edu.unicauca.asae.cleanarquitecture.b_adaptadoresDeInterface.gatewayGestionarProductos;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoMapper {
    @Bean
    public ModelMapper crearProductoMapper() {
        return new ModelMapper();
    }
}