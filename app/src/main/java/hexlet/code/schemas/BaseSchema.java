package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> conditions = new HashMap<>();

    protected final void addCondition(String key, Predicate<T> predicate) {
        conditions.put(key, predicate);
    }

    public final boolean isValid(Object value) {
        return conditions.values().stream().allMatch(condition -> condition.test((T) value));
    }
}
