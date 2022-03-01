
package Mp3_Playlist;

import java.util.Scanner;
import java.util.Arrays;

public class Playlist {
	
    public static void main(String[] args) {
    	 
    	 Scanner input=new Scanner(System.in);
    	 
    	 LinkedList adsp = new LinkedList();
    	 
    	 //Creating a small data base of songs in an array
    	 String D_base[] = {"Thooriga","Uptown Funk","Shape Of You","Azhagiye","Naani Koni","Veesum Velichathile","Bujji","Cheap Thrills",""};
    	 Arrays.sort(D_base);

         System.out.println("---------------------------Welcome All-------------------\n------------------- Create Your Own Playlist---------------");
         System.out.println("Enter your Playlist Name");
         
         //Getting the playlist name with the help of scanner class
         String playlist_name=input.nextLine();
                 
         boolean first =true;
         //Performing every operations use of infinite while loop
         while(first){
             System.out.println("\nEnter 1) To Add Songs To Playlist:  "+playlist_name+"\n"+
                                 "Enter 2) To remove Songs From Playlist: "+playlist_name+"\n"+
                                  "Enter 3) To show the songs in Playlist: "+playlist_name+"\n"+
                                  "Enter 4) To Play The Playlist: "+playlist_name+"\n"+
                                  "Enter 5) To Exit");
             int choice1=input.nextInt();
             
             switch(choice1){
             
             
                case 1:
                	
                	  System.out.println("Enter The name of the Song");
                	 
                	  input.nextLine();//Just to eliminate the enter otherwise it will be stored as a input(Song name)
                	  String Songname=input.nextLine();
                	  
                      String Chck_Songname = Songname;
                      int loc_Songname = Arrays.binarySearch(D_base,Chck_Songname);
                      
                      if(loc_Songname>=0) {
                    	  
                    	  if(adsp.chck_Llist(Songname)) {
                    		  System.out.println("\nThe given song "+Songname+ " is already in the playlist "+playlist_name+"\n");
                    		  
                      }
                    	  else {
                    		  
                    		  adsp.add(Songname);
                              System.out.println("\n"+Songname+" song is added to playlist "+playlist_name+"!!!\n");
                    		  
                    	  }
                      }
                
                      else {
                    	  System.out.println("\nThe given Song "+Songname+" is not in the Database");
                    	  
                      }
                      
                      
                      break;
                      
                case 2:
                	
                	System.out.println("Enter The name of the Song to be Deleted");
                    input.nextLine();//Just to eliminate the enter otherwise it will be stored as a input(Del Song name)
                    String del_Songname=input.nextLine();
                    
                    int value=adsp.del(del_Songname);
                    
                    if( value!= 0) {
                    	 
                    	 if(value == 1) {
                    		 System.out.println("\n"+del_Songname+" is deleted from the playlist "+playlist_name);
                    	 }
                    	 else if(value==-1) {
                    		 System.out.println("\nThe given song "+del_Songname+" is not in the playlist");
                    		 
                    	 }
                    }
                   
                	break;
                
                	
                case 3:
                	
                	System.out.println(  playlist_name+"---------->\n");
                    adsp.view();
                	break;
                
                	
                case 4:
                	
                	Mp3_Player class2 = new Mp3_Player();
                	break;
            		
                case 5:
                	
                	first=false;
                    break;
                    
                default:first=false;
                break;
                		
             }
             
         }
         
         input.close();
         
    }
    
}
            	 
        
