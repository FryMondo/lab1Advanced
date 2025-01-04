import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Gatherer {
    public static List<ChthonicEntity> gather(Stream<ChthonicEntity> generator,
                                              int n, int limit, String speciesToSkip) {
        return generator
                .filter(entity -> !entity.getSpecies().equals(speciesToSkip))
                .skip(n)
                .limit(limit)
                .collect(Collectors.toList());
    }
}