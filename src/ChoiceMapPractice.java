import java.util.HashMap;
public class ChoiceMapPractice {
    
    public static void main(String[] args) {
        HashMap<String, String> choices = new HashMap<>();
        choices.put("VPN", "NET003");
        choices.put("production", "NET003");
        choices.put("Guest", "NET005");
        choices.put("Disconnected", "NET006");
        String destination = choices.get("VPN");
        System.out.println("Destination: " + destination);
    }









}
