/*
 *  This program encrypt text into binary and then 
decrypts that binary back into text using huffman tree.
This program reads a text file named "input.txt" to encode the text  
and the decoded text will be written in text file named "output.txt"
Frequency table, huffman tree, code table, encrypted and decrypted text are print it in the console. 
The tree is printed sideways from left to right.
 */
package program2;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author Reem AlGhamdi
 * @Date 5/29/2018
 */
public class Tree {
   public Node root;
   public HashMap<Character,String> codes =new HashMap<>();
   
   public Tree(){
   root=null;
   
   }
   public void generate (String input){
   char[] chInput= input.toCharArray();
   HashMap<Character,Integer> map= new HashMap<>();
   for(int i =0;i<chInput.length;i++){
      if (map.containsKey(chInput[i])){
      map.put(chInput[i], map.get(chInput[i])+1);// add1 to freq
      }

   else{
         map.put(chInput[i], 1); //add new
       }
   }
    //freq Table then insert it to the queue
   PriorityQueue<Node> q =new PriorityQueue<>();
   System.out.println("Frequncy Table");
   for(HashMap.Entry<Character,Integer> entry :map.entrySet()){
   System.out.println("'"+entry.getKey()+"': "+entry.getValue());
   Node n = new Node(entry.getKey().toString(),entry.getValue(), null,null);
   q.add(n);
   }
   //build huffman tree
   while(q.size()>1){
    Node l=q.poll();
    Node r=q.poll();
    Node p = new Node(l.letter()+r.letter(),l.freq()+r.freq(),l,r);
     //add parent to q
     q.add(p);
     l.parent(p);
     r.parent(p);
     root=p;
   }
   
   //create code table
   fillCodes(root);
   //print tree
   System.out.println("-\n Huffman Tree -\n");
   print(root,1);
   System.out.println("\n-end of tree-\n");
   //print code table
   printCodes();
   }
   
   public void print(Node x, int s){
   if (x==null)
       return;
   print(x.right(),s+13);
   System.out.println(String.format("%1$"+(s)+"s", "---[")+x.letter()+"|"+x.freq()+"|"+x.ParentCode()+"]");
   print(x.left(),s+13);
   }
   
   public void fillCodes(Node x){
    if(x.isLeaf()){
        codes.put(x.letter().charAt(0), x.ParentCode());
       return;}
    fillCodes(x.leftTurn());
    fillCodes(x.rightTurn());
}
   
public void printCodes(){
System.out.println("Code Table: ");
for(HashMap.Entry<Character,String> entry : codes.entrySet()){
System.out.println("'"+entry.getKey()+"' : "+entry.getValue());
}
}

   
   public String encrypt(String input){
   String output="";
   for(int i=0;i<input.length();i++)
   {output+=codes.get(input.charAt(i))+" ";
   }
   System.out.println("\nEncrypted text: \n"+output+" \n");
   return output;
   }
 
   
   public String decrypt(String input){
   String output="";
   String[] in= input.split(" ");
   for(int i = 0;i<in.length;i++){
   output+=search(in[i]);
   }
   System.out.println("\n Decrypted text: \n"+output+" \n");
   return output;
   }
   public String search (String s){
   Node iter= root;
   for(int i =0;i<s.length();i++){
      if(s.charAt(i)=='1')
      {iter=iter.right();}
      else if(s.charAt(i)=='0'){
      iter=iter.left();
      }
      else{
      System.out.println("Error"+i+s);
      }
   }
   return iter.letter();
   }
   
   
}
   
   
   

   
