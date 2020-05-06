package org.jarvis.elasticsearch.dao.impl;

import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Response;
import org.jarvis.elasticsearch.conf.ESClientFactory;
import org.jarvis.elasticsearch.dao.ESRepositoryCURD;

public class ESRepositoryCURDImpl implements ESRepositoryCURD {
    @Override
    public Response insertDocByReplace() {
        ESClientFactory.getESClient();
        IndexRequest indexRequest=new IndexRequest();
        indexRequest.opType(DocWriteRequest.OpType.CREATE);
        return null;
    }


    @Override
    public Response insertDocByExist() {
        return null;
    }

    @Override
    public Response deleteDoc() {
        return null;
    }

    @Override
    public Response updateDoc() {
        return null;
    }

    @Override
    public Response selectDoc() {
        return null;
    }
}
