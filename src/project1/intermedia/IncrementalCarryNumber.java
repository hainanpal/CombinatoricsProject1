package project1.intermedia;

/**
 * Created by zhang tingjian on 2021/10/6.
 */
public class IncrementalCarryNumber extends IntermediaNumber {
    public IncrementalCarryNumber(int length) {
        super(length);
    }

    @Override
    public void increment() {
        numbers[length - 1] += 1;
        for (int i = length - 1; i >= 0; i--) {
            if (numbers[i] >= length - i + 1) {
                numbers[i - 1] += 1;
                numbers[i] = 0;
            } else {
                break;
            }
        }
    }

    @Override
    public boolean isBiggest() {
        for (int i = 0; i < length; i++) {
            if (numbers[i] != length - i) {
                return false;
            }
        }
        return true;
    }
}
