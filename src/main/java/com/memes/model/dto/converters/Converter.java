package com.memes.model.dto.converters;

public interface Converter <FROM, TO>{

    TO convert(FROM from);

    <T,R> boolean canHandle(Class<T> from, Class<R> to);
}
