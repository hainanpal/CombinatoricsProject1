package project1.generator;

import project1.intermedia.IncrementalCarryNumber;
import project1.intermedia.IntermediaNumber;

/**
 * Created by zhang tingjian on 2021/9/30.
 */
public final class IncrementalCarry extends PermGenerator {

    public IncrementalCarry(int len) {
        super(len);
    }

    @Override
    protected IntermediaNumber initIntermedia(int len) {
        return new IncrementalCarryNumber(len);
    }

    @Override
    protected int[] convert() {
        int[] ret = new int[iLen + 1];
        boolean[] flags = new boolean[iLen + 1];
        for (int i = 0; i < iLen; i++) {
            int digit = iLen + 1 - i;
            int count = 0;
            for (int j = flags.length - 1; j >= 0; j--) {
                if (count == intermedia.get(i) && !flags[j]) {
                    ret[j] = digit;
                    flags[j] = true;
                    break;
                }
                if (!flags[j]) {
                    count ++;
                }
            }
        }
        for (int i = 0; i < flags.length; i++) {
            if (!flags[i]) {
                ret[i] = 1;
                break;
            }
        }
        return ret;
    }

}
