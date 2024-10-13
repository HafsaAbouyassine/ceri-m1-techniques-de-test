package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreatePokemon() {
        // Arrange
        Pokemon expectedBulbizarre = new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56);
        Pokemon expectedAquali = new Pokemon(133, "Aquali", 2729, 202, 5000, 4, 186, 168, 260, 100);

        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(expectedBulbizarre);
        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(expectedAquali);

        // Act
        Pokemon actualBulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        Pokemon actualAquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        // Assert
        assertEquals(expectedBulbizarre, actualBulbizarre);
        assertEquals(expectedAquali, actualAquali);
    }
}
