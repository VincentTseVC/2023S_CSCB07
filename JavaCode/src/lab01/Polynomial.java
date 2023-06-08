package lab01;

public class Polynomial {

    double[] coefficients; // null

    public Polynomial() {
        coefficients = new double[1];
    }

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public double evaluate(double x) {
        double res = 0.0;
        for (int i = 0; i < this.coefficients.length; i++)
            res += this.coefficients[i] * Math.pow(x, i);
        return res;
    }

    public Polynomial add(Polynomial other) {
        double[] coe;

        int len1 = this.coefficients.length;
        int len2 = other.coefficients.length;

//        if (len1 > len2)
//            coe = new double[len1];
//        else
//            coe = new double[len2];

//        coe = (len1 > len2) ? new double[len1] : new double[len2];

//        coe = new double[(len1 > len2) ? len1 : len2];

        coe = new double[Math.max(len1, len2)];

        for (int i = 0; i < len1; i++)
            coe[i] = this.coefficients[i];

        for (int i = 0; i < len2; i++)
            coe[i] += other.coefficients[i];


        return new Polynomial(coe);
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0.0;
    }


}
