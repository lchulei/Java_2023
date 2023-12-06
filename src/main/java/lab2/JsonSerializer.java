package lab2;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class JsonSerializer<T> implements Serializer<T> {
    private final Gson gson;
    private final Class<T> objClass;

    public JsonSerializer(Class<T> objClass) {
        gson = new Gson();
        this.objClass = objClass;
    }

    @Override
    public void serialize(T entity, Path filePath) throws IOException {
        Files.writeString(filePath, gson.toJson(entity));
    }

    @Override
    public T deserialize(Path filePath) throws IOException {
        return gson.fromJson(Files.readString(filePath), objClass);
    }
}
