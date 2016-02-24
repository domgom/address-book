package com.gumtree.specification;

import java.util.List;

/**
 * Created by dgomez on 24/2/16.
 */
@FunctionalInterface
public interface Specification<T, U> {

    public U eval(List<T> list);
}
