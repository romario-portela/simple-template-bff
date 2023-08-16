package br.com.template.aplicacao.exception.util;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

@UtilityClass
public class NumberUtilsCustom extends org.springframework.util.NumberUtils {

    public static boolean isValid(Double number) {
        if (number == null) {
            return false;
        }
        return !number.isNaN() && !number.isInfinite();
    }

    public static boolean isValid(Double... numbers) {
        if (numbers == null) {
            return false;
        }
        for (Double number : numbers) {
            if (!isValid(number)) {
                return false;
            }
        }
        return true;
    }

    public static BigDecimal getBigDecimal(Float value) {
        return solveScale(BigDecimal.valueOf(value), 2);
    }

    public static BigDecimal solveScale(BigDecimal value, Integer precision) {
        return value.setScale(precision, RoundingMode.HALF_EVEN);
    }
}