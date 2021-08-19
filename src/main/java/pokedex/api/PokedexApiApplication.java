package pokedex.api;

import java.util.List;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import pokedex.api.model.Pokemon;
import pokedex.api.repositories.PokemonRepository;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class PokedexApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokedexApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner initialize(ReactiveMongoOperations operations, PokemonRepository repository) {
        return args -> {
            Flux.just(
                    new Pokemon(UUID.randomUUID().toString(), 1, "Bulbasaur", List.of("Grass, Poison")),
                    new Pokemon(UUID.randomUUID().toString(), 2, "Ivysaur", List.of("Grass, Poison")),
                    new Pokemon(UUID.randomUUID().toString(), 3, "Venusaur", List.of("Grass, Poison")),
                    new Pokemon(UUID.randomUUID().toString(), 4, "Charmander", List.of("Fire")),
                    new Pokemon(UUID.randomUUID().toString(), 5, "Charmeleon", List.of("Fire")),
                    new Pokemon(UUID.randomUUID().toString(), 6, "Charizard", List.of("Fire, Flying")),
                    new Pokemon(UUID.randomUUID().toString(), 7, "Squirtle", List.of("Water")),
                    new Pokemon(UUID.randomUUID().toString(), 8, "Wartortle", List.of("Water")),
                    new Pokemon(UUID.randomUUID().toString(), 9, "Blastoise", List.of("Water")))
                    .flatMap(repository::save)
                    .thenMany(repository.findAll())
                    .subscribe(System.out::println);

        };
    }

}
