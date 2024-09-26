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
}
