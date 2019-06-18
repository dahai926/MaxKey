package org.maxkey.client.http;

import org.maxkey.client.utils.HttpEncoder;

public class Parameter implements Comparable<Parameter> {

    private final String key;
    private final String value;

    public Parameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String asUrlEncodedPair() {
        return HttpEncoder.encode(key).concat("=").concat(HttpEncoder.encode(value));
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Parameter)) {
            return false;
        }

        final Parameter otherParam = (Parameter) other;
        return otherParam.getKey().equals(key) && otherParam.getValue().equals(value);
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return key.hashCode() + value.hashCode();
    }

    @Override
    public int compareTo(Parameter parameter) {
        final int keyDiff = key.compareTo(parameter.getKey());

        return keyDiff == 0 ? value.compareTo(parameter.getValue()) : keyDiff;
    }
}