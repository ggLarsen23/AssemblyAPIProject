package Controller;

import Constants.AuthorizationKeys;
import Model.Transcript;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AssemblyAiHandler {

    HttpClient httpClient = HttpClient.newHttpClient();
    Gson gson = new Gson();

    public Transcript assemblyAISendTranscript(Transcript transcript) throws IOException, InterruptedException, URISyntaxException {

        String jsonRequest = gson.toJson(transcript);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", AuthorizationKeys.getAssemblyAIKey())
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("PostID: " + (String) transcript.getId());

        return gson.fromJson(postResponse.body(), Transcript.class);


    }
    public Transcript assemblyAIRetrieveTranslation(Transcript transcript) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
                .header("Authorization", AuthorizationKeys.getAssemblyAIKey())
                .build();

        while (true) {
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            transcript = gson.fromJson(getResponse.body(), Transcript.class);

            System.out.println(transcript.getStatus());

            if ("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus())) {
                break;
            }
            Thread.sleep(1000);
        }
        System.out.println("TRANSCRIPT RETRIEVED");
        return transcript;
    }
}
