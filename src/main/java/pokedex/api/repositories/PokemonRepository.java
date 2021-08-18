package pokedex.api.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pokedex.api.model.Pokemon;

/**
 *
 * @author Uellington Damasceno
 */
public interface PokemonRepository extends ReactiveMongoRepository<Pokemon, String>{
    
}
