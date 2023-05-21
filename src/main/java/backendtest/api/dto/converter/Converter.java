package backendtest.api.dto.converter;

public interface Converter<A,B> {

    B convert(A object);

}
