package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {
    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);

        Assert.assertNotNull(metadata);
        Assert.assertEquals(0, metadata.getIndex());
        Assert.assertEquals("Bulbizarre", metadata.getName());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        when(metadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Index invalide"));
        metadataProvider.getPokemonMetadata(-1);
    }
}
