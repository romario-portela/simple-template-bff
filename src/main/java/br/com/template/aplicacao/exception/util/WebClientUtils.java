package br.com.template.aplicacao.exception.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

@Slf4j
@UtilityClass
public class WebClientUtils {

    public static String convertToUrlEncoded(Object obj) {
        var builder = new StringBuilder();
        var queryParamsMap = new LinkedHashMap<String, String>();
        var clazz = obj.getClass();
        try {
            for (Field f : clazz.getDeclaredFields()) {
                var fieldValue = f.get(obj);
                if (fieldValue != null) {
                    queryParamsMap.put(f.getName(), String.valueOf(fieldValue));
                }
            }
            queryParamsMap.forEach((key, value) -> {
                builder.append(key);
                builder.append("=");
                builder.append(value);
                builder.append("&");
            });
        } catch (Exception e) {
            log.error("Erro ao converter objeto para parâmetros de URL", e);
        }
        var queryString = builder.toString();
        return "?" + queryString.substring(0, queryString.length() - 1);
    }
}