package com.suthar.rentel.domain.specification;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public interface Specification<T> {

    boolean isSatisfiedBy(T object);
}
