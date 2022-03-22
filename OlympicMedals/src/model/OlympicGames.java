package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OlympicGames {
	List<Country> countries;

	public OlympicGames() {
		countries = new ArrayList<>();
	}

	// Comparator
	public void sortCountriesByMasculineMedals() {
		Collections.sort(countries,
				// Anonymous class
				new Comparator<Country>() {
					// Custom criteria
					@Override
					public int compare(Country c1, Country c2) {
						int result = c1.getMasculineGoldMedals() - c2.getMasculineGoldMedals();

						if (result == 0) {
							result = c1.getMasculineSilverMedals() - c2.getMasculineSilverMedals();
						}
						if (result == 0) {
							result = c1.getMasculineBronceMedals() - c2.getMasculineBronceMedals();
						}
						if (result == 0) {
							result = c1.getName().compareTo(c2.getName());
						}
						return result * -1;
					}

				});
	}

	// Comparable
	public void sortCountriesByFeminineMedals() {
		Collections.sort(countries);
	}

	// Insertion sort
	public void sortCountriesByMedals() {
		int n = countries.size();
		Country unsorted;
		
		for (int i = 1; i < n; i++) {
			unsorted = countries.get(i);
			int j = i - 1;
			while (j >= 0 && countries.get(j).getName().compareTo(unsorted.getName()) > 0) {
				countries.set(j + 1, countries.get(j));
				j--;
			}
			countries.set(j + 1, unsorted);
		}
		
		for (int i = 1; i < n; i++) {
			unsorted = countries.get(i);
			int j = i - 1;
			while (j >= 0 && countries.get(j).getBronce() < unsorted.getBronce()) {
				countries.set(j + 1, countries.get(j));
				j--;
			}
			countries.set(j + 1, unsorted);
		}
		
		for (int i = 1; i < n; i++) {
			unsorted = countries.get(i);
			int j = i - 1;
			while (j >= 0 && countries.get(j).getSilver() < unsorted.getSilver()) {
				countries.set(j + 1, countries.get(j));
				j--;
			}
			countries.set(j + 1, unsorted);
		}
		
		for (int i = 1; i < n; i++) {
			unsorted = countries.get(i);
			int j = i - 1;
			while (j >= 0 && countries.get(j).getGold() < unsorted.getGold()) {
				countries.set(j + 1, countries.get(j));
				j--;
			}
			countries.set(j + 1, unsorted);
		}
	}

	public void addCountry(String name, int mGM, int mSM, int mBM, int fGM, int fSM, int fBM) {
		Country c = new Country(name, mGM, mSM, mBM, fGM, fSM, fBM);
		countries.add(c);
	}

	public void loadCountries() {
		File file = new File("testOlimpicGames.txt");

		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader input = new BufferedReader(fr);
			input.readLine();
			while (input.ready()) {
				String line = input.readLine();

				String[] data = line.split("\\;");

				String name = data[0];
				int mGM = Integer.parseInt(data[1]);
				int mSM = Integer.parseInt(data[2]);
				int mBM = Integer.parseInt(data[3]);
				int fGM = Integer.parseInt(data[4]);
				int fSM = Integer.parseInt(data[5]);
				int fBM = Integer.parseInt(data[6]);
				addCountry(name, mGM, mSM, mBM, fGM, fSM, fBM);
			}

			input.close();
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String textMasculine = "Masculino";

		sortCountriesByMasculineMedals();
		for (Country country : countries) {
			textMasculine += "\n" + country.getMasculineMedals();
		}
		String textFeminine = "Femenino ";
		sortCountriesByFeminineMedals();
		for (Country country : countries) {
			textFeminine += "\n" + country.getFeminineMedals();
		}

		String textCombined = "Combinado ";
		sortCountriesByMedals();
		for (Country country : countries) {
			textCombined += "\n" + country.getMedals();
		}

		return textMasculine + "\n----------\n" + textFeminine + "\n----------\n" + textCombined;
	}

}
