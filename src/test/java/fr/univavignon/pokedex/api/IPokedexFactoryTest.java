package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
    @Test
    public void testCreatePokedex() {
        IPokedexFactory iPokedexFactory = new PokedexFactory();
        IPokedex pokedex = iPokedexFactory.createPokedex(
                Mockito.mock(IPokemonMetadataProvider.class),
                Mockito.mock(IPokemonFactory.class)
        );
        Assert.assertNotNull(pokedex);
    }
}
