package ch.hslu.ad.sw13.matrix;

import ch.hslu.ad.sw13.model.RailwayNetInterface;

public final class Demo {

    public static void main(String args[]) {
        RailwayNetInterface railwayNet = RailwayNetWithMatrix.createForRotkreuz();
        System.out.println(railwayNet);
    }
}
