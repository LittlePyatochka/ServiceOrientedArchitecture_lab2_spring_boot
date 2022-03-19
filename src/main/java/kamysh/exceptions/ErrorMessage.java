package kamysh.exceptions;

public class ErrorMessage {
    public static String INVALID_XML = "Invalid XML in request body";
    public static String WRONG_ID_FORMAT = "Field 'id' must be bigger than 0";
    public static String MISSING_NAME = "Field 'name' must be specified in request body";
    public static String MISSING_COORDINATES = "Field 'coordinates' must be specified in request body";
    public static String MISSING_HEALTH_COUNT = "Field 'health' must be specified in request body";
    public static String MISSING_HEART_COUNT = "Field 'heartCount' must be specified in request body";
    public static String MISSING_ID = "Field 'id' must be specified in request body";
    public static String INVALID_HEALTH_VALUE = "Field 'health count' must be integer and bigger than 0";
    public static String INVALID_NAME_VALUE = "Length of field 'name' must be bigger than 0";
    public static String WRONG_COORDINATES_FORMAT = "Field 'coordinates' must be integer";
    public static String INVALID_COORDINATES_FORMAT = "Field 'coordinates' must be bigger than 0";
    public static String INVALID_HEART_COUNT_VALUE = "Field 'heartCount' must be bigger than 3";
    public static String WRONG_CATEGORY_FORMAT = "Field 'category' must be one of expected value. Check documentation for details";
    public static String WRONG_CHAPTER_FORMAT = "Field 'chapter' must be integer";
    public static String INVALID_CHAPTER_FORMAT = "Field 'chapter' must be be bigger than 0";
    public static String OBJECT_NOT_FOUND = "Object not found";
    public static String WRONG_LOYAL_FORMAT = "Field 'loyal' must be boolean";
    public static String INVALID_COUNT_VALUE = "Parameter 'count' must be bigger than 0";
    public static String WRONG_COUNT_FORMAT = "Parameter 'count' must be integer";
    public static String INVALID_PAGE_VALUE = "Parameter 'page' must be bigger than 0";
    public static String WRONG_PAGE_FORMAT = "Parameter 'page' must be integer";
    public static String WRONG_LOYAL_FILTER_FORMAT = "Field 'loyal' in filter must be boolean";
    public static String PERSON_NOT_FOUND = "Person not found";
    public static String COORDINATES_NOT_FOUND = "Coordinates not found";
    public static String SPACE_MARINE_NOT_FOUND = "Space Marine not found";
    public static String CHAPTER_NOT_FOUND = "Chapter not found";
}
