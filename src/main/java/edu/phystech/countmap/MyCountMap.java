package edu.phystech.countmap;

import java.util.HashMap;
import java.util.Map;

public class MyCountMap<E> implements CountMap<E> {

    private final Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E key) {
        int cur = map.getOrDefault(key, 0);
        map.put(key, cur + 1);
    }

    public void add(E key, int count) {
        int cur = map.getOrDefault(key, 0);
        map.put(key, cur + count);
    }

    @Override
    public void remove(E key) {
        int cur = map.getOrDefault(key, 0);
        if (cur == 0) {
            return;
        }
        if (cur == 1) {
            map.remove(key);
            return;
        }
        map.put(key, cur - 1);
    }

    @Override
    public int getCount(E key) {
        return map.getOrDefault(key, 0);
    }

    @Override
    public void addAll(CountMap<? extends E> source) {
        for (Map.Entry<? extends E, Integer> entry : source.toMap().entrySet()) {
            add(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<? super E, Integer> curMap) {
        curMap.clear();
        curMap.putAll(map);
    }

    @Override
    public int size() {
        return map.size();
    }
}
