package com.example.nizam.app.data.mapper.helper;

public interface EntityWithExtraValueMapper<I, E, O> {

    O map(I input, E extraValue);

}

