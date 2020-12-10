package com.ivan;

import java.util.ArrayList;
import java.util.Scanner;

public class EchoChamber {

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<String>();
        String word = new String();
	    do{
	        word = scan.nextLine();
	        words.add(word);
        }
	    while (word.length() > 1);
	    for (String i : words){
	        System.out.println(i);
        }
    }
}
