/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3;

import java.util.Scanner;

/**
 *
 * @author Clarisse Angeline
 */
public class NewClass {
   private class PriorityQueuesArray{
            int priority;
            int data;
            
            PriorityQueuesArray next;     
    }
    private PriorityQueuesArray front;
    private int printCount=0;
    private void insertion(int page, int priority) throws Exception{
        
        PriorityQueuesArray node = new PriorityQueuesArray();
        node.data=page; 
        node.priority=priority;
        node.next=null;
        if (front == null||priority<= front.priority){
        node.next=front;
        front=node;
        }
        else{
            PriorityQueuesArray temporary = front;
            while (temporary.next!=null
                    && temporary.next.priority<=priority) {                
                temporary=temporary.next;
            }
            node.next=temporary.next;
            temporary.next=node;
        }
        printCount++;
        if(printCount>5){
            deletion();
        }
        }
       public int deletion() throws Exception{
        if (front == null){
            throw new Exception("Queue is Empty");
        }
        int temporary = front.data;
        front = front.next;  
        printCount--;
        
        return temporary;
        
    }
          public void display() throws Exception{
        if (front == null){
            throw new Exception("Queue is Empty");
        }
        PriorityQueuesArray temporary = front;
        System.out.println("Priority \t\t Pages ");
        
        while (temporary!=null){
            System.out.println(temporary.priority+"\t\t\t"+temporary.data);
            temporary = temporary.next;
        }
        System.out.println("\n");
    }
          public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner (System.in);
        NewClass list = new NewClass();
        
        while(true){
            System.out.println("THE PRINTER QUEUE DILEMMA");
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Exit");
            int choice=scn.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter the Priority Number");
                    int priority=scn.nextInt();
                    System.out.println("Enter the pages ");
                    int pages=scn.nextInt();
                    list.insertion(pages, priority);
                    break;
                case 2:
                    list.display();
                    break;
            }
            
        }
    
}
}
