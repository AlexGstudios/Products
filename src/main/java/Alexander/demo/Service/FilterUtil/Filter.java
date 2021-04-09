package Alexander.demo.Service.FilterUtil;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Filter {

    public String[] editElement(Object obj){

        final BeanWrapper wrappedObj = new BeanWrapperImpl(obj);
        return Stream.of(wrappedObj.getPropertyDescriptors()).map(FeatureDescriptor::getName)
        .filter(propertyName -> wrappedObj.getPropertyValue(propertyName) == null).toArray(String[]::new);
    }
}
