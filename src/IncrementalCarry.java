/**
 * Created by zhang tingjian on 2021/9/30.
 */
public final class IncrementalCarry extends PermGenerator {

    public IncrementalCarry(int len) {
        super(len);
    }

    @Override
    protected boolean isFinished() {
        return isBiggestIC();
    }

    @Override
    protected void toNextStatus() {
        addOneByIC();
    }

    @Override
    protected int[] convert() {
        int[] ret = new int[sLen + 1];
        boolean[] flags = new boolean[sLen + 1];
        for (int i = 0; i < sLen; i++) {
            int digit = sLen + 1 - i;
            int count = 0;
            for (int j = flags.length - 1; j >= 0; j--) {
                if (count == status[i] && !flags[j]) {
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
        IncrementalCarry ic = new IncrementalCarry(3);
        ic.generate();
    }

}
