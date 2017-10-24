package me.yufan.elasticsearch.common.json.esjson.core.deserializer;


import me.yufan.elasticsearch.common.json.JSONException;

import java.lang.reflect.Type;

public class EnumDeserializer implements Deserializer {

    private Class<?> enumType;

    public EnumDeserializer(Class<?> enumType) {
        this.enumType = enumType;
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialize(Object object, Type type) {
        if (object == null) {
            return null;
        }
        if (object.getClass().isEnum()) {
            return (T) object;
        }

        if (!(object instanceof String)) {
            throw new JSONException("enum object:[" + object + "] is invalid");
        }

        return (T) Enum.valueOf((Class<Enum>) enumType, object.toString());
    }
}
