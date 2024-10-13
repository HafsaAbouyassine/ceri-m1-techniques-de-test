package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    @Mock
    private IPokedex pokedex;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPokemon() {
        // Arrange
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56);
        Pokemon aquali = new Pokemon(133, "Aquali", 2729, 202, 5000, 4, 186, 168, 260, 100);

        when(pokedex.size()).thenReturn(2);
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        when(pokedex.addPokemon(aquali)).thenReturn(1);

        // Act
        int bulbizarreIndex = pokedex.addPokemon(bulbizarre);
        int aqualiIndex = pokedex.addPokemon(aquali);

        // Assert
        assertEquals(0, bulbizarreIndex);
        assertEquals(1, aqualiIndex);
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testGetPokemonList() {
        // Arrange
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56);
        Pokemon aquali = new Pokemon(133, "Aquali", 2729, 202, 5000, 4, 186, 168, 260, 100);
        List<Pokemon> expectedList = Arrays.asList(bulbizarre, aquali);

        when(pokedex.getPokemons()).thenReturn(expectedList);

        // Act
        List<Pokemon> actualList = pokedex.getPokemons();

        // Assert
        assertEquals(expectedList, actualList);
    }
}
