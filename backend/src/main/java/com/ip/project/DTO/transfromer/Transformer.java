package com.ip.project.DTO.transfromer;

/**
 * Created by JACK on 5/13/2017.
 */
public interface Transformer<T1, T2> {
    T1 toModel (T2 object);
    T2 toDTO (T1 object);
}