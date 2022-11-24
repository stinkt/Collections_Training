import java.util.*;

public class Main {
    public static void main(String[] args) {
        //array
        Integer[] int_arr;
        int_arr = new Integer[5];
        for (int i = 0; i < int_arr.length; i++) {
            int_arr[i] = i;
        }

        //arraylist
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Abc"); //adding object
        strings.set(0, "Abc1"); //changing object at pos 0
        strings.add("Def");
        strings.add(1, "Ghi"); //adding element to specific pos
        System.out.println(strings.indexOf("Abc1")); //returning index of element
        System.out.println(strings.get(0)); //returning element at index
        System.out.println(strings.contains("Def")); //is array containing element(true /false)
        System.out.println(strings.size()); //returning number of objects
        strings.remove("Def"); //removing object
        strings.clear(); // clearing arraylist

        //LinkedList
        LinkedList<String> stringList = new LinkedList<>();
        //same methods as array list but other structure 0-0-0
        stringList.addFirst("Abc");//adds element to start
        stringList.addLast("Xyz");//adds element to end
        System.out.println(stringList.peekFirst());//gets first element
        System.out.println(stringList.pollFirst());//gets first element and deletes it from list

        //HashMap
        HashMap<Integer, String> intsAndStrings = new HashMap<>();
        intsAndStrings.put(0, "A");//adding element to map
        intsAndStrings.put(1, "B");//adding element to map
        intsAndStrings.put(2, "C");//adding element to map
        intsAndStrings.put(0, "D");//overwriting element in map
        System.out.println(intsAndStrings.get(1)); //get element by key
        intsAndStrings.remove(0);//removing by key
        //check for existing - .containsKey(n), containsValue(name), isEmpty()   true/false
        System.out.println(intsAndStrings.keySet());//get all keys
        System.out.println(intsAndStrings.values());//get all values
        HashMap<Integer, String> intsAndStrings2 = new HashMap<>();
        intsAndStrings.putAll(intsAndStrings2);//unite 2 hashmaps
        //iterating over HashMap in a loop.
        for (Map.Entry entry: intsAndStrings.entrySet()) {
            System.out.println(entry);
        }

        //binary tree
        Tree bin_tree = new Tree();
        bin_tree.insertNode(6);
        bin_tree.insertNode(2);
        bin_tree.insertNode(8);
        bin_tree.insertNode(4);
        bin_tree.insertNode(5);
        bin_tree.insertNode(7);
        bin_tree.insertNode(9);
        bin_tree.insertNode(1);
        bin_tree.printTree();







        /*
        converting:
        Array to ArrayList - ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(int_arr));

        Array to LinkedList LinkedList<String> linkedList = new LinkedList<String>(Arrays.asList(strArr));

        ArrayList to Array - String[] stringArray = strings.toArray(new String[0]);

        LinkedList to Array - stringArray = stringLinkedList.toArray(new String[n]);
         */
    }
}