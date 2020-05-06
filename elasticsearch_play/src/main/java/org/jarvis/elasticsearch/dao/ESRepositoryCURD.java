package org.jarvis.elasticsearch.dao;

import org.elasticsearch.client.Response;

public interface ESRepositoryCURD {
    Response insertDocByReplace();
    Response insertDocByExist();
    Response deleteDoc();

    Response updateDoc();

    Response selectDoc();


}
