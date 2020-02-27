package edu.phystech.countmap;

import java.util.HashMap;
import java.util.Map;

public class MyCountMap<E> implements CountMap<E> {

    private final Map<E, Integer> map = new HashMap<>();

    public void add(E key) {
        int cur = map.getOrDefault(key, 0);
        map.put(key, cur + 1);
    }

    public int getCount(E key) {
        return map.getOrDefault(key, 0);
    }

    public void addAll(CountMap<? extends E> source) {
        for (E e : map.keySet()) {
            add(e);
        }
    }

    public void copyTo(CountMap<? super E> destination) {
        for (Map.Entry<E, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                destination.add(entry.getKey());
            }
        }
    }

    public Map<E, Integer> asMap() {
        return map;
    }
}
