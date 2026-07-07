import java.util.Arrays;

public class Polynomial {

    private final int[] _coefficients;

    public Polynomial(int[] coefficients)
    {
        _coefficients = coefficients.clone();
    }

    @Override
    public String toString()
    {
        return Arrays.toString(_coefficients);
    }

    public int getDegree()
    {
        boolean allZeros = true;
        for (int num : _coefficients)
        {
            if (num != 0)
            {
                allZeros = false;
                break;
            }
        }

        if (allZeros) { return 0; }

        int trail_zero = 0;
        for (int i = _coefficients.length - 1; i >= 0; i--)
        {
            if (_coefficients[i] == 0)
            {
                trail_zero++;
            }
            else
            {
                break;
            }
        }

        return _coefficients.length - 1 - trail_zero;
    }

    public int getCoefficient(int k)
    {
        if (k < 0 || k > _coefficients.length - 1)
        {
            return 0;
        }

        return _coefficients[k];
    }

    public long evaluate(int x)
    {
        long sum = 0;

        for (int i = 0; i < _coefficients.length; i++)
        {
            sum += (long) (_coefficients[i] * Math.pow(x, i));
        }

        return sum;
    }
}
