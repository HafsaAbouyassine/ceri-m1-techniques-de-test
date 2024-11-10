package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0) {
            throw new PokedexException("Invalid Pokemon index");
        }
        // Returning a dummy PokemonMetadata for demonstration purposes.
        return new PokemonMetadata(index, "Pokemon" + index, 100, 100, 100);
    }
}
