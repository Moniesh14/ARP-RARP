package cn;
//ARP and RARP
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class experiment3 {
	 static Map<String, String> arpTable = new HashMap<>();

	   static {
	       arpTable.put("192.168.1.1", "00-14-22-01-23-45");
	       arpTable.put("192.168.1.2", "00-14-22-01-23-46");
	       arpTable.put("192.168.1.3", "00-14-22-01-23-47");
	   }

	   public static void main(String[] args) {
	       Scanner scanner = new Scanner(System.in);
	       System.out.println("Enter 1 for ARP or 2 for RARP:");
	       int choice = scanner.nextInt();
	       scanner.nextLine();

	       if (choice == 1) {
	           System.out.println("Enter IP Address to get MAC Address:");
	           String ipAddress = scanner.nextLine();
	           String macAddress = arpTable.get(ipAddress);

	           if (macAddress != null) {
	               System.out.println("ARP: The MAC address for IP " + ipAddress + " is " + macAddress);
	           } else {
	               System.out.println("ARP: MAC address found for IP " + ipAddress);
	           }
	       } else if (choice == 2) {
	           System.out.println("Enter MAC Address to get IP Address:");
	           String macAddress = scanner.nextLine();
	           String ipAddress = null;

	           for (Map.Entry<String, String> entry : arpTable.entrySet()) {
	               if (entry.getValue().equals(macAddress)) {
	                   ipAddress = entry.getKey();
	                   break;
	               }
	           }

	           if (ipAddress != null) {
	               System.out.println("RARP: The IP address for MAC " + macAddress + " is " + ipAddress);
	           } else {
	               System.out.println("RARP: IP address found for MAC " + macAddress);
	           }
	       } else {
	           System.out.println("Invalid choice.");
	       }

	       scanner.close();
	   }
}
