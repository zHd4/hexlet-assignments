package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> nullFields = new ArrayList<>();

        try {
            for (Field field : address.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(NotNull.class)) {
                    field.setAccessible(true);

                    if (field.get(address) == null) {
                        nullFields.add(field.getName());
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return nullFields;
    }
}
// END
