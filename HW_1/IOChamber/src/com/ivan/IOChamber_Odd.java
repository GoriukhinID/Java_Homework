package com.ivan;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IOChamber_Odd extends IOChamber {
    public IOChamber_Odd(){ }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(^[A-Z]:\\\\.+\\.txt)");// find all looks like C:\***.txt
        IOChamber_Odd a = new IOChamber_Odd(); // this thing was changed
        boolean isInFile = false;
        if (args.length != 0) {
            Matcher matcher = pattern.matcher(args[0]);
            isInFile = matcher.find();
        }

        if (isInFile){
            try {
                a.ChamberRun(args[0], scan);  // writing in file
            } catch (Exception e) {
                System.out.println("Can't write in file.");
            }
        } else {
            a.ChamberRun(scan);   // writing in console
        }

    }

    public ArrayList<String> ChamberRead(Scanner scan){
        // get input of scan and write it in list
        String word = new String();
        ArrayList<String> words = new ArrayList<String>();
        do{
            word = scan.nextLine();
            if (!(word.length() > 1)){
                break;
            }
            words.add(word);

            String a = scan.nextLine(); // this thing was added
            if (!(a.length() > 1)){
                break;
            }
        }
        while (true);
        return words;
    }
}
