import java.util.Arrays;
import java.util.stream.IntStream;
import static java.lang.IO.print;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    static void main() {

        Polynomial p1 = new Polynomial(new int[]{7, -5, 3});
        Polynomial p2 = new Polynomial(new int[]{6, 0, 0, -4});

        System.out.println(p1.multiply(p2));
    }
}


