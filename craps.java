* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;


import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author daylinhenry
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String []args){ 
        Random rnd = new Random(); 
        Scanner keyboard = new Scanner(System.in);
        
        int i =0;  
        int bet; 
        int wins[] = new int[100]; 
        int loss[] = new int[100];  
        String game;  
        
        
        //asks the user if they want to play 
        
        System.out.println ("New Game?"); 
        game = keyboard.next(); 
        
        //begins the game 
        
        while(game.equals ("yes")){ 
       
        System.out.println("What is your bet?");  
        bet = keyboard.nextInt();  
        i++; 
        
        int roll = rollDice();
        System.out.println("Your roll is "+ roll);  
        
        // goes through the rules of craps 
        
        //if the roll is 7 or 11 you win 
            if(roll == 7 || roll == 11){ 
                System.out.println("You won!"); 
                wins[i] = bet;  
                System.out.println("$"+ bet + " was added to your pot");
               
        //if you roll a 2, 3, or 12 you lose    
            }else if(roll == 2 || roll == 3 || roll ==12){ 
                System.out.println("You lost!"); 
                loss[i] = bet; 
                System.out.println("$"+ bet + " was deducted from your pot");        
                

        //since they rolled none of the above the point is now established 
            }else{ 
                int point = roll; 
                System.out.println("The point is now " + roll);  
                System.out.println("Rolling the dice again..."); 
                
                //rolling the dice again 
                int roll2 =rollDice();  
                //System.out.println("You rolled a " + roll2); 

                //keep rolling while the dice is not the point or 7  
                while(roll2!=7 || roll2!=point){ 

                    roll2=rollDice();
                    System.out.println("You rolled a " + roll2);  
                    
                    //If they roll the point they win 
                    if(roll2 ==point){ 
                    System.out.println("You won!");  
                    wins[i] = bet; 
                    System.out.println("$"+ bet + " was added to your pot");
                   
                    //terminate 
                    break;
                  
                    //if they roll a 7 they lose 
                }else if(roll2 == 7){ 
                    System.out.println("You lost"); 
                    loss[i] = bet;  
                    System.out.println("$"+ bet + " was deducted from your pot");
                   
                    //terminate
                    break; 
                    
                    }  
                 
                }              
                        
                    } 
            //Ask the user if you want to play again. 
               System.out.println("Would you like to play again?"); 
               game = keyboard.next();  
                
     
            } 
           
            int wintot =0;  
            int losstot = 0; 
            for( int counter=1; counter<i; counter++){ 
                  System.out.println("Additions "+ "Game:"+ counter +" "+ wins[i]);  
                  System.out.println("Deductions " + "Game:" + counter +" " +  loss[i]); 
                  //counter++;
            
            wintot += wins[i]; 
            losstot += loss[i]; 
             
            } 
            
                
               
            System.out.println("Your total additions : "+ wintot);  
            System.out.println("Your total deductions : " + losstot); 
            
            System.out.println("Your pot has: " + "$"+ (wintot-losstot));
     
            
                
        
    }
              
   
    
     
    //end main
    /**
     *
     * @return
     */
    public static int rollDice() {
        Random rnd = new Random();  
        int dienumber1 =0; 
        int dienumber2 =0; 

	dienumber1 = 1 + rnd.nextInt(6);
	dienumber2 = 1 + rnd.nextInt(6); 
        int roll = dienumber1 + dienumber2;     
	
        return roll;
    
    }

} 
