package org.smart4j.sample.soap.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StringObjectMapAdapter extends XmlAdapter<StringObjectMapAdapter.Data, Map<String, Object>> {

    @Override
    public Map<String, Object> unmarshal(Data data) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Data.Entry entry : data.getList()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    @Override
    public Data marshal(Map<String, Object> map) throws Exception {
        Data data = new Data();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            data.addEntry(entry.getKey(), entry.getValue());
        }
        return data;
    }

    public static class Data {

        private List<Entry> list = new ArrayList<Entry>();

        public void addEntry(String fieldName, Object fieldValue) {
            Entry entry = new Entry();
            entry.setKey(fieldName);
            entry.setValue(fieldValue);
            list.add(entry);
        }

        public List<Entry> getList() {
            return list;
        }

        public void setList(List<Entry> list) {
            this.list = list;
        }

        public static class Entry {

            private String key;
            private Object value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public Object getValue() {
                return value;
            }

            public void setValue(Object value) {
                this.value = value;
            }
        }
    }
}
