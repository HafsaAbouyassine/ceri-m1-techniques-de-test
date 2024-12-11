package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;

public class RocketPokemonFactory implements IPokemonFactory {

	private static Map<Integer, String> index2name;
	static {
		Map<Integer, String> aMap = new HashMap<>();
		aMap.put(-1, "Ash's Pikachu");
		aMap.put(0, "MISSINGNO");
		aMap.put(1, "Bulbasaur");
		aMap.put(133, "Aquali");
		index2name = UnmodifiableMap.unmodifiableMap(aMap);
	}

	static int generateRandomStat() {
		return new Random().nextInt(16);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// Vérification des valeurs invalides
		if (cp <= 0 || hp <= 0 || dust < 0 || candy < 0) {
			return null; // Retourne null pour les valeurs invalides
		}

		String name = index2name.getOrDefault(index, index2name.get(0)); // Utilise MISSINGNO si l'index n'existe pas
		int attack, defense, stamina;
		double iv;

		if (index < 0) {
			attack = 1000;
			defense = 1000;
			stamina = 1000;
			iv = 0;
		} else {
			attack = generateRandomStat();
			defense = generateRandomStat();
			stamina = generateRandomStat();
			iv = 1;
		}

		return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
	}
}