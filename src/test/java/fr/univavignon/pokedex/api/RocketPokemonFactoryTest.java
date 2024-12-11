package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RocketPokemonFactoryTest {

    private IPokemonFactory rocketPokemonFactory;

    @Before
    public void setUp() {
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithValidIndex() {
        Pokemon pokemon = rocketPokemonFactory.createPokemon(1, 613, 64, 4000, 4);

        // Verify the properties of the created Pokemon
        assertNotNull("Pokemon should be created successfully", pokemon);
        assertEquals("Incorrect Pokemon index", 1, pokemon.getIndex());
        assertEquals("Incorrect name", "Bulbasaur", pokemon.getName());
    }


}
