/*
 *  This program encrypt text intp binary and then 
decrypts that binary back into text using huffman tree/.
This program reads from file named "input.txt" to encode the text  
and the decoded text will be written in text file named "output.txt"
Frequency table, huffman tree, code table, encrypted and decrypted text are print it in the console. 
The tree is printed sideways from left to right where the left is the top of the tree and the right is the buttom of the tree. 
 */
package program2;

import java.io.FileNotFoundException;

/**
 *
 * @author Reem AlGhamdi
 * @Date 5/29/2018
 */
public class Program2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //read input
        FileMgmt x = new FileMgmt("input.txt");
        String input= x.read();
        
        Tree huff =new Tree();
        huff.generate(input);
        
        String encrypted = huff.encrypt(input);
        String decrypted = huff.decrypt(encrypted);
        
        FileMgmt y = new FileMgmt("output.txt");
        y.write(decrypted);
       
    }
    
}
