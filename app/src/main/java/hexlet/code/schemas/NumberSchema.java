package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        addCondition("positive", num -> num == null || num > 0);
        return this;
    }

    public NumberSchema required() {
        addCondition("required", num -> num != null);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCondition("range", num -> num != null && num >= min && num <= max);
        return this;
    }
}
