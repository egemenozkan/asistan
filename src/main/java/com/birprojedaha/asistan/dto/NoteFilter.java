package com.birprojedaha.asistan.dto;

import com.birprojedaha.asistan.data.common.NoteType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NoteFilter implements Serializable {
    private static final long serialVersionUID = 7152921451935322182L;

    private long authorId;
    private List<LabelDto> labels;
    private List<NoteType> types;

    public void addLabel(String label) {
        if (labels == null) {
            labels = new ArrayList<>();
        }
        labels.add(new LabelDto(label));
    }

    public void addType(NoteType type) {
        if (types == null) {
            types = new ArrayList<>();
        }
        types.add(type);
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public List<LabelDto> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDto> labels) {
        this.labels = labels;
    }

    public List<NoteType> getTypes() {
        return types;
    }

    public void setTypes(List<NoteType> types) {
        this.types = types;
    }



}
