package project1.generator;

import project1.intermedia.IncrementalCarryNumber;
import project1.intermedia.IntermediaNumber;

/**
 * Created by zhang tingjian on 2021/10/5
 */
public final class Dictionary extends PermGenerator {

    public Dictionary(int len) {
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
            int count = 0;
            for (int j = 0; j < flags.length; j++) {
                addCycleCounter();
                if (count == intermedia.get(i) && !flags[j]) {
                    ret[i] = j + 1;
                    flags[j] = true;
                    break;
                }
                if (!flags[j]) {
                    count ++;
                }
            }
        }
        for (int i = 0; i < flags.length; i++) {
            addCycleCounter();
            if (!flags[i]) {
                ret[iLen] = i + 1;
                break;
            }
        }
        return ret;
    }

}
