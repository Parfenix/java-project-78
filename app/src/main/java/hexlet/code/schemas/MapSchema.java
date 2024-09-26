package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        addCondition("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCondition("sizeof", map -> map.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        addCondition("shape", map -> {
            for (Map.Entry<String, BaseSchema<T>> entry : schemas.entrySet()) {
                var key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();

                if (!map.containsKey(key) || !schema.isValid(map.get(key))) {
                    return false;
                }
            }
            return true;
        });

        return this;
    }
}
