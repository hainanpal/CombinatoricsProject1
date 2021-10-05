/**
 * Created by zhang tingjian on 2021/10/5
 */
public abstract class PermGenerator {

    protected final int[] status; //intermedia number
    protected final int sLen; //length of intermedia number, equals to length of sequence minus one

    public PermGenerator(int len) {
        if (len <= 1) {
            throw new IllegalArgumentException("len must greater than one!");
        }
        status = new int[len - 1];
        this.sLen = len - 1;
        reset();
    }

    public final void reset() {
        for (int i = 0; i < sLen; i++) {
            status[i] = 0;
        }
    }

    /**
     * @return if intermedia number is the biggest incremental carry number
     */
    protected final boolean isBiggestIC() {
        for (int i = 0; i < sLen; i++) {
            if (status[i] != sLen - i) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return if intermedia number is the biggest decremental carry number
     */
    protected final boolean isBiggestDC() {
        for (int i = 0; i < sLen; i++) {
            if (status[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * add one to intermedia number, using incremental carry
     */
    protected final void addOneByIC() {
        status[sLen - 1] += 1;
        for (int i = sLen - 1; i >= 0; i--) {
            if (status[i] >= sLen - i + 1) {
                status[i - 1] += 1;
                status[i] = 0;
            } else {
                break;
            }
        }
    }

    /**
     * add one to intermedia number, using decremental carry
     */
    protected final void addOneByDC() {
        status[sLen - 1] += 1;
        for (int i = sLen - 1; i >= 0; i--) {
            if (status[i] >= i + 2) {
                status[i - 1] += 1;
                status[i] = 0;
            } else {
                break;
            }
        }
    }

    /**
     * convert intermedia number to permutation
     * @return permutation sequence
     */
    protected abstract int[] convert();

    /**
     * @return if generator should stop
     */
    protected abstract boolean isFinished();

    /**
     * just add one to intermedia number, using precise carry
     */
    protected abstract void toNextStatus();

    /**
     * generate all permutations
     */
    public final void generate() {
        int total = 0;
        while (!isFinished()) {
            System.out.println(this);
            toNextStatus();
            total ++;
        }
        System.out.println(this);
        total ++;
        System.out.println(total + " sequences in total");
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
