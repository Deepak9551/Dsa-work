package com.dk;


import java.util.*;

public class Main {
    public static void main(String[] args) {

      replaceValueInList(  new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8)));


        }


        

        public  static void replaceValueInList(List<Integer> elements){
            Scanner sc = new Scanner(System.in);

            System.out.println(elements);
            System.out.println("Enter the element you want to remove !");
            int userInput= sc.nextInt();

            if(elements.contains(userInput)){
                var index = elements.indexOf(userInput);
                System.out.println("Enter new Element");
                var newElement = sc.nextInt();

                elements.set(index,newElement);
                elements.sort((x,y)->
                {
                   return -1;
                });
                System.out.println(elements);
            }
            else{
                System.out.println("ELEMENT IS NOT PRESENT IN COLLECTION ...");
            }
        }
    }
