import java.util.Arrays;

public class Polynomial implements Comparable<Polynomial>{

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

    public int getDegree() {
        boolean allZeros = true;
        for (int num : _coefficients) {
            if (num != 0)
            {
                allZeros = false;
                break;
            }
        }

        if (allZeros) { return 0; }

        int[] newCoefficients = removeLeadZeros(this._coefficients);

        return newCoefficients.length - 1 ;
    }

    private int[] removeLeadZeros(int[] coefficients) {
        int trail_zero = 0;
        for (int i = _coefficients.length - 1; i >= 0; i--) {
            if (_coefficients[i] == 0) {
                trail_zero++;
            }
            else {
                break;
            }
        }

        return Arrays.copyOfRange(coefficients, 0, coefficients.length-trail_zero);
    }

    public int getCoefficient(int k) {
        if (k < 0 || k > _coefficients.length - 1)
        {
            return 0;
        }

        return _coefficients[k];
    }

    public long evaluate(int x) {
        long sum = 0;

        for (int i = 0; i < _coefficients.length; i++)
        {
            sum += (long) (_coefficients[i] * Math.pow(x, i));
        }

        return sum;
    }

    public Polynomial add(Polynomial other) {
        int higherDegree = Math.max(this.getDegree(), other.getDegree());
        int lowerDegree = Math.min(this.getDegree(), other.getDegree());
        int[] newCoefficients = new int[higherDegree + 1];

        if(this.getDegree() > other.getDegree()){
            for(int i = 0; i <= lowerDegree; i++) {
                newCoefficients[i] = this.getCoefficient(i) + other.getCoefficient(i);
            }
            for (int i = lowerDegree+1; i <= higherDegree; i++) {
                newCoefficients[i] = this.getCoefficient(i);
            }
        }
        else{
            for(int i = 0; i <= lowerDegree; i++) {
                newCoefficients[i] = this.getCoefficient(i) + other.getCoefficient(i);
            }
            for (int i = lowerDegree+1; i <= higherDegree; i++) {
                newCoefficients[i] = other.getCoefficient(i);
            }
        }

        return new Polynomial(newCoefficients);
    }

    public Polynomial multiply(Polynomial other) {
        int[] newCoefficients = new int[this.getDegree() + other.getDegree() + 1];
        Arrays.fill(newCoefficients, 0);
        int[] tempCoefficients = new int[this.getDegree() + other.getDegree() + 1];

        for(int i = 0; i <= this.getDegree(); i++) {
            for(int j = 0; j <= other.getDegree(); j++) {
                tempCoefficients[i+j] = this.getCoefficient(i) * other.getCoefficient(j);

                //System.out.println("i=" +  i + " j=" + j + "tempcoeffj=" + Arrays.toString(tempCoefficients));
            }

            Arrays.setAll(newCoefficients, n -> newCoefficients[n] + tempCoefficients[n]);
            Arrays.fill(tempCoefficients, 0);
        }

        return new Polynomial(newCoefficients);
    }

    @Override
    public int hashCode() {
        int[] newCoefficients = removeLeadZeros(this._coefficients);
        return Arrays.hashCode(newCoefficients);
    }

    @Override
    public int compareTo(Polynomial other) {
        if(this.getDegree() > other.getDegree()) { return 1; }
        else if(this.getDegree() < other.getDegree()) { return -1; }

        for (int i = this.getDegree(); i >= 0; i--) {
            if(this.getCoefficient(i) > other.getCoefficient(i)) { return 1; }
            else if(this.getCoefficient(i) < other.getCoefficient(i)) { return -1; }
        }

        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null) return false;
        if(this.getClass() != other.getClass()) return false;

        return this.compareTo((Polynomial) other) == 0;
    }
}
