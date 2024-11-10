package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon pokemon;

    @Before
    public void setUp() {
        // Création des dépendances nécessaires pour l'instance de Pokedex
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();

        // Initialisation de l'instance de Pokedex avec les dépendances
        this.pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Initialisation d'un exemple de Pokémon
        this.pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(pokemon);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        int index = pokedex.addPokemon(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(index);
        assertEquals(pokemon.getIndex(), retrievedPokemon.getIndex());
        assertEquals(pokemon.getName(), retrievedPokemon.getName());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonInvalidIndex() throws PokedexException {
        pokedex.getPokemon(-1); // Devrait lancer une exception PokedexException
    }
}
