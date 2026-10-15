import java.util.HashMap;
import java.util.Set;
public class TroubleshootingNode {
    private String Id;
    private String message;
    private boolean solution;
    private String yesNodeId;
    private String noNodeId;

    private HashMap<String, String> choices = new HashMap<>(); //Hashmap for node choices
    public void addChoice(String answer, String nextNodeId) { //uses PUT to add choices for a node
        choices.put(answer, nextNodeId);
    }
    public String getNextNodeId(String answer) { //uses GET to return the choice answer
        return choices.get(answer);
    }
    public Set<String> getAvailablechoices() {
        return choices.keySet();
    }

    //Constructor
    public TroubleshootingNode (
        String id,
        String message,
        boolean solution
    ) 
    {
        this.Id = id;
        this.message = message;
        this.solution = solution;
    }

    //Creating getters
    public String getId() {
        return this.Id;
    }
    public String getMessage() {
        return this.message;
    }
    public boolean isSolution() {
        return this.solution;
    }
    public String getYesNodeId() {
        return this.yesNodeId;
    }
    public String getNoNodeId() {
        return this.noNodeId;
    }


    //creating setters
    public void setYesNodeId(String yesNodeId) {
        this.yesNodeId = yesNodeId;
    }
    public void setNoNodeId(String noNodeId) {
        this.noNodeId = noNodeId;
    }

}    
    
