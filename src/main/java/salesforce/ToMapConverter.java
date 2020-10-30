package salesforce;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Convert objects to Map
 */

public class ToMapConverter {


    public static Map toMap(Object obj) {
        ObjectMapper oMapper = new ObjectMapper();
        return oMapper.convertValue(obj, Map.class);
    }
}
