package lab2;

import java.io.IOException;
import java.nio.file.Path;

public interface Serializer<T> {
    void serialize(T entity, Path filePath) throws IOException;
    T deserialize(Path filePath) throws IOException;
}
