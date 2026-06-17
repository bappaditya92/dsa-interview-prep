import java.util.HashSet;
import java.util.Set;

public class DuplicateRequestDetector {

    private Set<String> processedRequests = new HashSet<>();

    public boolean processRequest(String requestId) {

        if (processedRequests.contains(requestId)) {
            return false;
        }

        processedRequests.add(requestId);
        return true;
    }

    public static void main(String[] args) {

        DuplicateRequestDetector detector =
                new DuplicateRequestDetector();

        System.out.println(detector.processRequest("REQ101"));
        System.out.println(detector.processRequest("REQ101"));
    }
}
