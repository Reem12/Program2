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
public class Node implements Comparable<Node> {
  private Node left =null;
  private Node right=null;
  private String letter;
  private int freq;
  private Node next=null;
  private Node parent =null;
  private String code="";
 //
 
  public Node(String leafLetter,int f)//leaf node 
  {
  letter=leafLetter;
  left=null;
  right=null;
  freq=f;
  next=null;
  parent=null;
  code="";
  
  }
  public Node(String leafLetter,int f, Node lchild, Node rchild)//tree node
  {
  letter=leafLetter;
  left=lchild;
  right=rchild;
  freq=f;
  next=null;
  parent=null;
  code="";
 
  }
  
  public Node left(){
      return left;}
  
  public Node right(){
      return right;}
  
  public void left(Node inputNode)
  {left=inputNode;}
  
  public void right(Node inputNode ){
  right=inputNode;}
  
  public String letter()
  {return letter;}
  
  public int freq()
  {
  return freq;
  
  }
public void freq(int f){

freq=f;
}  
public Node parent(){
return parent;

}
public void parent(Node f){
parent =f;

}
public void letter(String l){
letter=l;

}

public boolean isLeaf(){
return (left==null && right==null);
}
public String code(){
return code;
}
public String ParentCode(){
if (parent()!=null)
{ return parent().code();}
else{
return "";
}
}
public void code(String input){
code=input;

}
public void add0(){
code(ParentCode()+ "0");
}
public void add1(){
code(ParentCode()+ "1");
}
public Node leftTurn(){

add0();
return left;
}
public Node rightTurn(){

add1();
return right;
}
public void print(){
System.out.println("' "+letter()+"' "+freq+"'Code: "+parent().code());
}

    @Override
    public int compareTo(Node o) {
        if(this.freq==o.freq)
            return 0;
        else if(this.freq>o.freq)
            return 1;
        else
            return -1;
        
    }
}
