import java.util.List;

public class IncrementalCarry {

    private final int[] status;
    private final int sLen; //length of status, equals to length or sequence minus one

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

    private static void toNextStatus(int[] status) {
        int sLen = status.length;
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

    private static int[] convert1(int[] status) {
        int sLen = status.length;
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

    private static int[] convert(int[] status) {
        int sLen = status.length;
        int[] ret = new int[sLen + 1];
        boolean[] usedDigit = new boolean[sLen + 2];
        ret[0] = status[0] + 1;
        usedDigit[ret[0]] = true;
        for (int i = 1; i < sLen; i++) {
            int digit = status[i] + 1;
            boolean[] flags = new boolean[i];
            while (true) {
                boolean changed = false;
                for (int j = 0; j < i; j++) {
                    if (!flags[j] && ret[j] <= digit) {
                        digit ++;
                        flags[j] = true;
                        changed = true;
                    }
                }
                if (!changed) {
                    break;
                }
            }
            usedDigit[digit] = true;
            ret[i] = digit;
        }
        for (int i = 1; i < usedDigit.length; i++) {
            if (!usedDigit[i]) {
                ret[sLen] = i;
                break;
            }
        }
        return ret;
    }

    private static void bar(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //int[] status = {7, 2, 6, 4, 2, 3, 2, 1};
        int[] status = {6, 7, 3, 4, 2, 2, 2, 1};
        bar(convert1(status));
        toNextStatus(status);
        bar(status);
        bar(convert1(status));
    }

}
