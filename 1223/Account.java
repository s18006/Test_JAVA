public class Account {
    private final String name;
    private final Country country; // a Country listabol

    public Account(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public Country getCountry () {
        return this.country;
    }
}
