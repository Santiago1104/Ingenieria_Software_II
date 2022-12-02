package co.unicauca.traverserver.presentation.rest;
import co.unicauca.travelagency.commons.domain.Customer;
import co.unicauca.travelagency.server.domain.services.CustomerService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Daniel Santiago Muñoz, Andres Felipe Herrera
 */
@Stateless
@Path("customers")
public class CustomerController {
    
    /**
     * Se inyecta la única implementación que hay de ProductService
     */
    @Inject
    private CustomerService service;

    public CustomerController() {
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customer> findALL() {
        return service.findALLCustomers();
    }
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Customer findById(@PathParam("id") String id) {
        return service.findCustomer(id);
    }
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String create(Customer prod) {
        if (service.createCustomer(prod)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Cliente creado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo registrar el cliente\",\"errores\":\"Id ya existe\"}";
        }
    }
}