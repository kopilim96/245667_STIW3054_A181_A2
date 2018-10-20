package com.assignment2;


public class App
{
    public static void main( String[] args ){
        printToPDF print = new printToPDF();
        try {
            print.printPdf();

        }catch (Exception e){
            e.getStackTrace();
        }
        System.out.printf("%n%n","");
        System.out.println("Print out Data Successful");
    }
}
