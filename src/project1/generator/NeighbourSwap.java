package project1.generator;

import project1.intermedia.DecrementalCarryNumber;
import project1.intermedia.IntermediaNumber;

/**
 * Created by zhang tingjian on 2021/10/3.
 */
public final class NeighbourSwap extends PermGenerator {

    public NeighbourSwap(int len) {
        super(len);
    }

    @Override
    protected IntermediaNumber initIntermedia(int len) {
        return new DecrementalCarryNumber(len);
    }

    @Override
    protected int[] convert() {
        int[] ret = new int[iLen + 1];
        boolean[] flags = new boolean[iLen + 1];
        for (int i = iLen - 1; i >= 0; i--) {
            int digit = i + 2;
            boolean goLeft = digit % 2 == 0 ? (digit == 2 || (intermedia.get(i - 1) + intermedia.get(i - 2)) % 2 == 0) :
                    intermedia.get(i - 1) % 2 == 0;
            int count = 0;
            if (goLeft) {
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
            } else {
                for (int j = 0; j < flags.length; j++) {
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
