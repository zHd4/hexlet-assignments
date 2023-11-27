package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private final String filepath;
    private Map<String, String> storage;

    public FileKV(String filepath, Map<String, String> storage) {
        this.filepath = filepath;
        this.storage = new HashMap<>(storage);

        Utils.writeFile(filepath, Utils.serialize(storage));
    }

    @Override
    public void set(String key, String value) {
        storage = Utils.unserialize(Utils.readFile(filepath));
        storage.put(key, value);

        Utils.writeFile(filepath, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        storage = Utils.unserialize(Utils.readFile(filepath));
        storage.remove(key);

        Utils.writeFile(filepath, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }
}
// END
