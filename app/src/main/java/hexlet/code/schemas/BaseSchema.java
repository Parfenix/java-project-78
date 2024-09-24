package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> conditions = new HashMap<>();

    protected void addCondition(String key, Predicate<T> predicate) {
        conditions.put(key, predicate);
    }

    public boolean isValid(T value) {
        return conditions.values().stream().allMatch(condition -> condition.test(value));
    }
}
