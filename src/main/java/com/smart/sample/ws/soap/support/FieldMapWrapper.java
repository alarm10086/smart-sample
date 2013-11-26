package com.smart.sample.ws.soap.support;

import java.util.ArrayList;
import java.util.List;

public class FieldMapWrapper {

    private List<Entry> entryList = new ArrayList<Entry>();

    public void addEntry(String fieldName, Object fieldValue) {
        Entry entry = new Entry();
        entry.setFieldName(fieldName);
        entry.setFieldValue(fieldValue);
        entryList.add(entry);
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    public static class Entry {

        private String fieldName;

        private Object fieldValue;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public Object getFieldValue() {
            return fieldValue;
        }

        public void setFieldValue(Object fieldValue) {
            this.fieldValue = fieldValue;
        }
    }
}
