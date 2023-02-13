package sia.taco.data;

import org.springframework.data.repository.CrudRepository;
import sia.taco.Ingredient;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}

