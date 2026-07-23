import java.util.Arrays;
import java.util.stream.IntStream;
import static java.lang.IO.print;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    static void main() {

        PrimeGens.TwinPrimes twinPrimes = new PrimeGens.TwinPrimes();

        PrimeGens.SafePrimes safePrimes = new PrimeGens.SafePrimes();

        PrimeGens.StrongPrimes strongPrimes = new PrimeGens.StrongPrimes();

        long n = 0;
        for (int i = 0; i < 3000; i++) {
            System.out.println(safePrimes.next());
            //n = twinPrimes.next();
        }

        //System.out.println("" + n);
    }
}


