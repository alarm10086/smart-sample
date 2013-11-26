package com.smart.sample.ws.soap.support;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class FieldMapAdapter extends XmlAdapter<FieldMapWrapper, Map<String, Object>> {

    @Override
    public Map<String, Object> unmarshal(FieldMapWrapper fieldMapWrapper) throws Exception {
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        for (FieldMapWrapper.Entry entry : fieldMapWrapper.getEntryList()) {
            fieldMap.put(entry.getFieldName(), entry.getFieldValue());
        }
        return fieldMap;
    }

    @Override
    public FieldMapWrapper marshal(Map<String, Object> fieldMap) throws Exception {
        FieldMapWrapper fieldMapWrapper = new FieldMapWrapper();
        for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
            fieldMapWrapper.addEntry(entry.getKey(), entry.getValue());
        }
        return fieldMapWrapper;
    }
}
