/**
 * Created by zhang tingjian on 2021/9/30.
 */
public class IncrementalCarry {

    private final int[] status;
    private final int sLen; //length of status, equals to length of sequence minus one

    public IncrementalCarry(int len) {
        if (len <= 1) {
            throw new IllegalArgumentException("len must greater than one!");
        }
        status = new int[len - 1];
        this.sLen = len - 1;
        reset();
    }

    public void reset() {
        for (int i = 0; i < sLen; i++) {
            status[i] = 0;
        }
    }

    private boolean isFinished() {
        for (int i = 0; i < sLen; i++) {
            if (status[i] != sLen - i) {
                return false;
            }
        }
        return true;
    }

    private void toNextStatus() {
        status[sLen - 1] += 1;
        for (int i = sLen - 1; i >= 0; i--) {
            if (status[i] >= sLen - i + 1) {
                status[i - 1] += status[i] / (sLen - i + 1);
                status[i] %= sLen - i + 1;
            } else {
                break;
            }
        }
    }

    private int[] convert() {
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

    public void generate() {
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

    private static void bar(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IncrementalCarry ic = new IncrementalCarry(3);
        ic.generate();
    }

}
