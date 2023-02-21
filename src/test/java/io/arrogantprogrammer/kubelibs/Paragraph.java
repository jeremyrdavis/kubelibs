package io.arrogantprogrammer.kubelibs;

import java.net.URL;

public class Paragraph {

    String text;

    String author;

    URL url;

    public Paragraph withText(String textValue) {

        this.text = textValue;
        return this;
    }

    public Paragraph byAuthor(String authorValue) {

        this.author = authorValue;
        return this;
    }

    public Paragraph locattedAt(URL urlValue) {

        this.url = urlValue;
        return this;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public URL getUrl() {
        return url;
    }
}
