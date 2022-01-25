package com.memes.model.dto.converters;

import com.memes.exception.ApplicationError;
import com.memes.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Converters {

    private final List<Converter> converters;

    public <T,R> R convert(T fromObject, Class<R> toObject) {
        for(Converter conv: converters) {
            if(conv.canHandle(fromObject.getClass(), toObject)) {
                return toObject.cast(conv.convert(fromObject));
            }
        }
        throw new ApplicationException(ApplicationError.CONVERTER_NOT_FOUND);
    }
}
