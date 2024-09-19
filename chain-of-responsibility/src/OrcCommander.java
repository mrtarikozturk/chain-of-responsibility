/**
 * @author Zahir Ekrem SARITEKE
 * @project chain-of-responsibility
 * @created 07 September Saturday 2024 - 10:42
 */
public class OrcCommander implements RequestHandler {
    @Override
    public boolean canHandleRequest(Request req) {
        return req.getRequestType() == RequestType.DEFEND_CASTLE;
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public void handle(Request req) {
        req.markHandled();
        System.out.printf("%s handling request \"%s\".\n", name(), req);
    }

    @Override
    public String name() {
        return "Orc commander";
    }
}
