public class TroubleshootingNode {
    private String Id;
    private String message;
    private boolean solution;
    private String yesNodeId;
    private String noNodeId;

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
    
