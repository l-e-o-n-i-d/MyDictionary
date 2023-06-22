package ex8;

public class Main {
    public static void main(String[] args) {
        MyDictionary<Integer, String> myDictionary = new MyDictionary();
        myDictionary.add(5, "Honda");
        myDictionary.add(2, "Mazda");
        myDictionary.add(7, "BMW");
        myDictionary.add(10, "Toyota");
        myDictionary.add(12, "Tesla");
        System.out.println(myDictionary.get(4));
        myDictionary.add(12, "Skoda");
        System.out.println(myDictionary.get(4));
//        myDictionary.add(1, null);
        System.out.println(myDictionary.size());
        System.out.println(myDictionary.get(0));
        System.out.println(myDictionary.get(1));
        System.out.println(myDictionary.get(4));
        System.out.println(myDictionary.getValueByKey(7));
        System.out.println(myDictionary.getValueByKey(12));
//        System.out.println(myDictionary.getValueByKey(null));
    }
}
