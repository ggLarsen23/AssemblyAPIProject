package Controller;

import Model.Transcript;
import Model.Translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Array;

import static Constants.Constants.audioUrl;

public class AudioFileTranslator {

    public void audioFileTranslator() throws IOException, URISyntaxException, InterruptedException {

//        /** Send audio to AssemblyAI and get transcript */
//        AssemblyAiHandler assemblyAiHandler = new AssemblyAiHandler();
//        Transcript transcript = new Transcript();
//        transcript.setAudio_url(audioUrl);
//        transcript = assemblyAiHandler.assemblyAISendTranscript(transcript);
//        transcript = assemblyAiHandler.assemblyAIRetrieveTranslation(transcript);


        /** Send transcript to DeepL and get Translation */
        DeepLHandler deepLHandler = new DeepLHandler();
        Translation translation = new Translation();

        translation.setTarget_lang("FR");

        String[] transcriptArray = new String[1];
        //transcriptArray[0] = transcript.getText();

        translation.setText(transcriptArray);
        translation = deepLHandler.deepLTranslate(translation);

        //System.out.println(transcript.getText());
    }
}
