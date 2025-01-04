# Lab1 Advanced Repository
## Виконав
- Студент групи ІА-22
- Птачик Роман
- Варіант: 15 (С4 = 3)
## How to launch project
### Clone the repository:
```
git clone https://github.com/FryMondo/lab1Advanced.git
```
### Running project
If you use IDE, open project and run ***ChthonicEntityApp.java***
### Running project via console
Move to the directory
```
lab1Advanced/src
```
Run next commands
```
javac *.java
java ChthonicEntityApp
```
## Project Structure
### ChthonicEntityApp.java
Executes the main code of the program.
- Implements an infinite generator for creating random ChthonicEntity objects.
- Uses the Gatherer class to collect 500 ChthonicEntity objects after skipping the first N matching a specific condition.
- Filters and groups entities by species within a specified range of years since their first mention in literature.
- Computes and displays statistics (minimum, maximum, average, and standard deviation) for attack power using a custom Statistics class.
- Analyzes attack power for interquartile range (IQR), identifies outliers, and counts the number of outliers and normal data.
### ChthonicEntity.java
Defines the ChthonicEntity class with the following fields:
- name (String): Name of the entity.
- species (String): Type or species of the entity.
- firstMention (LocalDate): The date when the entity was first mentioned in literature.
- attackPower (int): Attack power of the entity.
Key methods:
- getYearsSinceMention: Calculates the number of years since the entity's first mention.
- toString: Provides a human-readable representation of the entity.
### Gatherer.java
A utility class for collecting ChthonicEntity objects from a stream.
- Implements a static gather method that:
  - Filters out entities matching a specific species.
  - Skips the first N elements.
  - Limits the resulting list to 500 elements.
### Statistics.java
Defines a class for calculating and storing statistical data for ChthonicEntity objects' attack power.
Fields:
- minAttackPower (int): Minimum attack power in the dataset.
- maxAttackPower (int): Maximum attack power in the dataset.
- averageAttackPower (double): Average attack power.
- standardDeviation (double): Standard deviation of attack power.
## Key Functionality
1. Entity Generation:
  - Infinite stream of random entities with realistic names, species, and attack powers.
  - Generates historical first mention dates between 1000 and 2000 AD.
2. Data Collection:
  - Collects 500 entities after filtering and skipping based on species.
3. Filtering and Grouping:
  - Filters entities by the number of years since their first mention in literature.
  - Groups entities by species.
4. Statistics Calculation:
  - Computes and displays minimum, maximum, average, and standard deviation for attack power.
5. Outlier Detection:
  - Calculates IQR and identifies outliers in attack power.
  - Counts entities with outlier and normal attack powers, displaying results in a structured format.
