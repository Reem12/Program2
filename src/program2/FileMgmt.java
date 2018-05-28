/*
 *  This program encrypt text intp binary and then 
decrypts that binary back into text using huffman tree/.
This program reads from file named "input.txt" to encode the text  
and the decoded text will be written in text file named "output.txt"
Frequency table, huffman tree, code table, encrypted and decrypted text are print it in the console. 
The tree is printed sideways from left to right where the left is the top of the tree and the right is the buttom of the tree. 
 */
package program2;

/**
 *
 * @author Reem AlGhamdi
 * @Date 5/29/2018
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;
public class FileMgmt {
    private Scanner x;
    private String filename;
 public FileMgmt(String input){
 
 filename = input;
 }
 public String fileName(){
 return filename;
 }
 
 //open file
 public void open(){
 try{
      x = new Scanner(new java.io.File(filename));
 }
 catch(FileNotFoundException e){
 System.out.println("Could not find file!");
 }

}
 //read file into String 
 public String read() {
open();
String s = "";
while(x.hasNextLine()){
s = s + x.nextLine();
}
return s;
}

public void write(String in) throws FileNotFoundException{

PrintStream myconsole= new PrintStream(new File(filename));
System.setOut(myconsole);
myconsole.println(in);
}
}
