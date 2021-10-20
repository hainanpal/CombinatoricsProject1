package project1.generator;

import project1.intermedia.IntermediaNumber;
import project1.writer.SequenceWriter;

/**
 * Created by zhang tingjian on 2021/10/5
 */
public abstract class PermGenerator {

    protected final IntermediaNumber intermedia;
    protected final int iLen;
    private long outerCycleCounter = 0;
    private long innerCycleCounter = 0;

    public PermGenerator(int len) {
        if (len <= 1) {
            throw new IllegalArgumentException("length must be greater than one!");
        }
        iLen = len - 1;
        intermedia = initIntermedia(len - 1);
    }

    public final void reset() {
        intermedia.reset();
    }

    protected final void addCycleCounter() {
        innerCycleCounter ++;
    }

    protected abstract IntermediaNumber initIntermedia(int len);

    /**
     * convert intermedia number to permutation
     * @return permutation sequence
     */
    protected abstract int[] convert();

    /**
     * generate all permutations
     */
    public final void generate(SequenceWriter writer) {
        while (!intermedia.isBiggest()) {
            outerCycleCounter ++;
            writer.write(convert());
            intermedia.increment();
        }
        outerCycleCounter ++;
        writer.write(convert());
        System.out.printf("length: %d, total cycle: %d, average: %f%n", iLen + 1, innerCycleCounter,
                (double) innerCycleCounter / outerCycleCounter);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : convert()) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }
}
