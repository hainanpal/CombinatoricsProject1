package project1;

import project1.generator.DecrementalCarry;
import project1.generator.Dictionary;
import project1.generator.IncrementalCarry;
import project1.generator.NeighbourSwap;

/**
 * Created by zhang tingjian on 2021/10/6.
 */
public class Main {

    public static void main(String[] args) {
        Dictionary d = new Dictionary(3);
        d.generate();

        IncrementalCarry ic = new IncrementalCarry(3);
        ic.generate();

        DecrementalCarry dc = new DecrementalCarry(3);
        dc.generate();

        NeighbourSwap ns = new NeighbourSwap(3);
        ns.generate();
    }

}
