package Controller;

import Constants.AuthorizationKeys;
import Model.Transcript;
import Model.Translation;
import com.google.gson.Gson;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class DeepLHandler {
    HttpClient httpClient = HttpClient.newHttpClient();
    Gson gson = new Gson();

    public Translation deepLTranslate(Translation translation) throws URISyntaxException {

        String jsonRequest = gson.toJson(translation);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("api-free.deepl.com/v2/translate/"))
                .header("Authorization", AuthorizationKeys.getAssemblyAIKey())
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        return translation;
    }


}
