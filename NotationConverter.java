package com.company;

import java.util.Map;

public class NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
        Map<String, Integer> map = Map.of(
                "I", 1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D", 500,
                "M", 1000
        );
        int result = 0;
        char[] roman = romanNotation.toCharArray();
        for (char c : roman) {
            if (c == 'I' || c == 'V' || c == 'X' || c == 'L' || c == 'C' || c == 'D' || c == 'M') {
            } else
                throw new InvalidValueException("String must contain only valid roman numerals [I, V, X, L, C, D, M]");
        }
        if (roman.length == 0)
            throw new InvalidValueException("String must contain only valid roman numerals [I, V, X, L, C, D, M]");
        else if (roman.length == 1)
            return map.get(String.valueOf(roman[0]));
        else {
            for (int i = 0; i < roman.length; i++) {
                if (i == ((roman.length) - 1)) {
                    result += map.get(String.valueOf(roman[i]));
                } else if (map.get(String.valueOf(roman[i])) < map.get(String.valueOf(roman[i + 1]))) {
                    result += (map.get(String.valueOf(roman[i + 1])) - (map.get(String.valueOf(roman[i]))));
                    i += 1;
                } else result += map.get(String.valueOf(roman[i]));
            }
        }


        return result;
    }

    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(String message) {
            super(message);
        }
    }
}
