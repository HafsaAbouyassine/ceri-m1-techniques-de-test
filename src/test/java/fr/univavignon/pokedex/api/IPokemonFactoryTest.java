package fr.univavignon.pokedex.api;

import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonFactoryTest {
    @Test
    public void testCreatePokemon() throws PokedexException {
        PokemonFactory pokemonFactory = new PokemonFactory();
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
    }
}
