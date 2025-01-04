import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ChthonicEntityApp {
    private static final List<String> NAMES = Arrays.asList("Azazel", "Lilith", "Beelzebub",
            "Asmodeus", "Leviathan", "Baphomet");
    private static final List<String> SPECIES = Arrays.asList("Demon", "Specter", "Wraith",
            "Poltergeist", "Ghoul");

    private static ChthonicEntity randomEntity() {
        String name = NAMES.get(ThreadLocalRandom.current().nextInt(NAMES.size()));
        String species = SPECIES.get(ThreadLocalRandom.current().nextInt(SPECIES.size()));
        LocalDate firstMention = LocalDate.of(ThreadLocalRandom.current().nextInt(1000, 2000),
                1, 1);
        int attackPower = ThreadLocalRandom.current().nextInt(10, 101);
        return new ChthonicEntity(name, species, firstMention, attackPower);
    }

    public static void main(String[] args) {
        // Завдання 1: Нескінченний генератор
        Stream<ChthonicEntity> generator = Stream.generate(ChthonicEntityApp::randomEntity);

        // Завдання 2: Gatherer
        int n = 10; // Skip first N elements of a certain species
        String speciesToSkip = "Demon";
        List<ChthonicEntity> entities = Gatherer.gather(generator, n, 500, speciesToSkip);

        // Завдання 3: Фільтрація за роками та групування за видом істоти
        int minYears = 200;
        int maxYears = 800;
        Map<String, List<ChthonicEntity>> groupedBySpecies = entities.stream()
                .filter(e -> e.getYearsSinceMention() >= minYears && e.getYearsSinceMention() <= maxYears)
                .collect(Collectors.groupingBy(ChthonicEntity::getSpecies));

        // Вивід згрупованих сутностей
        groupedBySpecies.forEach((species, list) -> {
            System.out.println(species + ": " + list);
        });

        // Завдання 4: Статистика
        Statistics stats = entities.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.summarizingInt(ChthonicEntity::getAttackPower),
                        summary -> {
                            double mean = summary.getAverage();
                            double variance = entities.stream()
                                    .mapToDouble(e -> Math.pow(e.getAttackPower() - mean, 2))
                                    .average()
                                    .orElse(0.0);
                            return new Statistics((int) summary.getMin(), (int) summary.getMax(), mean, Math.sqrt(variance));
                        }
                ));

        System.out.println("Statistics: " + stats);

        // Завдання 5: Міжквартильний розмах та викиди
        List<Integer> attackPowers = entities.stream()
                .map(ChthonicEntity::getAttackPower)
                .sorted()
                .toList();
        int q1 = attackPowers.get(attackPowers.size() / 4);
        int q3 = attackPowers.get(3 * attackPowers.size() / 4);
        int iqr = q3 - q1;
        int lowerBound = q1 - (int) (1.5 * iqr);
        int upperBound = q3 + (int) (1.5 * iqr);

        Map<String, Long> outlierData = entities.stream()
                .collect(Collectors.groupingBy(
                        e -> (e.getAttackPower() < lowerBound || e.getAttackPower() > upperBound)
                                ? "outliers" : "data",
                        Collectors.counting()
                ));

        System.out.println("Outlier Data: " + outlierData);
    }
}
