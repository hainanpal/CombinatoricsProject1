package project1.intermedia;

/**
 * Created by zhang tingjian on 2021/10/6.
 */
public abstract class IntermediaNumber {

    protected final int[] numbers;
    protected final int length;

    public IntermediaNumber(int length) {
        numbers = new int[length];
        this.length = length;
    }

    /**
     * add one to intermedia number
     */
    public abstract void increment();

    /**
     * @return if this is the biggest intermedia number
     */
    public abstract boolean isBiggest();

    /**
     * @param i index, base 0
     * @return i-th digit of intermedia number, 0 refers to the highest digit
     */
    public final int get(int i) {
        return numbers[i];
    }

}
