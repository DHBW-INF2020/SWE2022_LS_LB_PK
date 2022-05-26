import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;


public class Main {
    public static void main(String[] args) {
        // JsonParser
        JsonElement json = JsonParser.parseString("""
        {
            "number": 1,
            "object": {
                "string":"Hallo"
            },
            "boolean": true,
            "array": [
                47.11,
                "Hallo nochmal"
            ]
        }
    """);

// JsonReader
        try (JsonReader reader = new JsonReader(
                new StringReader(json.toString()))) {
            reader.beginObject();
            while(reader.hasNext()) {
                System.out.println(reader.nextName());
                reader.skipValue();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}