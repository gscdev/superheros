package com.gsc.superheros.data.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMapper<R, T> {

    public List<R> transform(List<T> list) {
        List<R> resultList = new ArrayList<>();
        for (T item : list) {
            resultList.add(transform(item));
        }
        return resultList;
    }

    abstract R transform(T item);
}
