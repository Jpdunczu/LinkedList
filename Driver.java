package lab6;

public class Driver {

    

    static <T> void  printList(List_Interface<T> list) {

           System.out.print ("{ ");

           for (int i = 0; i < list.getSize(); i++)

                  System.out.print(list.getAt(i) + " ");

           System.out.println("}");

    }

   

   

   

    public static void main(String [] args) {

           //List_Interface<String> list =   (Math.random() < 0.5) ? new Linked_List<String>() : new Array_List<String>();
           
           List_Interface<String> list =   new Array_List<String>();
           
           list.addToEnd("A");

           list.insert(1, "B");

           list.addToEnd("C");

           printList(list);

           list.setAt(1, "G");

           printList(list);

           for (int i = 0; i< 3; i++ ) {

                  list.remove(0);

                  printList(list);

           }

           System.out.println(list.isEmpty());

           list.insert(0, "D");

           list.insert(0, "C");

           list.insert(1, "E");

           printList(list);

           System.out.println(list.contains("A"));

           System.out.println(list.contains("D"));

           System.out.println(list.contains("C"));

           System.out.println(list.contains("E"));

           System.out.println("The list size is " + list.getSize() + ".");

           try {

                  System.out.println(list.getAt(3));

           }

           catch (IndexOutOfBoundsException e) {

                  System.out.println("Caught " + e);

           }

           try {

                  System.out.println(list.getAt(-1));

           }

           catch (IndexOutOfBoundsException e) {

                  System.out.println("Caught " + e);

           }

           list.clear();

           printList(list);

           System.out.println("The list size is " + list.getSize() + ".");

           list.addToEnd("T");

           list.insert(1, "U");

           printList(list);

           try {

                  list.insert(3, "X");

           }

           catch (IndexOutOfBoundsException e) {

                  System.out.println("Caught " + e);

           }

           try {

                  list.remove(-1);

           }

           catch (IndexOutOfBoundsException e) {

                  System.out.println("Caught " + e);

           }

           Object [] a = list.toArray();

           for (int i = 0; i < a.length; i++)

                  System.out.print(a[i] + " ");

           System.out.println();

           Linked_List<Integer> numList = new Linked_List<Integer>();



           for (int i = 0; i < 20; i++)

                  numList.addToEnd(i);

           printList(numList);

    }



}
