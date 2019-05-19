package com.scrapbook.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(indexName = "shakespeare", type="doc")
public class Shakespere implements Serializable {

    @Id
    private Integer line_id;
    private String line_number;
    private String play_name;
    private String speaker;
    private Integer speech_number;
    private String text_entry;
    private String type;

    public Integer getLine_id() {
        return line_id;
    }

    public Shakespere setLine_id(Integer line_id) {
        this.line_id = line_id;
        return this;
    }

    public String getLine_number() {
        return line_number;
    }

    public Shakespere setLine_number(String line_number) {
        this.line_number = line_number;
        return this;
    }

    public String getPlay_name() {
        return play_name;
    }

    public Shakespere setPlay_name(String play_name) {
        this.play_name = play_name;
        return this;
    }

    public String getSpeaker() {
        return speaker;
    }

    public Shakespere setSpeaker(String speaker) {
        this.speaker = speaker;
        return this;
    }

    public Integer getSpeech_number() {
        return speech_number;
    }

    public Shakespere setSpeech_number(Integer speech_number) {
        this.speech_number = speech_number;
        return this;
    }

    public String getText_entry() {
        return text_entry;
    }

    public Shakespere setText_entry(String text_entry) {
        this.text_entry = text_entry;
        return this;
    }

    public String getType() {
        return type;
    }

    public Shakespere setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shakespere that = (Shakespere) o;
        return Objects.equals(line_id, that.line_id) &&
                Objects.equals(line_number, that.line_number) &&
                Objects.equals(play_name, that.play_name) &&
                Objects.equals(speaker, that.speaker) &&
                Objects.equals(speech_number, that.speech_number) &&
                Objects.equals(text_entry, that.text_entry) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line_id, line_number, play_name, speaker, speech_number, text_entry, type);
    }
}
