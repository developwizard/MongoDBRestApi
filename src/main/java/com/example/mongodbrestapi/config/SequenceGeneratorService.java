package com.example.mongodbrestapi.config;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SequenceGeneratorService {
    private final MongoTemplate mongoTemplate;
    private final String FIELD_ID = "_id";
    private final String FIELD_SEQ = "seq";

    public SequenceGeneratorService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public long generateSequence(String seqName) {
        DatabaseSequence counter = mongoTemplate.findAndModify(
                Query.query(Criteria.where(FIELD_ID).is(seqName)),
                new Update().inc(FIELD_SEQ, 1), FindAndModifyOptions.options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
