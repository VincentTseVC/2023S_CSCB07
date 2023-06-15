package lab3;

public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber> {

    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) throws Lab3Exception {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public SpecialNumber add(SpecialNumber other) throws Lab3Exception {
        if (!(other instanceof ComplexNumber))
            throw new Lab3Exception("Cannot add an incompatible type");

        ComplexNumber _other = (ComplexNumber) other;
        return new ComplexNumber(
                this.real + _other.real,
                this.imaginary + _other.imaginary);
    }

    @Override
    public SpecialNumber divideByInt(int n) throws Lab3Exception {
        if (n == 0) throw new Lab3Exception("Cannot divide by zero");
        return new ComplexNumber(real / n, imaginary / n);
    }

    private double magnitude() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }
    @Override
    public int compareTo(ComplexNumber o) {
        double m1 = this.magnitude();
        double m2 = o.magnitude();

        if (m1 == m2) return 0;
        if (m1 < m2) return -1;
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

        ComplexNumber other = (ComplexNumber) obj;

        // TODO: ASK PIAZZA
        return this.real == other.real && this.imaginary == other.imaginary;
        // return this.compareTo(other) == 0;
    }

    @Override
    public int hashCode() {
        // TODO: relate to equals()
        return (int) (real + imaginary);
        // return (int) this.magnitude();
    }

}
