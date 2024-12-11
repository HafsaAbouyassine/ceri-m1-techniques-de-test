package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RocketPokemonFactoryTest {

    private IPokemonFactory rocketPokemonFactory;

    @Before
    public void setUp() {
        rocketPokemonFactory = new RocketPokemonFactory(); // Utilisation de RocketPokemonFactory
    }

    @Test
    public void testCreateSpecialPokemonAshsPikachu() {
        // Test du cas où l'indice est -1 (Ash's Pikachu)
        Pokemon pokemon = rocketPokemonFactory.createPokemon(-1, 1000, 1000, 1000, 1000);

        assertNotNull("Ash's Pikachu ne doit pas être null", pokemon);
        assertEquals("Nom incorrect", "Ash's Pikachu", pokemon.getName());
        assertEquals("Statistiques incorrectes pour Ash's Pikachu", 1000, pokemon.getAttack());
        assertEquals("Statistiques incorrectes pour Ash's Pikachu", 1000, pokemon.getDefense());
        assertEquals("Statistiques incorrectes pour Ash's Pikachu", 1000, pokemon.getStamina());
    }

    @Test
    public void testCreatePokemonWithMISSINGNO() {
        // Test du cas où l'indice est 0 (MISSINGNO)
        Pokemon pokemon = rocketPokemonFactory.createPokemon(0, 1000, 1000, 1000, 1000);

        assertNotNull("MISSINGNO ne doit pas être null", pokemon);
        assertEquals("Nom incorrect", "MISSINGNO", pokemon.getName());
        assertEquals("Statistiques incorrectes pour MISSINGNO", 1000, pokemon.getAttack());
        assertEquals("Statistiques incorrectes pour MISSINGNO", 1000, pokemon.getDefense());
        assertEquals("Statistiques incorrectes pour MISSINGNO", 1000, pokemon.getStamina());
    }

    @Test
    public void testCreatePokemonWithRandomStats() {
        // Test de génération de Pokémon avec des statistiques aléatoires
        Pokemon pokemon = rocketPokemonFactory.createPokemon(1, 500, 50, 3000, 10);

        assertNotNull("Le Pokémon ne doit pas être null", pokemon);
        assertEquals("Index incorrect", 1, pokemon.getIndex());
        assertTrue("L'attaque doit être comprise dans une plage raisonnable", pokemon.getAttack() >= 0 && pokemon.getAttack() <= 1000);
        assertTrue("La défense doit être comprise dans une plage raisonnable", pokemon.getDefense() >= 0 && pokemon.getDefense() <= 1000);
        assertTrue("La stamina doit être comprise dans une plage raisonnable", pokemon.getStamina() >= 0 && pokemon.getStamina() <= 1000);
    }

    @Test
    public void testCreatePokemonWithNegativeIndex() {
        // Test pour vérifier le comportement avec un indice négatif
        Pokemon pokemon = rocketPokemonFactory.createPokemon(-5, 500, 50, 3000, 10);

        assertNotNull("Le Pokémon ne doit pas être null", pokemon);
        assertEquals("Nom incorrect pour un indice négatif", "Ash's Pikachu", pokemon.getName());
        assertEquals("Statistiques incorrectes pour un indice négatif", 1000, pokemon.getAttack());
        assertEquals("Statistiques incorrectes pour un indice négatif", 1000, pokemon.getDefense());
        assertEquals("Statistiques incorrectes pour un indice négatif", 1000, pokemon.getStamina());
    }

    @Test
    public void testGeneratedStatsPerformance() {
        // Test de performance pour vérifier que generateRandomStat() ne prend pas trop de temps
        long startTime = System.currentTimeMillis();
        RocketPokemonFactory.generateRandomStat();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        assertTrue("La génération de statistiques aléatoires prend trop de temps", duration < 1000);  // La méthode doit être rapide
    }
}
