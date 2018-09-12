package posist;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class Genesis {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	
	// [ 1.] creation of genesis node
	private class GenesisNode {
		int ownerId=0;
		float value=0;
		String ownerName = "";
		String data="";
		Date timestamp=new Date();
		int nodenum;
		String nodeId="";
		String refNodeId="";
		String childrefNodeId="";
		String genesisNodeId="";
		String hashValue="";
		
		// [ 2.] set of child nodes of particular node
		ArrayList<GenesisNode> children = new ArrayList<>();
	}
	
	GenesisNode node=null;
	HashMap<Float, String> dat=new HashMap<>();

	private GenesisNode root;
	int size;
	
	// constructor
	public Genesis() {
		Scanner scn = new Scanner(System.in);
		this.root = takeInput(null, -1, scn);
	}
	
	
	// taking input and creating Genesis node and child nodes
	private GenesisNode takeInput(GenesisNode parent, int childIdx, Scanner scn) {
		// prompt the user
		if (parent == null) {
			System.out.println("enter the data for genesisnode or root");
		} else {
			System.out.println("enter data for " + childIdx + " child of " + parent.data);
		}

		// get data
		float data = scn.nextFloat();
		
		// [ 4. ] encrypt and decrypt data inside node
		
	
		String hash1 = hashfun1(data);
		dat.put(data,hash1);

		// create node and increase size
		GenesisNode child = new GenesisNode();
		size++;

		// set node's data
		child.value = data;
		child.nodenum++;

		// [ 3.] creating the child nodes originating from a particular node
		System.out.println("enter the number of children for " + child.data);
		int numGC = scn.nextInt();

		for (int i = 0; i < numGC; i++) {
			GenesisNode grandchild = this.takeInput(child, i, scn);
			child.children.add(grandchild);
		}

		// return
		return child;
	}
	
	
	public String hashfun1(float value){
		user u = new user();
		String str1 = u.id+u.name+value;
		return str1;
		
	}
	
	// [ 5.] verify user with encryption key
	HashMap<String, String> User = new HashMap<>();
	private class user{
		String name="";
		int id=0;
		String pw="";
		
		public void add(){
			
			Scanner scn = new Scanner(System.in);
			name=scn.nextLine();
			pw = scn.nextLine();
			User.put(name, pw);
			
		}
		
		public boolean chkpw(String p){
			return p==pw;
		}
		
		// [ 5.] check integrity of data
		
		public boolean chkdat(int val,String h){
			String str=name+val+id;
			String hs = dat.get(val);
			
			if(hs.equals(str)){
				return true;
			}
			else{
				return false;
			}
		}
		
	}
	
	



}
