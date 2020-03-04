package edu.phystech.countmap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class MyCountMapTest {

    @Test
    public void add() {
        CountMap<Integer> map = new MyCountMap<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        Assert.assertEquals(2, map.getCount(5));
        Assert.assertEquals(1, map.getCount(6));
        Assert.assertEquals(3, map.getCount(10));
    }

    @Test
    public void remove() {
        CountMap<Integer> map = new MyCountMap<>();

        map.add(10);
        map.add(10);

        Assert.assertEquals(2, map.getCount(10));
        map.remove(3);
        Assert.assertEquals(2, map.getCount(10));
        map.remove(10);
        Assert.assertEquals(1, map.getCount(10));
        map.remove(10);
        Assert.assertEquals(0, map.getCount(10));
        map.remove(10);
        Assert.assertEquals(0, map.getCount(10));
    }

    @Test
    public void addAll() {
        CountMap<Integer> map1 = new MyCountMap<>();
        CountMap<Integer> map2 = new MyCountMap<>();

        map1.add(10);
        map1.add(10);
        map1.add(5);
        map2.add(5);
        map2.add(3);

        map1.addAll(map2);
        Assert.assertEquals(2, map1.getCount(10));
        Assert.assertEquals(2, map1.getCount(5));
        Assert.assertEquals(1, map1.getCount(3));
    }

    @Test
    public void toMap() {
        CountMap<Integer> map = new MyCountMap<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        Map<Integer, Integer> toMapRes = map.toMap();
        Map<Integer, Integer> mapExpected = new TreeMap<>();

        mapExpected.put(10, 3);
        mapExpected.put(5, 2);
        mapExpected.put(6, 1);
        Assert.assertEquals(mapExpected, toMapRes);
    }

    @Test
    public void ToMapDest() {
        CountMap<Integer> map = new MyCountMap<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        Map<Integer, Integer> toMapRes = new TreeMap<>();
        map.toMap(toMapRes);
        Map<Integer, Integer> mapExpected = new TreeMap<>();

        mapExpected.put(10, 3);
        mapExpected.put(5, 2);
        mapExpected.put(6, 1);
        Assert.assertEquals(mapExpected, toMapRes);
    }

    @Test
    public void size() {
        CountMap<Integer> map = new MyCountMap<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        Assert.assertEquals(3, map.size());
    }
}