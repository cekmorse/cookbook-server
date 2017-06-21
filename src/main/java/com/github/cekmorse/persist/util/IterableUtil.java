package com.github.cekmorse.persist.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keith on 6/20/17.
 */
public class IterableUtil
{
    public static <T> List<T> toList(Iterable<T> aItems) {
        //handle null
        if (aItems == null) {
            return null;
        }

        //handle already a list
        if (aItems instanceof List) {
            return (List<T>) aItems;
        }

        //iterate and convert
        List<T> items = new ArrayList<T>();
        for(T item : aItems) {
            items.add(item);
        }
        return items;
    }
}
