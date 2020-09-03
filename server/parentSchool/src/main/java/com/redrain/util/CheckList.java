package com.redrain.util;

import java.util.List;

public class CheckList {
    public static boolean isEmpty(List l) {
        return l == null || l.size() <= 0;
    }
}
