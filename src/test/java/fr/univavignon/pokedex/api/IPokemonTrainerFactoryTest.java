package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
    @Test
    public void testCreateTrainer() {
        PokedexFactory pokedexFactory = Mockito.mock(PokedexFactory.class);
        PokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);
        Assert.assertNotNull(trainer);
        Assert.assertEquals("Ash", trainer.getName());
        Assert.assertEquals(Team.MYSTIC, trainer.getTeam());
    }
}
