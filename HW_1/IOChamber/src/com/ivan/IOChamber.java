package com.ivan;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOChamber {

    public IOChamber(){ }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(^[A-Z]:\\\\.+\\.txt)");// find all looks like C:\***.txt
        IOChamber a = new IOChamber();
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
        }
        while (true);
        return words;
    }

    public void ChamberRun(Scanner scan){
        ArrayList<String> words = new ArrayList<String>();
        words = ChamberRead(scan);
        for (String i : words){
            System.out.println(i);
        }
    }

    public void ChamberRun(String path, Scanner scan) throws Exception {
        try {
            FileWriter fw = new FileWriter(path);
        } catch (Exception e){
            throw new Exception();
        }
        FileWriter fw = new FileWriter(path);

        ArrayList<String> words = new ArrayList<String>();
        words = ChamberRead(scan);
        for (String i : words) {
            fw.write(i + "\n");
        }
        fw.close();
    }

}


