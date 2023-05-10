package Model;

public class Translation {
    private String[] text;
    private String detected_source_language;

    private String target_lang;

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    public String getDetected_source_language() {
        return detected_source_language;
    }

    public void setDetected_source_language(String detected_source_language) {
        this.detected_source_language = detected_source_language;
    }

    public String getTarget_lang() {
        return target_lang;
    }

    public void setTarget_lang(String target_lang) {
        this.target_lang = target_lang;
    }
}
