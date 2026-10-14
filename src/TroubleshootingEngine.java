import java.util.HashMap;

public class TroubleshootingEngine {
    private HashMap<String, TroubleshootingNode> nodes;

    public TroubleshootingEngine() {
        this.nodes = new HashMap<>();
    }

    public void addNode(TroubleshootingNode node) {
        nodes.put(node.getId(), node);
    }

    public TroubleshootingNode getNode(String id) {
        return nodes.get(id);
    }

    public TroubleshootingNode navigate( //Navigation moved to the engine instead of main
        TroubleshootingNode currentNode,
        boolean answer) {
            String nextId;
            if (answer) {
                nextId = currentNode.getYesNodeId();
            } else {
                nextId = currentNode.getNoNodeId();
            }
            return getNode(nextId);
        }
    
}
