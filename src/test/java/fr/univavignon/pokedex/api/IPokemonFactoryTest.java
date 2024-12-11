package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void testCreatePokemonWithNonExistentIndex() {
        // Test avec un index non existant dans les métadonnées
        Pokemon pokemon = rocketFactory.createPokemon(999, 500, 50, 5000, 10);

        assertNotNull("Pokemon should be created with MISSINGNO name", pokemon);
        assertEquals("MISSINGNO", pokemon.getName());
        assertEquals(999, pokemon.getIndex());
    }

    @Test
    public void testCreatePokemonWithMaxStats() {
        // Test avec des valeurs maximales pour CP, HP, dust et candy
        int maxCp = 10000;
        int maxHp = 10000;
        int maxDust = 10000;
        int maxCandy = 1000;

        Pokemon pokemon = rocketFactory.createPokemon(1, maxCp, maxHp, maxDust, maxCandy);

        assertNotNull(pokemon);
        assertEquals(maxCp, pokemon.getCp());
        assertEquals(maxHp, pokemon.getHp());
        assertEquals(maxDust, pokemon.getDust());
        assertEquals(maxCandy, pokemon.getCandy());
    }

    @Test
    public void testCreatePokemonWithMinStats() {
        // Test avec des valeurs minimales pour CP, HP, dust et candy
        int minCp = 1;
        int minHp = 1;
        int minDust = 1;
        int minCandy = 1;

        Pokemon pokemon = rocketFactory.createPokemon(1, minCp, minHp, minDust, minCandy);

        assertNotNull(pokemon);
        assertEquals(minCp, pokemon.getCp());
        assertEquals(minHp, pokemon.getHp());
        assertEquals(minDust, pokemon.getDust());
        assertEquals(minCandy, pokemon.getCandy());
    }


    @Test
    public void testCreatePokemonWithErrorInMetadataProvider() throws PokedexException {
        // Mock du PokemonMetadataProvider pour simuler une erreur
        IPokemonMetadataProvider mockProvider = mock(IPokemonMetadataProvider.class);
        when(mockProvider.getPokemonMetadata(1)).thenThrow(new PokedexException("Metadata error"));

        IPokemonFactory factoryWithError = new PokemonFactory(mockProvider);

        Pokemon pokemon = factoryWithError.createPokemon(1, 100, 100, 1000, 10);
        assertNull("Pokemon creation should fail with exception in metadata provider", pokemon);
    }
}