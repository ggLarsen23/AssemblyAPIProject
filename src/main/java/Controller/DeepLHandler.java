package Controller;

import Constants.AuthorizationKeys;
import Model.Transcript;
import Model.Translation;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

public class DeepLHandler {
    HttpClient httpClient = HttpClient.newHttpClient();
    Gson gson = new Gson();

    public Translation deepLTranslate(Translation translation) throws URISyntaxException, IOException, InterruptedException {

        String jsonRequest = gson.toJson(translation);
        //String jsonReuqest = "[{\"text\":Hello i am great,\"target_lang\":\"FR\"}]";

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api-free.deepl.com/v2/translate"))
                .header("Authorization", "DeepL-Auth-Key ".concat(AuthorizationKeys.getDeepLKey()))
                .header("Content-Type", "application/json")
                //.header("Content-Length", "37")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest, StandardCharsets.UTF_8))// jsonRequest.concat("&target_lang=FR")
                .build();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(postResponse);
        translation = gson.fromJson(postResponse.body(), Translation.class);

        return translation;
    }


}
