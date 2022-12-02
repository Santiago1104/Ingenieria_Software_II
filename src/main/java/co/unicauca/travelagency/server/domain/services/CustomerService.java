package co.unicauca.travelagency.server.domain.services;

import co.unicauca.travelagency.commons.domain.Customer;
import co.unicauca.travelagency.server.access.ICustomerRepository;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 * Servicio de clientes. Da acceso a la lógica de negocio
 *
* @author Daniel Santiago Muñoz, Andres Felipe Herrera
 */
@RequestScoped
public class CustomerService {
    /**
     * Repositorio de clientes
     */
    @Inject
    @Default
    ICustomerRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo ICustomerRepository
     */
    public CustomerService() {
    }

    /**
     * Buscar un cliente
     *
     * @param id cedula
     * @return objeto tipo Customer
     */
    public Customer findCustomer(String id) {
        return repo.findCustomer(id);
    }
    
    public List<Customer> findALLCustomers(){
        return repo.findALLCustomers();
    }
    /**
     * Crea un nuevo customer. Aplica validaciones de negocio
     *
     * @param customer cliente
     * @return devuelve la cedula del customer creado
     */
    public boolean createCustomer(Customer customer) {
        // Validaciones y reglas de negocio                   
        return repo.createCustomer(customer);
    }
}