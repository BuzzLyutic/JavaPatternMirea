package Practice_7_SecondPart;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory{
    private Map<String, Flyweight> characterCache;

    public FlyweightFactory() {
        characterCache = new HashMap<>();
    }

    public Flyweight getCharacter(String name) {
        Flyweight character = characterCache.get(name);
        if (character == null) {
            character = new ConcreteFlyweight(name);
            characterCache.put(name, character);
        }
        return character;
    }
}
