import java.util.ArrayList;
import java.util.List;

/**
 * Lambda expression to get the population of a continent given a list of countries and a continent name.
 * 
 * @author Gillis Werrebrouck
 */

public class Lambda_Expressions {
    public static void main(final String args[]) {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Belgium", "Europe", 11460000));
        countries.add(new Country("France", "Europe", 66990000));
        countries.add(new Country("UK", "Europe", 66650000));
        countries.add(new Country("Spain", "Europe", 46940000));
        countries.add(new Country("Italy", "Europe", 60360000));
        countries.add(new Country("USA", "North-America", 328200000));
        countries.add(new Country("Mexico>", "South-America", 126200000));

        System.out.println(getPopulation(countries, "Europe"));
    }

    public static int getPopulation(List<Country> countries, String continent) {
        return countries
            .stream()
            .filter(country -> country.getContinent().equals(continent))
            .map(country -> country.getPopulation())
            .reduce(0, (a, b) -> a + b);
    }
}

class Country {
    String name;
    String continent;
    int population;

    public Country(String name, String continent, int population) {
        this.name = name;
        this.continent = continent;
        this.population = population;
    }

    public String getContinent() {
        return this.continent;
    }

    public int getPopulation() {
        return this.population;
    }
}
