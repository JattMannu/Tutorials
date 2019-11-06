package com.lucene.demo.abstraction;

import org.apache.lucene.document.Document;
import org.bson.BsonValue;

@FunctionalInterface
public interface Function {
    boolean apply(BsonValue bsonValue, String key, Document document);
}