package ex8;

public class MyDictionary<K, V> {
    private final static int DEFAULT_CAPACITY = 4;
    private int size;
    private K key;
    private V value;

    public int size() {
        return size;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }

    private MyDictionary<K, V>[] dictionary = new MyDictionary[DEFAULT_CAPACITY];

    public MyDictionary(){
    }
    private MyDictionary(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void add(K key, V value) {
        if (key != null && value != null) {
            //перевірка на заповненість словника, у разі чого збільшуємо словник
            if (size == dictionary.length) {
                MyDictionary<K, V>[] tempDictionary = new MyDictionary[DEFAULT_CAPACITY * 2];
                for (int i = 0; i < dictionary.length; i++) {
                    tempDictionary[i] = dictionary[i];
                }
                dictionary = tempDictionary;
            }
            //перевірка на наявність Key в словнику, у  разі чого перезаписуємо value
            boolean insert = true;
            for (int i = 0; i < size; i++) {
                if (dictionary[i].getKey().equals(key)) {
                    dictionary[i].setValue(value);
                    insert = false;
                }
            }
            if (insert) {
                dictionary[size++] = new MyDictionary<>(key, value);
            }
        }else throw new NullPointerException("Передавати null заборонено");
    }

    public MyDictionary<K, V> get(int index){
        if (index<size && index >= 0)
            return dictionary[index];
        else throw new IndexOutOfBoundsException("Індекс більше розміру списку");
    }

    public V getValueByKey(K key){
        if (key != null) {
            for (int i = 0; i < size; i++) {
                if (dictionary[i].getKey().equals(key)) {
                    return dictionary[i].getValue();
                }
            }
        }else {
            throw new NullPointerException("Передавати null заборонено");
        }
        return null;
    }

    @Override
    public String toString() {
        return "{key=" + key +
                ", value=" + value +
                '}';
    }
}
