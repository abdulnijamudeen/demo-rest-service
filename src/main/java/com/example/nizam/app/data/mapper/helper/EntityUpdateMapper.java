package com.example.nizam.app.data.mapper.helper;

public interface EntityUpdateMapper<I, O> {

    O remap(I input, O output);

}
