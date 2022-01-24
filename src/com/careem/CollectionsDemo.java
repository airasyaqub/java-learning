package com.careem;

import java.util.*;



// https://www.javatpoint.com/collections-in-java
// https://www.youtube.com/watch?v=rzA7UJ-hQn4

class Student implements Comparable<Student> {
    String name;
    Integer roll;

    public Student(String name, Integer roll) {
        this.name = name;
        this.roll = roll;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        System.out.println(o);
        System.out.println(this == o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return roll.equals(student.roll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll);
    }

    @Override
    public int compareTo(Student that) {
        // return this.roll.compareTo(that.roll);

        if (this.roll < that.roll) {
            return -1;
        } else if (this.roll > that.roll) {
            return 1;
        } else {
            return 0;
        }
    }
}


public class CollectionsDemo {

    public static void main(String[] args) {
        CollectionsDemo obj = new CollectionsDemo();


        // We use list when we need to store insertion order maintained collection. List have indexed based methods
        // obj.createArrayList();


        // We use stack when we need to work with data in LIFO manner, and you want to be able to discard every
        // item you popped out of the stack after processing it.
        // obj.createStack();


        // queue is a linear DS which works in FIFO manner. We don't implement queue using array as it
        // is of fixed size. We use linked list with queue that has we can create a
        // queue of variable size and depending on our need we can increase or decrease the size of the queue.
        // https://www.programiz.com/java-programming/queue (to check alternate methods to use when queue instead of list)
        // obj.createLinkedListQueue();
        // obj.createPriorityQueue();
        // obj.createDeQueue();


        // If the requirement is to have only unique values then
        // Set is your best bet as any implementation of Set maintains unique values only. Insertion order
        // is not maintained in it. It uses hashing internally.
        // obj.createSet();


        // Other collections store values while in map we store key value pair.
        // obj.createMap();


        // There are many utility functions in collection & array class. To sort custom collections we
        // need to implement custom COMPARABLE interface. If you need to do comparison of a third-party class
        //  which is not implementing COMPARABLE interface we will use COMPARATOR. Second situation
        //  is when we need to change logic of comparable dynamically ( meaning comparison
        // on basis of different properties ) you need to make a COMPARATOR.
        obj.doCustomComparable();





    }

    private void createArrayList(){

        /*for (int i = 0; i < 10; i++) {
            arrayList.add((int)(Math.random() * 10));
        }*/

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("airas");
        arrayList.add("adeel");
        arrayList.add(1, "naveed");
        arrayList.add("ahmed");

        ArrayList<String> newArrayList = new ArrayList<String>();
        newArrayList.add("khalid");
        newArrayList.add("zeeshan");
        arrayList.addAll(newArrayList);

        System.out.println(arrayList);

        System.out.println("at index 2 ==>" + arrayList.get(2));
        arrayList.remove(3);
        arrayList.remove(String.valueOf("zeeshan"));
        System.out.println("after removing ==>"+arrayList);

        arrayList.set(2, "sheroz");
        arrayList.addAll(3, newArrayList);


        ListIterator<String> stringListIterator = arrayList.listIterator();
        while (stringListIterator.hasNext()) {
            System.out.println(stringListIterator.next());
        }
    }

    private void createLinkedListQueue(){


        LinkedList<String> stringLinkedList = new LinkedList<String>();

        stringLinkedList.offer("ahmed");
        stringLinkedList.offer("airas");
        stringLinkedList.offer("adeel");

        System.out.println(stringLinkedList);
        System.out.println("polling ==>"+ stringLinkedList.poll());
        System.out.println("after polling ==>"+ stringLinkedList);
        System.out.println("polling ==>"+stringLinkedList.peek());

    }

    private void createStack(){
        Stack<String> stringStack = new Stack<String>();
        stringStack.push("airas");
        stringStack.push("adeel");
        stringStack.push("ahmed");

        System.out.println("peeking ==>"+ stringStack.peek());
        stringStack.pop();
        System.out.println("peeking after popping==>"+ stringStack.peek());


        for (String el: stringStack ) {
            System.out.println(el);
        }

    }

    private void createPriorityQueue(){
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        integerPriorityQueue.offer(12);
        integerPriorityQueue.offer(1);
        integerPriorityQueue.offer(32);
        integerPriorityQueue.offer(4);
        integerPriorityQueue.offer(18);


        System.out.println(Arrays.toString(integerPriorityQueue.toArray()));
        integerPriorityQueue.poll();
        System.out.println(integerPriorityQueue);
        integerPriorityQueue.poll();
        System.out.println(integerPriorityQueue);
        integerPriorityQueue.poll();
        System.out.println(integerPriorityQueue);
        System.out.println("peeking ==>"+integerPriorityQueue.peek());

        Iterator<Integer> stringIterator = integerPriorityQueue.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }

    private void createDeQueue(){
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<Integer>();

        integerArrayDeque.offer(23);
        integerArrayDeque.offerFirst(12);
        integerArrayDeque.offerLast(45);
        integerArrayDeque.offerFirst(26);


        System.out.println(integerArrayDeque);


        System.out.println("peek ==>"+integerArrayDeque.peek());
        System.out.println("peekFirst ==>"+integerArrayDeque.peekFirst());
        System.out.println("peekLast ==>"+integerArrayDeque.peekLast());

        System.out.println(integerArrayDeque.poll());
        System.out.println("poll ==>"+integerArrayDeque);

        System.out.println(integerArrayDeque.pollFirst());
        System.out.println("pollFirst ==>"+integerArrayDeque);

        System.out.println(integerArrayDeque.pollLast());
        System.out.println("pollLast ==>"+integerArrayDeque);

    }

    private void createSet(){

        /*LinkedHashSet also implements property of link-list which is
        that every element is linked according to insertion order. So now insertion order is maintained too.*/


        /*TreeSet implements set and Binary search tree. So now it stores data in sorted from and only
        includes unique element.*/


        Set<Student> mySet = new HashSet<Student>();
        // Set<Integer> integerSet = new LinkedHashSet<Integer>();
        // Set<Integer> integerSet = new TreeSet<>();


        mySet.add(new Student("airas", 23));
        mySet.add(new Student("ahmed", 27));
        mySet.add(new Student("zaka", 41));
        mySet.add(new Student("airas", 23));



        /*mySet.add(10);
        mySet.add(12);
        mySet.add(38);
        mySet.add(62);
        mySet.add(12);*/

        System.out.println(mySet);
        mySet.remove(38);
        System.out.println("after remove ==>"+mySet);
        System.out.println(mySet.contains(12));
        System.out.println(mySet.isEmpty());
        System.out.println(mySet.size());
        mySet.clear();
        System.out.println(mySet);

    }

    private void createMap() {

        // TreeMap will sort wrt keys.

        // Map<String, Integer> myMap = new HashMap<>();
        Map<String, Integer> myMap = new TreeMap<>();

        myMap.put("airas", 26);
        myMap.put("ahmed", 28);
        myMap.put("osama", 29);
        myMap.put("mirza", 25);
        myMap.putIfAbsent("airas", 27);

        System.out.println(myMap);
        System.out.println(myMap.containsKey("airas"));
        System.out.println(myMap.containsValue(25));

        for (Map.Entry<String, Integer> e: myMap.entrySet()) {
            System.out.println("key: "+e.getKey()+", value: "+e.getValue());
        }

        for (String key: myMap.keySet()) {
            System.out.println("key: "+key);
        }

        

    }

    private void doCustomComparable() {

        ArrayList<Student> arrayList = new ArrayList<Student>();

        arrayList.add(new Student("airas", 23));
        arrayList.add(new Student("ahmed", 27));
        arrayList.add(new Student("zaka", 41));
        arrayList.add(new Student("airas", 12));
        arrayList.add(new Student("waqar", 63));

        Collections.sort(arrayList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.roll.compareTo(o2.roll);
            }
        });

        System.out.println(arrayList);

    }


}
