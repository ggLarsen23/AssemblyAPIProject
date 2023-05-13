package Constants;

public class AuthorizationKeys {

    private static String deepLKey = secret.getDeepLKey();
    private static String addemblyAIKey = secret.getDeepLKey();

    public static String getDeepLKey() {
        return deepLKey;
    }

    public static String getAssemblyAIKey() {
        return addemblyAIKey;
    }
}
