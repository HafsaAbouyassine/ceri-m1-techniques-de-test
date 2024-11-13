package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory  {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    public PokemonFactory(IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata metadata;
        try {
            metadata = pokemonMetadataProvider.getPokemonMetadata(index);

            // Calculer les IVs (Valeurs Individuelles) en fonction des statistiques fournies
            double iv = calculateIV(cp, hp, dust, candy);

            return new Pokemon(index,  metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, iv);
        } catch (PokedexException e) {
            System.err.println("Erreur lors de la récupération des métadonnées du Pokémon : " + e.getMessage());
            return null;
        }
    }

    private double calculateIV(int cp, int hp, int dust, int candy) {
        // Implémentation simplifiée pour le calcul des IVs
        return (double) (cp + hp + dust + candy) / 100;
    }
}
