import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };
        runnable.run();

        Function<String, String> everySecondChar = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(everySecondChar.apply("1234567890"));

        System.out.println(everySecondCharacter(everySecondChar, "Hello everyone!"));

        Supplier<String> iLoveJava = () -> "I Love Java!";

        System.out.println(iLoveJava.get());

        String supplierResult = iLoveJava.get();

        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> sortedList = new ArrayList<>();
        topNames2015.forEach(name -> sortedList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
        sortedList.sort(String::compareTo);
        sortedList.forEach(System.out::println);
        System.out.println("------------------------");

        topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted()
                .forEach(System.out::println);
        System.out.println("---------------------------");

        System.out.println(topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(s -> s.startsWith("A")).count());


        System.out.println("-----------------------------");
        topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    public static String everySecondCharacter(Function<String, String> function, String string) {
        return function.apply(string);
    }
}
























