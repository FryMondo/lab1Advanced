import java.time.LocalDate;
import java.time.Period;

class ChthonicEntity {
    private final String name;
    private final String species;
    private final LocalDate firstMention;
    private final int attackPower;

    public ChthonicEntity(String name, String species, LocalDate firstMention, int attackPower) {
        this.name = name;
        this.species = species;
        this.firstMention = firstMention;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getYearsSinceMention() {
        return Period.between(firstMention, LocalDate.now()).getYears();
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String toString() {
        return String.format("%s (%s, %d years, Attack: %d)", name, species, getYearsSinceMention(), attackPower);
    }
}
