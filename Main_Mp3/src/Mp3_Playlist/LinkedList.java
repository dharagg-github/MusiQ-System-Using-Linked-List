package Mp3_Playlist;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class LinkedList {
	
	 Node head;
	
	public class Node{
		
		String data;
		Node next;
		
		Node (String new_data){
			data = new_data;
			next = null;
			
		}
	}
	
	
	  public void add(String new_data) {
		  
			  Node new_node = new Node(new_data);
			  new_node.data=new_data;
			  new_node.next = null;
			  
		  
			if(head==null) {
				
				head = new Node(new_data);
		}
			else {
			
			Node last = head;
			
			while(last.next!=null)
				last = last.next;		
			
			last.next = new_node;
			}
	  }
	  
	  
	  public boolean chck_Llist(String user_data) {
		  
		  String chck_data = user_data;
		  
		  if(head == null) {
			  return false;
		  }
		  
		  
		  Node tmp_node = head;
		  
		  while(tmp_node!=null) {
			  
			  String Llist_data = tmp_node.data;
			  
			  if(Llist_data.equals(chck_data)) {
				  
				  return true;
			  }
			  tmp_node = tmp_node.next;
			  
		  }
		  return false;
	  }
	  
	  
	  public int del(String dele_Songname) {
		  
		  String user_song=dele_Songname;
		  if(head == null) {
			  System.out.println("No songs in the playlist!! Please Add one First....");
			  return 0;
		  }
		  else{
			  
			  Node current = head;
			 
			  
			  Node temp = null;
			  String first_value=current.data;
			  
			  if(current!=null && first_value.equals(user_song) ){
				  
				  head = current.next;
				  return 1; 
				  
			  }
			  else {
				  
				  while(current !=null && !user_song.equals(current.data)) {
				  temp= current;
				  current = current.next;
			  }
				  
				  if(current==null) {
					  return -1;
				  
				  }
				  else {
					  temp.next = current.next;
					  return 1;
				  }
			  }
			   
		  }
	  }
	  
	  
	  public void view() {
		  
		  if(head==null) {
			  System.out.println("No songs in the playlist!! Please Add one First....");
		  }
		  
		  else {
			
			Node temp_node = head;
			while(temp_node!=null) {
				
				System.out.println(temp_node.data);
				temp_node = temp_node.next;	
			
		
			}
		  }
	  }
	  
	  
	  public  void play() {
		  
		  if(head == null) {
			  System.out.println("No songs in the playlist!!! Please add one first....");
		  }
		  
		  else {
			  
			  Node temp_node = head;
			  System.out.println("Here is the list of songs in the playlist----->\n");
			    
			  while(temp_node!=null) {
					
				  System.out.println(temp_node.data);
				  temp_node = temp_node.next;	
				
			
				}

			  
			  Node play_node = head;
			  
			  while(play_node!=null) {
				  
				    String p = play_node.data;
				  
					String c = p + ".mp3";
					
					try {
						FileInputStream fileInputStream = new FileInputStream (c);
					    Player player = new Player(fileInputStream);
						System.out.println("\nPlaying The Song --> " + c);
						player.play();
					}
					catch(FileNotFoundException e){
						e.printStackTrace();	
					}
					catch(JavaLayerException e){
						e.printStackTrace();
					}
					
					play_node = play_node.next;
						
			  }
			  }
		  
	  }
}
		  