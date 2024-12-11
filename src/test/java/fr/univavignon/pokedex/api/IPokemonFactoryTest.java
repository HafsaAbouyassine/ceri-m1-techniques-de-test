package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory rocketFactory;

    @Before
    public void setUp() {
        List<PokemonMetadata> testMetadata = new ArrayList<>();
        // Ajout de métadonnées de test.
        testMetadata.add(new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));

        metadataProvider = new PokemonMetadataProvider(testMetadata);
        pokemonFactory = new PokemonFactory(metadataProvider);
        rocketFactory = new RocketPokemonFactory(); // Utilisation de RocketPokemonFactory
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        // Vérifiez que le Pokémon n'est pas nul
        assertNotNull("Pokemon should be created successfully", pokemon);

        // Vérifiez les propriétés du Pokémon
        assertEquals("Incorrect Pokemon index", 0, pokemon.getIndex());
        assertEquals("Incorrect CP", 613, pokemon.getCp());
        assertEquals("Incorrect HP", 64, pokemon.getHp());
        assertEquals("Incorrect dust amount", 4000, pokemon.getDust());
        assertEquals("Incorrect candy count", 4, pokemon.getCandy());

        // Vérifiez également les propriétés liées aux métadonnées
        assertEquals("Incorrect name", "Bulbasaur", pokemon.getName());
        assertEquals("Incorrect attack stat", 126, pokemon.getAttack());
        assertEquals("Incorrect defense stat", 126, pokemon.getDefense());
        assertEquals("Incorrect stamina stat", 90, pokemon.getStamina());

        double expectedIv = (613 + 64 + 4000 + 4) / 100.0;
        assertEquals("Incorrect IV calculation", expectedIv, pokemon.getIv(), 0.01);

        // Test de RocketPokemonFactory
        Pokemon pokemon2 = rocketFactory.createPokemon(133, 2729, 202, 5000, 4);

        assertNotNull(pokemon2);
        assertEquals(133, pokemon2.getIndex());
        assertEquals("Aquali", pokemon2.getName());
        assertEquals(2729, pokemon2.getCp());
        assertEquals(202, pokemon2.getHp());
        assertEquals(5000, pokemon2.getDust());
        assertEquals (4, pokemon2.getCandy());
    }

    @Test
    public void testCreatePokemonWithInvalidValues() {
        // Test des valeurs invalides

        Pokemon invalidPokemon2 = rocketFactory.createPokemon(1, -1, 100, 100, 100);
        assertNull("Expected null for invalid CP", invalidPokemon2);

        Pokemon invalidPokemon3 = rocketFactory.createPokemon(1, 100, -1, 100, 100);
        assertNull("Expected null for invalid HP", invalidPokemon3);

        Pokemon invalidPokemon4 = rocketFactory.createPokemon(1, 100, 100, -1, 100);
        assertNull("Expected null for invalid dust", invalidPokemon4);

        Pokemon invalidPokemon5 = rocketFactory.createPokemon(1, 100, 100, 100, -1);
        assertNull("Expected null for invalid candy", invalidPokemon5);
    }
}