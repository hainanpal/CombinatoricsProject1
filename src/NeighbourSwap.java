/**
 * Created by zhang tingjian on 2021/10/3.
 */
public final class NeighbourSwap extends PermGenerator {

    public NeighbourSwap(int len) {
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
        for (int i = sLen - 1; i >= 0; i--) {
            int digit = i + 2;
            boolean goLeft = digit % 2 == 0 ? (digit == 2 || (status[i - 1] + status[i - 2]) % 2 == 0) : status[i - 1] % 2 == 0;
            int count = 0;
            if (goLeft) {
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
            } else {
                for (int j = 0; j < flags.length; j++) {
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
        NeighbourSwap ns = new NeighbourSwap(3);
        ns.generate();
    }

}
