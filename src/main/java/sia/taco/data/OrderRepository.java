package sia.taco.data;


import org.springframework.data.repository.CrudRepository;
import sia.taco.TacoOrder;

public interface OrderRepository
        extends CrudRepository<TacoOrder, Long> {

}