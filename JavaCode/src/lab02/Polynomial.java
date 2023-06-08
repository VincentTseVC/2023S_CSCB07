package lab02;

import java.io.*;
import java.util.Scanner;

public class Polynomial {

    double[] coefficients; // null
    int [] exponents;

    public Polynomial() {
        coefficients = new double[0];
        exponents = new int[0];
    }

    public Polynomial(File file) throws IOException {
        // BufferedReader reader = new BufferedReader(new FileReader(file));
        // String line = reader.readLine();
        // reader.close();

        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        scanner.close();

        // line => "5-3x2+7x8"
        // terms => ["5", "-3x2", "7x8"]

        // insert a '+' sign in-front of every '-' sign
        line = line.replace("-", "+-");
        String[] terms = line.split("\\+");

        this.coefficients = new double[terms.length];
        this.exponents = new int[terms.length];

        for (int i = 0; i < terms.length; i++) {          //            ceo   exp
            String[] ceo_exp = terms[i].split("x"); // "-3x2" => ["-3", "2"]
            this.coefficients[i] = Double.parseDouble(ceo_exp[0]);
            this.exponents[i] = (ceo_exp.length == 1) ? 0 : Integer.parseInt(ceo_exp[1]);
        }
    }

    public void saveToFile(String filename) throws IOException {
        // TODO: use printStream ?
        FileWriter writer = new FileWriter(filename);

        String line = "";

//        String line = "" + this.coefficients[0] + ((this.exponents[0] == 0) ? "" : this.exponents[0]);
//        for (int i = 1; i < this.coefficients.length; i++) {
//            // TODO: handle .0, +-
//            line += "+" + this.coefficients[i] + "x" + this.exponents[i];
//        }

        for (int i = 0; i < this.coefficients.length; i++) {
            // TODO: 可以檢查 exponents 是否是 0, 單獨處理一下
            //       可以檢查 coefficient 是否 .0, 處理一下 (parseInt)
            //       有 '-', 處理一下 不要 concat '+' 號

            line += this.coefficients[i] + "x" + this.exponents[i] + "+";
        }

        line += "FUCK";

        line = line
                .replace("+-", "-")     //
                .replace("x0", "")      //
                //.replace("x1", "x")     // TODO: 問一下 這個要不要加
                .replace(".0", "")      //
                .replace("+FUCK", "");  // to remove the last '+' sign

        writer.write(line);
        writer.close();
    }

    public Polynomial(double[] coefficients, int[] exponents) {
        this.coefficients = coefficients;
        this.exponents = exponents;
    }

    public double evaluate(double x) {
        double res = 0.0;
        for (int i = 0; i < this.coefficients.length; i++)
            res += this.coefficients[i] * Math.pow(x, this.exponents[i]);
        return res;
    }

    public Polynomial add(Polynomial other) {

        if (this.exponents.length == 0)
            return new Polynomial(other.coefficients, other.exponents);
        if (other.exponents.length == 0)
            return new Polynomial(this.coefficients, this.exponents);

        // this  =>  6 - 2x + 5x3
        // other =>  5 + 6x4


        // => 4
        int max_exp = Math.max(this.exponents[this.exponents.length - 1],
                               other.exponents[other.exponents.length - 1]);

        // temp_coe => [0, 0, 0, 0, 0]
        double[] temp_coe = new double[max_exp + 1];

        // temp_coe => [6, -2, 0, 5, 0]
        for (int i = 0; i < this.coefficients.length; i++)
            temp_coe[this.exponents[i]] += this.coefficients[i];

        // temp_coe => [11, -2, 0, 5, 6]
        for (int i = 0; i < other.coefficients.length; i++)
            temp_coe[other.exponents[i]] += other.coefficients[i];

        // count how many non-zero coefficients
        int len = 0;
        for (int i = 0; i < temp_coe.length; i++)
            if (temp_coe[i] != 0)
                len++;

        double[] new_coe = new double[len];
        int[] new_exp = new int[len];

        // new_coe => [11, -2, 5, 6]
        // new_exp => [0,   1, 3, 4]
        int j = 0;
        for (int i = 0; i < temp_coe.length; i++) {
            if (temp_coe[i] != 0) {
                new_coe[j] = temp_coe[i];
                new_exp[j] = i;
                j++;
            }
        }

        return new Polynomial(new_coe, new_exp);
    }

    public Polynomial multiply(Polynomial other) {
        if (this.exponents.length == 0)
            return new Polynomial(other.coefficients, other.exponents);
        if (other.exponents.length == 0)
            return new Polynomial(this.coefficients, this.exponents);

        // this  =>  6 - 2x + 5x3
        // other =>  5 + 6x4


        int max_exp = Math.max(this.exponents[this.exponents.length - 1],
                other.exponents[other.exponents.length - 1]);

        double[] temp_coe = new double[max_exp + 1];

        // temp_coe => [6, -2, 0, 5, 0]
        for (int i = 0; i < this.coefficients.length; i++)
            temp_coe[this.exponents[i]] = this.coefficients[i];

        // temp_coe => [30, -2, 0, 5, 6]
        for (int i = 0; i < other.coefficients.length; i++) {
            if (temp_coe[other.exponents[i]] == 0)
                temp_coe[other.exponents[i]] = other.coefficients[i];
            else
                temp_coe[other.exponents[i]] *= other.coefficients[i];
        }

        // count how many non-zero coefficients
        int len = 0;
        for (int i = 0; i < temp_coe.length; i++)
            if (temp_coe[i] != 0)
                len++;

        double[] new_coe = new double[len];
        int[] new_exp = new int[len];

        // new_coe => [11, -2, 5, 6]
        // new_exp => [0,   1, 3, 4]
        int j = 0;
        for (int i = 0; i < temp_coe.length; i++) {
            if (temp_coe[i] != 0) {
                new_coe[j] = temp_coe[i];
                new_exp[j] = i;
                j++;
            }
        }

        return new Polynomial(new_coe, new_exp);
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0.0;
    }


}
