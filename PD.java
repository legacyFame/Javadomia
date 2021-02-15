import java.util.*;

public class PD{ //Strring manipulation
     
     static void palindrome(){
	Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        boolean flag =true;
        
        for(int i=0;i<word.length()/2;i++){
            if(word.charAt(i)!=word.charAt(word.length()-1-i)){
                flag = false;
                break;
            }
        }
        System.out.print(flag);}

     static void fz(){
       Scanner input = new Scanner(System.in);
	System.out.println("The word...");

        String word =input.nextLine();
System.out.println("The charrrr...");

	String letter1 = input.next();
        char letter=letter1.charAt(0);
	int count=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==letter){
                count++;

                            }
        }
	System.out.print(count);
}
       	
     
    
      
      
      
     public static void main(String []args){
        int mat1[][];//{{1,2},{1,2}};
        int mat2[][];//{{1,2},{1,2}};
        int mat3[][]=new int[mat1.length][mat2[0].length];
        Scanner input = new Scanner(System.in);
	System.out.println("MAT1 ..\n");
        String word =input.nextLine();


        for(int i =0;i<mat1.length;i++){
            
           
            for(int j =0;j<mat2[0].length;j++){
                
                mat3[i][j]=0;
                 for(int k =0;j<mat2.length;k++){
                    mat3[i][j] += mat1[i][k] * mat2[k][j];
                
            }
        
        }
        System.out.println(mat3);
     }

     
}}
