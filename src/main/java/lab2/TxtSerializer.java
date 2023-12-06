package lab2;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TxtSerializer<T> implements Serializer<T> {
    private final Class<T> objClass;

    public TxtSerializer(Class<T> objClass) {
        this.objClass = objClass;
    }

    @Override
    public void serialize(T entity, Path path) throws IOException {
        StringBuilder serializedData = new StringBuilder();

        Field[] fields = objClass.getDeclaredFields();

        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                try {
                    Object fieldValue = field.get(entity);
                    String fieldString = field.getName() + ":" + fieldValue + ",";
                    serializedData.append(fieldString);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        String data = serializedData.toString();
        Files.write(path, data.getBytes());
    }

    @Override
    public T deserialize(Path path) throws IOException {
        String data = new String(Files.readAllBytes(path));
        String[] fieldStrings = data.split(",");
        T obj = null;

        try {
            obj = objClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

        for (String fieldString : fieldStrings) {
            String[] parts = fieldString.split(":");
            String fieldName = parts[0];
            String fieldValue = parts[1];

            try {
                Field field = objClass.getDeclaredField(fieldName);
                field.setAccessible(true);

                Class<?> fieldType = field.getType();
                if (fieldType == int.class) {
                    field.set(obj, Integer.valueOf(fieldValue));
                } else if (fieldType == double.class) {
                    field.set(obj, Double.valueOf(fieldValue));
                } else if (fieldType == String.class) {
                    field.set(obj, fieldValue);
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return obj;
    }
}

