package io.gizmo.kz.telegram.bot.telegrambot.model.translator;

public class Word {
    private String value;
    private String lang;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (!value.equals(word.value)) return false;
        return lang.equals(word.lang);
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + lang.hashCode();
        return result;
    }
}
