package lab3;

import java.util.List;

public abstract class SpecialNumber {

    public abstract SpecialNumber add(SpecialNumber other) throws Lab3Exception;

    public abstract SpecialNumber divideByInt(int n) throws Lab3Exception;

    /**
     * blah blah blah ....
     * @param numbers list of SpecialNumber
     * @return a SpecialNumber that represent the average
     * @throws Lab3Exception
     */
    public static SpecialNumber computeAverage(List<SpecialNumber> numbers) throws Lab3Exception {
        if (numbers == null || numbers.size() == 0)
            throw new Lab3Exception("List cannot be empty");

        SpecialNumber total = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++)
            total = total.add(numbers.get(i));

        return total.divideByInt(numbers.size());
    }
}
