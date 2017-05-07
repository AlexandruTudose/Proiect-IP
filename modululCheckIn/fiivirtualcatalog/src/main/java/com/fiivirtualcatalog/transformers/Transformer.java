package com.fiivirtualcatalog.transformers;

public interface Transformer<T, T2> {
	T toModel (T2 object);
	T2 toDTO (T object);
}
