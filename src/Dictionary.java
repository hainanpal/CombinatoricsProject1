/**
 * Created by zhang tingjian on {DATE}
 */
public final class Dictionary extends PermGenerator {

    public Dictionary(int len) {
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
            int count = 0;
            for (int j = 0; j < flags.length; j++) {
                if (count == status[i] && !flags[j]) {
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
            if (!flags[i]) {
                ret[sLen] = i + 1;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Dictionary d = new Dictionary(3);
        d.generate();
    }

}
