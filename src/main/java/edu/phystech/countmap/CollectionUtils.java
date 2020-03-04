package edu.phystech.countmap;

import java.util.*;

public class CollectionUtils {

    public static <E> void addAll(List<? extends E> source, List<? super E> destination) {
        //destination.addAll(source);
        for (E e : source) {
            destination.add(e);
        }
    }

    public static <E> List<E> newArrayList() {
        return new ArrayList<E>();
    }

    public static <E> int indexOf(List<? extends E> source, E e) {
        //source.indexOf(e);
        int i = 0;
        for (E curElem : source) {
            if (curElem.equals(e)) {
                return i;
            }
            ++i;
        }
    }

    public static<E> List<? extends E> limit(List<? extends E> source, int size) {
         return source.subList(0, size);
    }

    public static<E> void add(List<? super E> source, E e) {
        source.add(e);
    }

    public static<E> void removeAll(List<? super E> removeFrom, List<? extends E> c2) {
        //removeFrom.removeAll(c2);
        for (E e : c2) {
            removeFrom.remove(e);
        }
    }

    public static<E> boolean containsAll(List<? extends E> c1, List<? extends E> c2) {
        //return c1.containsAll(c2);
        int k = 0;
        for (E e : c2) {
            if (c1.contains(e))
                ++k;
        }
        return k == c2.size();
    }

    public static<E> boolean containsAny(List<? extends E> c1, List<? extends E> c2) {
        int k = 0;
        for (E e : c2) {
            if (c1.contains(e))
                ++k;
        }
        return k > 0;
    }

    public static<E> List<? extends E> range(List<? extends E> list, E min, E max) {
        return newArrayList();
    }

    public static<E> List<? extends E> range(List<? extends E> list, E min, E max, Comparator comparator) {
        return newArrayList();
    }
}