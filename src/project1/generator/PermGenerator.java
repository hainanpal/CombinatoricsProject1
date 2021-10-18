package project1.generator;

import project1.intermedia.IntermediaNumber;
import project1.writer.SequenceWriter;

/**
 * Created by zhang tingjian on 2021/10/5
 */
public abstract class PermGenerator {

    protected final IntermediaNumber intermedia;
    protected final int iLen;

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
            writer.write(convert());
            intermedia.increment();
        }
        writer.write(convert());
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
