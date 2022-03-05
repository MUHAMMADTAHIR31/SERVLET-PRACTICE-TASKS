/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run_Length;

/**
 *
 * @author Dell
 */
       public class App{
           public static void main(String[] args){
               String text="aaaaaaaaaabbbbbbbbbbbbbcccccccccccddddddddddaaaaaaaaaaaafffffff";
               char previous=' ';
               int counter=1;
               String result="";
               for(int i=0;i<text.length();i++){
                   char c=text.charAt(i);
                   if(previous==' '){
                       previous=c;
                   }else if(previous==c){
                       counter++;
                   }else{
                       result += counter + ""+previous;
                       previous=c;
                       counter=1;
                   }
                   if(i==text.length()-1){
                       result += counter + ""+previous;
                   }
                   
               }
               System.out.println(text);
               System.out.println(result);
           }
       }
