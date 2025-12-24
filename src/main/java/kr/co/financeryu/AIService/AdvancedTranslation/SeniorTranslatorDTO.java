package kr.co.financeryu.AIService.AdvancedTranslation;

public class SeniorTranslatorDTO {

    private String userInput;
    private String inEnglish;
    private String inJapanese;
    private String inFrench;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getInEnglish() {
        return inEnglish;
    }

    public void setInEnglish(String inEnglish) {
        this.inEnglish = inEnglish;
    }

    public String getInJapanese() {
        return inJapanese;
    }

    public void setInJapanese(String inJapanese) {
        this.inJapanese = inJapanese;
    }

    public String getInFrench() {
        return inFrench;
    }

    public void setInFrench(String inFrench) {
        this.inFrench = inFrench;
    }

    @Override
    public String toString() {
        return "TranslationResult{" +
                "userInput='" + userInput + '\'' +
                ", inEnglish='" + inEnglish + '\'' +
                ", inJapanese='" + inJapanese + '\'' +
                ", inFrench='" + inFrench + '\'' +
                '}';
    }
}
