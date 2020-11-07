package com.nextleap.itr.utilities;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Class: JsonHelper
Description: Provides methods for JSON operations
*/
public class JsonHelper {
    private static ObjectMapper mapper = null;

    static {
        mapper = new ObjectMapper();
        defaultConfiguration(mapper);
    }

    private static void defaultConfiguration(ObjectMapper m) {
        //make the parser more forgiving w.r.t JSON standard
        m.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        m.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    /**
     * Return the mapper object. As far as possible a single instance
     * should be used for performance reasons.
     */
    public static ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * Parse a JSON string to a JsonNode object
     */
    public static JsonNode parse(String jsonString)
            throws IOException {
        return mapper.readTree(jsonString);
    }

    /**
     * Parsing a json string into a POJO directly. If you are
     * using an inner class POJO, make sure it is declared as static.
     */
    public static <T> T parse(String jsonString, Class<T> clazz)
            throws IOException {
        return mapper.readValue(jsonString, clazz);
    }

    /**
     * Parsing a json file into a POJO directly. This is to be used
     * when the returned value is a genericised type like List<User>.
     * <p>
     * If you are using an inner class POJO, make sure it is declared
     * as static.
     */
    public static <T> T parse(String jsonString, TypeReference<T> clazz)
            throws IOException {
        return mapper.readValue(jsonString, clazz);
    }

    /**
     * Create an ObjectNode to construct the JSON using the tree model.
     */
    public static ObjectNode createObjectNode() {
        return mapper.createObjectNode();
    }

    /**
     * Create an ArrayNode to construct the JSON using the tree model.
     */
    public static ArrayNode createArrayNode() {
        return mapper.createArrayNode();
    }

    /**
     * Convert the JSON tree format into a json string.
     */
    public static String toString(JsonNode n)
            throws JsonProcessingException {
        return mapper.writeValueAsString(n);
    }

    /**
     * Convert the POJO into a json string.
     */
    public static String toString(Object obj)
            throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    /**
     * Convert the JSON tree format into a json string with pretty printing.
     */
    public static String toStringPretty(JsonNode n)
            throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(n);
    }

    /**
     * Convert the POJO into a json string with pretty printing.
     */
    public static String toStringPretty(Object obj)
            throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    /**
     * Convert the given JsonNode to ObjectNode.
     */
    public static ObjectNode toObjectNode(JsonNode n) {
        return convert(n, ObjectNode.class);
    }

    /**
     * Convert the given JsonNode to ArrayNode.
     */
    public static ArrayNode toArrayNode(JsonNode n) {
        return convert(n, ArrayNode.class);
    }

    /**
     * Convert from a JSON tree representation to POJO
     * identified by the Class.
     * <p>
     * This is to be used when the returned value is a
     * genericised type like List<User>.
     */
    public static <T> T convert(JsonNode n, TypeReference<T> clazz) {
        return mapper.convertValue(n, clazz);
    }

    /**
     * Convert from a JSON tree representation to POJO
     * identified by the Class. This can also be used to
     * convert from JsonNode to ObjectNode.
     */
    public static <T> T convert(JsonNode n, Class<T> clazz) {
        return mapper.convertValue(n, clazz);
    }

    /**
     * Convert an object to the JSON tree form
     */
    @SuppressWarnings("rawtypes")
    public static JsonNode convert(Object o) {
        if (o instanceof List) {
            return convert((List) o);
        }
        if (o instanceof Set) {
            return convert((Set) o);
        }
        if (o instanceof Map) {
            return convert((Map) o);
        }
        if (o instanceof JsonNode) {
            return (JsonNode) o;
        }
        return mapper.convertValue(o, ObjectNode.class);
    }

    /**
     * Convert a Map to the JSON tree form
     */
    public static ObjectNode convert(@SuppressWarnings("rawtypes") Map m) {
        return mapper.convertValue(m, ObjectNode.class);
    }

    /**
     * Convert a List to the JSON tree form
     */
    public static ArrayNode convert(@SuppressWarnings("rawtypes") List l) {
        return mapper.convertValue(l, ArrayNode.class);
    }

    /**
     * Convert a Set to the JSON tree form
     */
    public static ArrayNode convert(@SuppressWarnings("rawtypes") Set s) {
        return mapper.convertValue(s, ArrayNode.class);
    }

    
	public static <T> T readFile(File f, Class<T> clazz) 
			throws JsonParseException, JsonMappingException, IOException
		{
			return mapper.readValue(f, clazz);
		}
		
		/**
		 * Reading a json file into a POJO directly. This is to be used
		 * when the returned value is a genericised type like List<User>.
		 * 
		 * If you are using an inner class POJO, make sure it is declared 
		 * as static.
		 */
		public static <T> T readFile(File f, TypeReference<T> clazz) 
			throws JsonParseException, JsonMappingException, IOException
		{
			return mapper.readValue(f, clazz);
		}

		/**
		 * Reading a json file into a JsonNode representation. This is 
		 * used when there is no POJO and the reading will be done manually.
		 */
		public static JsonNode readFile(File f) 
			throws JsonParseException, JsonMappingException, IOException
		{
			return mapper.readTree(f);
		}

		public static void writeToFile(File f, JsonNode jNode) 
				throws JsonGenerationException, JsonMappingException, IOException
			{
				mapper.writeValue(f, jNode);
			}


}
