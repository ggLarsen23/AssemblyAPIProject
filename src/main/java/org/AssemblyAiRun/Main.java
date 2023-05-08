package org.AssemblyAiRun;

import Constants.AuthorizationKeys;
import Controller.AssemblyAiHandler;
import Controller.AudioFileTranslator;
import Model.Transcript;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static Constants.Constants.audioUrl;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("SYSTEM INITIATED" + "\n");

        AudioFileTranslator audioFileTranslator = new AudioFileTranslator();
        audioFileTranslator.audioFileTranslator();

        System.out.println("SYSTEM ENDED" + "\n");
    }
}