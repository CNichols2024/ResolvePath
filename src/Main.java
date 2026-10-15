//Compile all under src/ |||| javac -d out src/*.java
//Running main |||| $ java -cp out Main

import java.util.Scanner; //importing scanner so technicians can input

public class Main {
    public static void main(String[] args) {
        TroubleshootingEngine engine = new TroubleshootingEngine();

//Troubleshooting Nodes (questions/answers for the pathway)
        TroubleshootingNode node1 = new TroubleshootingNode(
            "NET001",
            "Can you connect to their computer?",
            false
        );
        TroubleshootingNode node2 = new TroubleshootingNode(
                    "NET002",
                    "Is the user on a production network?",
                    false
                );
        TroubleshootingNode node3 = new TroubleshootingNode(
            "NET003",
            "Connect user to a network",
            true
        );
        TroubleshootingNode node4 = new TroubleshootingNode(
            "NET004",
            "Can the user access the Mobility Advisor login page?",
            false
        );
        TroubleshootingNode node5 = new TroubleshootingNode(
            "NET005",
            "Is the user on VPN?",
            false
        );
 /*       TroubleshootingNode node6 = new TroubleshootingNode(
            "NET006",
            "Can the user...",
            false   
        );
        TroubleshootingNode node7 = new TroubleshootingNode(
            "NET007",
            "Can the user...",
            false   
        );
        TroubleshootingNode node8 = new TroubleshootingNode(
            "NET008",
            "Can the user...",
            false   
        );
        TroubleshootingNode node9 = new TroubleshootingNode(
            "NET009",
            "Can the user...",
            false   
        );
        TroubleshootingNode node10 = new TroubleshootingNode(
            "NET010",
            "Can the user...",
            false   
        );
*/ 
//Add nodes
        engine.addNode(node1);
        engine.addNode(node2);
        engine.addNode(node3);
        engine.addNode(node4);
        engine.addNode(node5);
        engine.addNode(node6);
        engine.addNode(node7);
        engine.addNode(node8);
        engine.addNode(node9);
        engine.addNode(node10);
//Node paths
    //Node1    
        node1.setYesNodeId("NET002");
        node1.setNoNodeId("NET003");
    //Node2
        node2.setYesNodeId("NET004");
        node2.setNoNodeId("NET005");
    //Node3
        //Is solution
    //Node4
    //Node5
        node5.setYesNodeId("NET004");
        node5.setNoNodeId("NET003");
    //Node6
    //Node7
    //Node8
    //Node9
    //Node10

        Scanner scanner = new Scanner(System.in); //userInput

        TroubleshootingNode currentNode = node1; //Sets starting Node
        boolean answer = true;
        while (currentNode != null && !currentNode.isSolution()) { //While the current node is not null & current node is not the solution
            System.out.println(currentNode.getMessage());
            String userInput = "";

            while (!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no")) { //While user input is not yes/no
                System.out.println("Enter yes or no: ");
                userInput = scanner.nextLine().trim();

                if (!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no")) { //If input is not yes/no
                    System.out.println("Invalid entry. Please try again. ");
                }
            }
            answer = userInput.equalsIgnoreCase("yes");
            currentNode = engine.navigate(currentNode, answer);
        }
        
        if (currentNode == null) {
            System.err.println("Error: Troubleshooting path not found");
        } else {
            System.out.println("Solution found!");
            System.out.println(currentNode.getMessage());
        };

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