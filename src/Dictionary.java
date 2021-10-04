/**
 * Created by zhang tingjian on 2021/9/29.
 */
public final class Dictionary {

    private final int[] status;
    private final int len;

    public Dictionary(int len) {
        if (len <= 1) {
            throw new IllegalArgumentException("len must greater than one!");
        }
        status = new int[len];
        this.len = len;
        reset();
    }

    public void reset() {
        for (int i = 0; i < len; i++) {
            status[i] = i + 1;
        }
    }

    private boolean isFinished() {
        for (int i = 0; i < len - 1; i++) {
            if (status[i] < status[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void toNextStatus() {
        for (int i = len - 1; i > 0; i--) {
            if (status[i] > status[i - 1]) {
                //find idx that idx = index of min{status[k] | status[k] > status[i-1]}, k belongs to [i, len-1]
                int min = len + 1;
                int idx = -1;
                for (int k = i; k < len; k++) {
                    if (status[k] > status[i-1] && status[k] < min) {
                        min = status[k];
                        idx = k;
                    }
                }
                //swap status[i-1] and status[idx]
                int tmp = status[i - 1];
                status[i - 1] = status[idx];
                status[idx] = tmp;
                //reverse status[i:len-1]
                for (int j = 0; j < (len - i) / 2; j++) {
                    int tmp1 = status[i + j];
                    status[i + j] = status[len - 1 - j];
                    status[len - 1 - j] = tmp1;
                }
                break;
            }
        }
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
        for (int i : status) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Dictionary d = new Dictionary(3);
        d.generate();
    }
}
