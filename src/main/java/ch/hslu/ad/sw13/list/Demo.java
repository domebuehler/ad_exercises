package ch.hslu.ad.sw13.list;

import ch.hslu.ad.sw13.model.RailwayNetInterface;

public class Demo {

    public static void main(String[] args) {
        RailwayNetInterface railwayNet = RailwayNetWithList.createForRotkreuz();
        System.out.println(railwayNet);
    }
}
