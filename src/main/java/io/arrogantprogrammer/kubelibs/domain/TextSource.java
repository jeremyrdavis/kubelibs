package io.arrogantprogrammer.kubelibs.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.net.URL;

@Entity
class TextSource extends PanacheEntity {

    @Column(columnDefinition="TEXT")
    String text;

    String author;

    URL url;

    public TextSource(String text, String author, URL url) {
        this.text = text;
        this.author = author;
        this.url = url;
    }

    public TextSource() {
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

    public Long getId() {
        return this.id;
    }
}
