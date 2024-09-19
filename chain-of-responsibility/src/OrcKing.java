/**
 * @author Zahir Ekrem SARITEKE
 * @project chain-of-responsibility
 * @created 07 September Saturday 2024 - 10:42
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * OrcKing makes requests that are handled by the chain.
 */
public class OrcKing {

    private List<RequestHandler> handlers;

    public OrcKing() {
        buildChain();
    }

    private void buildChain() {
        handlers = Arrays.asList(new OrcCommander(), new OrcOfficer(), new OrcSoldier());
    }

    /**
     * Handle request by the chain.
     */
    public void makeRequest(Request req) {
        handlers
                .stream()
                //sort by priority
                .sorted(Comparator.comparing(RequestHandler::getPriority))
                //find the first handler that can handle the request
                .filter(handler -> handler.canHandleRequest(req))
                .findFirst()
                //handle the request
                .ifPresent(handler -> handler.handle(req));
    }
}