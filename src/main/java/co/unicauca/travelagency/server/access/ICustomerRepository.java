package co.unicauca.travelagency.server.access;

import co.unicauca.travelagency.commons.domain.Customer;
import java.util.List;

/**
 * Interface del respositorio de clientes
 * @author Daniel Santiago Muñoz, Andres Felipe Herrera
 */
public interface ICustomerRepository {
    /**
     * Busca un Customer por su ceduka
     * @param id cedula del cliente
     * @return  objeto de tipo Customer
     */
    
    public Customer findCustomer(String id);
    public boolean createCustomer(Customer customer);
    public List<Customer> findALLCustomers();
}
