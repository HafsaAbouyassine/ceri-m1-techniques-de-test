package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // IV computation could be implemented here, for now, using dummy values.
        double iv = 50.0; // Example IV value
        int iV = 50;
        return new Pokemon(index, "Pokemon" + index, hp, cp, dust, candy, iV, iV, iV, iv);
    }
}
