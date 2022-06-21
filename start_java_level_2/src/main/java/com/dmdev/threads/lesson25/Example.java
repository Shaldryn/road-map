package com.dmdev.threads.lesson25;

import java.util.ArrayList;
import java.util.List;

public class Example {

    private List<Integer> list;

    public Example(List<Integer> list) {
//        this.list = List.copyOf(list);
        this.list = list;
    }

    public List<Integer> getList() {
        return new ArrayList<>(list);
//        return list;
    }
}
