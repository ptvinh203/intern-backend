package com.ptvinh203.internbackend.util.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptvinh203.internbackend.util.constant.CommonConstant;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@NoArgsConstructor
public class CommonUtils {
    /*
     * Encoder and decoder
     */
    public static String encodeBase64(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String encodeObjectBase64(Object object) {
        var json = convertToJson(object);
        if (json == null) return null;
        return encodeBase64(json);
    }

    public static String decodeBase64(String encodedStr) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedStr);
        return new String(decodedBytes);
    }

    public static Object decodeObjectBase64(String encodedObject, Class<?> type) {
        var json = decodeBase64(encodedObject);
        return decodeJson(json, type);
    }

    public static String encodeUrlBase64(String url) {
        return Base64.getUrlEncoder().encodeToString(url.getBytes());
    }

    public static String decodeUrlBase64(String encodedUrl) {
        byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedUrl);
        return new String(decodedBytes);
    }

    /*
     * Json util
     */
    public static String convertToJson(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            mapper.setDateFormat(df);
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LogUtils.error("convertToJson", e);
            return null;
        }
    }

    public static <T> T decodeJson(String json, Class<T> type) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            mapper.setDateFormat(df);
            return mapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            LogUtils.error("decodeJson", e);
            return null;
        }
    }

    public static <T> T decodeJson(Map<String, Object> map, Class<T> type) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            mapper.setDateFormat(df);
            return mapper.convertValue(map, type);
        } catch (Exception e) {
            LogUtils.error("decodeJson", e);
            return null;
        }
    }

    public static <T> List<T> decodeJson(List<Map<String, Object>> array, Class<T> type) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            mapper.setDateFormat(df);
            return array.stream().map(e -> mapper.convertValue(e, type)).toList();
        } catch (Exception e) {
            LogUtils.error("decodeJson", e);
            return null;
        }
    }

    public static Map<String, Object> convertObjectToMap(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            mapper.setDateFormat(df);
            return mapper.convertValue(object, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            LogUtils.error("convertObjectToMap", e);
            return null;
        }
    }

    /*
     * String util
     */
    public static boolean isValidUuid(String str) {
        return isNotEmptyOrNullString(str) && Pattern.matches(CommonConstant.UUID_REGEX_PATTERN, str);
    }

    public static boolean isEmptyOrNullString(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotEmptyOrNullString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    /**
     * Convert snake case
     *
     * @param input string
     * @return String type snake case
     */
    public static String convertToSnakeCase(String input) {
        if (isEmptyOrNullString(input)) return input;
        return input.replaceAll("([^_A-Z])([A-Z])", "$1_$2").toLowerCase();
    }

    /**
     * Convert camel case
     *
     * @param input string
     * @return String type camel case
     */
    public static String convertToCamelCase(String input) {
        if (isEmptyOrNullString(input)) return input;
        return input.replaceAll(
                "_([a-z])",
                String.valueOf(
                        Character.toUpperCase(
                                input.charAt(input.indexOf("_") + 1))));
    }

    /**
     * Convert capital case
     */
    public static String convertToCapitalCase(String input) {
        if (isEmptyOrNullString(input)) return input;
        String snakeCase = convertToSnakeCase(input);
        String[] words = snakeCase.split("_");
        return Arrays.stream(words).map(
                word -> word.substring(0, 1).toUpperCase() + word.substring(1)
        ).reduce((a, b) -> a + " " + b).orElse("");
    }

    /*
     * List util
     */
    public static boolean isEmptyOrNullList(Object[] list) {
        return list == null || list.length == 0;
    }

    public static boolean isNotEmptyOrNullList(Object[] list) {
        return list != null && list.length > 0;
    }

    public static boolean isEmptyOrNullList(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotEmptyOrNullList(List<?> list) {
        return list != null && !list.isEmpty();
    }

    public static boolean isList(Object obj) {
        return obj != null && (obj.getClass().isArray() || obj instanceof Collection);
    }

    /*
     * Object util
     */
    public static <T> T getValueOrNull(T value) {
        return Objects.requireNonNullElse(value, null);
    }

    /*
     * YAML file util
     */
    public Map<String, Object> getValueFromYAMLFile(String nameFile) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(nameFile);
        return yaml.load(inputStream);
    }

    /*
     * Log util
     */
    public static void logError(String method, String uri, String error) {
        String content = "%s/%s - Error: %s".formatted(method, uri, error);
        LogUtils.error("LOG", content);
    }

    /*
     * Date time util
     */
    public static Timestamp getCurrentTimestamp() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    public static String convertTimestampToString(Timestamp timestamp, String format) {
        return new SimpleDateFormat(format).format(timestamp);
    }

    /*
     * Generate OTP
     */
    public static String generateOTP4Digits() {
        return generateDigitOTP(4);
    }

    public static String generate6DigitsOTP() {
        return generateDigitOTP(6);
    }

    public static String generate8DigitsOTP() {
        return generateDigitOTP(8);
    }

    public static String generateDigitOTP(int length) {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 1; i <= length; i++) {
            int randomNumber = random.nextInt(10);
            otp.append(randomNumber);
        }
        return otp.toString();
    }
}
