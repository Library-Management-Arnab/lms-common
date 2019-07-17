package com.lms.svc.common.transform;

public interface Transformer<T, R> {
	R transform(T t);

	T reverseTransform(R r);
}
