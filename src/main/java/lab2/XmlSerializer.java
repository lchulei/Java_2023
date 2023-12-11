package lab2;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Path;

public class XmlSerializer<T> implements Serializer<T> {
    private final XmlMapper xmlMapper;
    private final Class<T> objClass;

    public XmlSerializer(Class<T> objClass) {
        xmlMapper = new XmlMapper();
        this.objClass = objClass;
    }

    @Override
    public void serialize(T entity, Path filePath) throws IOException {
        xmlMapper.writeValue(filePath.toFile(), entity);
    }

    @Override
    public T deserialize(Path filePath) throws IOException {
        return xmlMapper.readValue(filePath.toFile(), objClass);
    }
}

