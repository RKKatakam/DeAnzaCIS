public class Main {
    public static void main(String[] args) throws Exception {
        //First, print a Welcome message for the demonstration of your ADTs - you can decide what the message says but it should include your full name(s).
        //todo: fix welcome message
        System.out.println("Welcome to the ADT demonstration by: Kittu Katakam and Hsin Huei Li");
        System.out.println();
        System.out.println();

        //second, make the currency array
        Currency[] kroneArray = new Currency[20];
        kroneArray[0] = new Krone(57.12);
        kroneArray[1] = new Krone(23.44);
        kroneArray[2] = new Krone(87.43);
        kroneArray[3] = new Krone(68.99);
        kroneArray[4] = new Krone(111.22);
        kroneArray[5] = new Krone(44.55);
        kroneArray[6] = new Krone(77.77);
        kroneArray[7] = new Krone(18.36);
        kroneArray[8] = new Krone(543.21);
        kroneArray[9] = new Krone(20.21);
        kroneArray[10] = new Krone(345.67);
        kroneArray[11] = new Krone(36.18);
        kroneArray[12] = new Krone(48.48);
        kroneArray[13] = new Krone(101.00);
        kroneArray[14] = new Krone(11.00);
        kroneArray[15] = new Krone(21.00);
        kroneArray[16] = new Krone(51.00);
        kroneArray[17] = new Krone(1.00);
        kroneArray[18] = new Krone(251.00);
        kroneArray[19] = new Krone(151.00);

        //Then, create one each of SinglyLinkedList, Stack and Queue objects.
        System.out.println("Creating one each of SinglyLinkedList, Stack and Queue objects.");
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Stack stack = new Stack();
        Queue queue = new Queue();


        //Add the first seven (7) objects from the array into the linked list in order such that they end up in the reverse order in the linked list, i.e. the seventh element as first node and first element as seventh node. If it is easier, you are allowed to insert copies of the objects.
        System.out.println("---------------------------------Linked Lis part---------------------------------");
        for (int i = 6; i >= 0; i--) {
            singlyLinkedList.insertAtBack(kroneArray[i]);
        }

        // Search for Kr 87.43 followed by Kr 44.56 - print the results of each.
        System.out.println(singlyLinkedList.find(new Krone(87.43)));
        System.out.println(singlyLinkedList.find(new Krone(44.56)));

        // Remove the node containing Kr 111.22 followed by the node at index 2. Print the contents of the list
        singlyLinkedList.delete(new Krone(111.22));
        singlyLinkedList.deleteAtPosition(2);
        System.out.println(singlyLinkedList.printList());



        // Then add the next four (4) objects (#9 thru 12) such that their index in the linked list is calculated as (index in array % 5).
        for (int i = 8; i < 12; i++) {
            singlyLinkedList.insertAtPosition(kroneArray[i], i % 5);
        }

        //Remove two (2) objects at indexes (countCurrency % 6) and (countCurrency / 7) in that order.
        singlyLinkedList.deleteAtPosition(singlyLinkedList.getCount() % 6);
        singlyLinkedList.deleteAtPosition(singlyLinkedList.getCount() / 7);


        //print the contents of the list
        System.out.println(singlyLinkedList.printList());

        //Push seven (7) objects starting from the array index 13 onwards to the stack.
        System.out.println("---------------------------------Stack part---------------------------------");
        for (int i = 13; i < 20; i++) {
            stack.push(kroneArray[i]);
        }


        //Peek the top of the stack - print the result.
        System.out.println(stack.peek());


        //Perform three (3) pops in succession.
        stack.pop();
        stack.pop();
        stack.pop();


        //Print the contents of the stack.
        System.out.println(stack.printStack());


        //Push five (5) more objects from the start of the objects array to the stack.
        for (int i = 0; i < 5; i++) {
            stack.push(kroneArray[i]);
        }


        // Pop twice in succession.
        stack.pop();
        stack.pop();

        //Print the contents of the stack.
        System.out.println(stack.printStack());


        //Enqueue the seven (7) objects at odd indexes starting from index 5 in the array.
        System.out.println("---------------------------------Queue part---------------------------------");
        for (int i = 5; i < 18; i += 2) {
            queue.enqueue(kroneArray[i]);
        }


        //Peek the front and end of the queue - print the results.

        System.out.println(queue.peekFront());
        System.out.println( queue.peekRear());

        //Perform two (2) dequeues in succession.
        queue.dequeue();
        queue.dequeue();

        //Print the contents of the queue.
        System.out.println(queue.printQueue());

        // Enqueue five (5) more objects from the index 10 in the array.
        for (int i = 10; i < 15; i++) {
            queue.enqueue(kroneArray[i]);
        }


        //Dequeue three times in succession.
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        //Print the contents of the queue.
        System.out.println(queue.printQueue());

    }
}