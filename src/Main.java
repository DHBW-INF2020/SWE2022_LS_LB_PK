import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import input.InputHandler;
import tree.Node;


public class Main {
    public static void main(String[] args) {
        InputHandler handler = new InputHandler();
        Node root = handler.parseJsonToTree("input.json");

    }
}