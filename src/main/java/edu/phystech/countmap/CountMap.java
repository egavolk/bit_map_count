package edu.phystech.countmap;

import java.util.Map;

public interface CountMap<E> {
    void add(E key);

    int getCount(E key);

    void addAll(CountMap<? extends E> source);

    void copyTo(CountMap<? super E> destination);

    Map<E, Integer> asMap();
}
