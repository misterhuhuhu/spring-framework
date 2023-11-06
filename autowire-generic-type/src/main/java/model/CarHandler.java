package model;

import annotation.CarQualifier;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarHandler {

    @Resource
    @Qualifier
    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() throws NoSuchFieldException {
        ResolvableType vehiclesType = ResolvableType.forField(getClass().getDeclaredField("vehicles"));
        System.out.println("TypeName:"+vehiclesType.getType().getTypeName());
        ResolvableType type = vehiclesType.getGeneric();
        System.out.println("getGenericType:"+type.getType().getTypeName());
        Class<?> aClass = type.resolve();
        System.out.println("aClass:"+aClass);
        return this.vehicles;
    }
}
