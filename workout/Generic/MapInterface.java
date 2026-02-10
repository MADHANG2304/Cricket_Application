package Generic;

public interface MapInterface<K , V>{

    void set(K key , V value);
    V getValue(K key);
}
