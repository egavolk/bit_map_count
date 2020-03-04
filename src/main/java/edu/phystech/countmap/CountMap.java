package edu.phystech.countmap;

import java.util.Map;

public interface CountMap<E> {
    void add(E key);

    void remove(E key);

    int getCount(E key);

    void addAll(CountMap<? extends E> source);

    Map<E, Integer> toMap();

    void toMap(Map<? super E, Integer> map);

    int size();
}
