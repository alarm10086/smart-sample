package com.smart.sample.search;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.util.CollectionUtil;
import com.smart.plugin.search.IndexFieldName;
import com.smart.plugin.search.SearchEngine;
import com.smart.plugin.search.bean.IndexData;
import com.smart.plugin.search.bean.IndexDocument;
import com.smart.plugin.search.bean.IndexField;
import com.smart.plugin.search.bean.SearchResult;
import com.smart.sample.entity.Product;
import java.util.List;
import org.apache.lucene.document.Document;

@Bean
public class ProductSearchEngine implements SearchEngine {

    @Override
    public IndexData createIndexData() {
        IndexData indexData = new IndexData();
        List<Product> productList = DataSet.selectList(Product.class, "", "");
        if (CollectionUtil.isNotEmpty(productList)) {
            for (Product product : productList) {
                IndexDocument indexDocument = new IndexDocument();
                indexDocument.addIndexField(new IndexField(IndexFieldName.title, product.getName()));
                indexDocument.addIndexField(new IndexField(IndexFieldName.content, product.getDescription()));
                indexData.addIndexDocument(indexDocument);
            }
        }
        return indexData;
    }

    @Override
    public SearchResult createSearchResult(Document document) {
        SearchResult searchResult = new SearchResult();
        searchResult.setTitle(document.get("name"));
        searchResult.setContent(document.get("description"));
        return searchResult;
    }
}
