/**
 * Created by zhang tingjian on 2021/10/3.
 */
public final class DecrementalCarry extends PermGenerator {

    public DecrementalCarry(int len) {
        super(len);
    }

    @Override
    protected boolean isFinished() {
        return isBiggestDC();
    }

    @Override
    protected void toNextStatus() {
        addOneByDC();
    }

    @Override
    protected int[] convert() {
        int[] ret = new int[sLen + 1];
        boolean[] flags = new boolean[sLen + 1];
        for (int i = 0; i < sLen; i++) {
            int digit = sLen + 1 - i;
            int count = 0;
            for (int j = flags.length - 1; j >= 0; j--) {
                if (count == status[sLen - 1 - i] && !flags[j]) {
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

    public static void main(String[] args) {
        DecrementalCarry dc = new DecrementalCarry(3);
        dc.generate();
    }

}
