/**
 * @author Zahir Ekrem SARITEKE
 * @project chain-of-responsibility
 * @created 07 September Saturday 2024 - 10:40
 */
public interface RequestHandler {

    boolean canHandleRequest(Request req);

    int getPriority();

    void handle(Request req);

    String name();
}
