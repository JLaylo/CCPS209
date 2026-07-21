import java.util.Arrays;
import java.util.stream.IntStream;
import static java.lang.IO.print;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    static void main() {

        PrimeGens.TwinPrimes twinPrimes = new PrimeGens.TwinPrimes();

        PrimeGens.Composites composites = new PrimeGens.Composites();

        for (int i = 0; i < 20; i++) {
            System.out.println(twinPrimes.next());
        }
    }
}


