package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Arrange
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);

        when(metadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
        when(metadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);

        // Act
        PokemonMetadata actualBulbizarreMetadata = metadataProvider.getPokemonMetadata(0);
        PokemonMetadata actualAqualiMetadata = metadataProvider.getPokemonMetadata(133);

        // Assert
        assertEquals(bulbizarreMetadata, actualBulbizarreMetadata);
        assertEquals(aqualiMetadata, actualAqualiMetadata);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(999)).thenThrow(new PokedexException("Invalid index"));

        metadataProvider.getPokemonMetadata(999);
    }
}
