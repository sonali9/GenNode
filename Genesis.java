package posist;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Genesis {
	
	
	// 1. creation of genesis node
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
		
		// 2. set of child nodes of particular node
		ArrayList<GenesisNode> children = new ArrayList<>();
	}
	
	GenesisNode node=null;
	

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

		// create node and increase size
		GenesisNode child = new GenesisNode();
		size++;

		// set node's data
		child.value = data;
		child.nodenum++;

		// 3. creating the child nodes originating from a particular node
		System.out.println("enter the number of children for " + child.data);
		int numGC = scn.nextInt();

		for (int i = 0; i < numGC; i++) {
			GenesisNode grandchild = this.takeInput(child, i, scn);
			child.children.add(grandchild);
		}

		// return
		return child;
	}



}
