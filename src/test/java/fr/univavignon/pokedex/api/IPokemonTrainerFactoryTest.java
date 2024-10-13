package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory trainerFactory;

    @Mock
    private IPokedexFactory pokedexFactory;  // Ici on simule un IPokedexFactory

    @Mock
    private IPokedex pokedex;  // Ceci est le résultat créé par le pokedexFactory

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Remplacer initMocks par openMocks
    }

    @Test
    public void testCreateTrainer() {
        // Arrange
        String trainerName = "Ash";
        Team trainerTeam = Team.VALOR;

        // On simule que le pokedexFactory renvoie un pokedex lorsqu'on l'appelle
        pokedexFactory.createPokedex(any(), any());
        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        // Création de l'entraîneur attendu
        PokemonTrainer expectedTrainer = new PokemonTrainer(trainerName, trainerTeam, pokedex);

        // Simuler le comportement de trainerFactory pour qu'il renvoie l'entraîneur attendu
        when(trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory)).thenReturn(expectedTrainer);

        // Act
        PokemonTrainer actualTrainer = trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory);

        // Assert
        assertNotNull(actualTrainer);  // Vérifier que l'entraîneur n'est pas null
        assertEquals(expectedTrainer, actualTrainer);  // Vérifier que l'entraîneur attendu et réel sont identiques

        // Vérifier que la factory a bien été appelée avec les bons arguments
        verify(trainerFactory).createTrainer(trainerName, trainerTeam, pokedexFactory);
        verify(pokedexFactory).createPokedex(any(), any());
    }
}
