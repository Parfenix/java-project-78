package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCondition("required", StringUtils::isNotEmpty);
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCondition("minLength", str -> str != null && str.length() >= minLength);
        return this;
    }

    public StringSchema contains(String subString) {
        addCondition("contains", str -> str != null && str.contains(subString));
        return this;
    }
}
