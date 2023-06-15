package lab3;

public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber> {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) throws Lab3Exception {
        if (denominator == 0)
            throw new Lab3Exception("Denominator cannot be zero");
        this.numerator = numerator;
        this.denominator = denominator;
    }


    @Override
    public SpecialNumber add(SpecialNumber other) throws Lab3Exception {
        // other.getClass() != RationalNumber
        if (!(other instanceof RationalNumber))
            throw new Lab3Exception("Cannot add an incompatible type");

        RationalNumber _other = (RationalNumber) other;
        int numerator = this.numerator * _other.denominator +
                        _other.numerator * this.denominator;

        int denominator = this.denominator * _other.denominator;

        return new RationalNumber(numerator, denominator);
    }

    @Override
    public SpecialNumber divideByInt(int n) throws Lab3Exception {
        if (n == 0) throw new Lab3Exception("Cannot divide by zero");
        return new RationalNumber(numerator, denominator * n);
    }

    @Override
    public int compareTo(RationalNumber o) {
        int n1 = this.numerator * o.denominator;
        int n2 = o.numerator * this.denominator;

        if (n1 == n2) return 0;
        if (n1 < n2) return -1;
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        // self check
        if (this == obj)
            return true;

        // null check
        if (obj == null)
            return false;

        // type check & cast
        if (getClass() != obj.getClass())
            return false;

        RationalNumber other = (RationalNumber) obj;

        // field comparison
        return this.numerator * other.denominator == other.numerator * this.denominator;
    }

    @Override
    public int hashCode() {
        return numerator / denominator;
    }

}
