//Compile all under src/ |||| javac -d out src/*.java
//Running main |||| $ java -cp out Main

import java.util.Scanner; //importing scanner so technicians can input

public class Main {
    public static void main(String[] args) {
        TroubleshootingEngine engine = new TroubleshootingEngine();

//Troubleshooting Nodes (questions/answers for the pathway)
        TroubleshootingNode node0 = new TroubleshootingNode(
            "Solution check",
            "Did this resolve your issue?",
            true
        );
        TroubleshootingNode node1 = new TroubleshootingNode(
            "NET001",
            "Can you connect to their computer?",
            false
        );
        TroubleshootingNode node2 = new TroubleshootingNode(
                    "NET002",
                    "Which network are they on? VPN or Production network?",
                    false
                );
        TroubleshootingNode node3 = new TroubleshootingNode(
            "NET003",
            "Connect user to a network",
            false
        );
        TroubleshootingNode node4 = new TroubleshootingNode(
            "NET004",
            "Question for node4",
            false
        );

//Add nodes
        engine.addNode(node0);
        engine.addNode(node1);
        engine.addNode(node2);
        engine.addNode(node3);
        engine.addNode(node4);
//Node paths
    //Node1    
        node1.setYesNodeId("NET002");
        node1.setNoNodeId("NET003");
    //Node2
        node2.setYesNodeId("NET004");
        node2.setNoNodeId("NET005");
    //Node3
    //Node4

        Scanner scanner = new Scanner(System.in); //userInput
        
        System.out.println(node1.getMessage());

        String userInput = "";
        while (!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no")) { //While input is not equal to yes/no
            System.out.println("Enter yes or no: ");
            userInput = scanner.nextLine().trim();

            if (!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no")) {
                System.out.println("Invalid input. Please answer yes or no");
            }
        }
        boolean answer = userInput.equalsIgnoreCase("yes");

        TroubleshootingNode nextNode = engine.navigate(node1, answer); //Navigation
        if(nextNode != null) {
            System.out.println(nextNode.getMessage());
            System.out.println("Next node ID: " + nextNode.getId());
        } else {
            System.out.println("Error: Troubleshooting node does not exist");
        }
        
        
        scanner.close();
} //End of main()

}