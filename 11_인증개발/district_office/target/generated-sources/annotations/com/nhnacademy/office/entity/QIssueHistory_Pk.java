package com.nhnacademy.office.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QIssueHistory_Pk is a Querydsl query type for Pk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QIssueHistory_Pk extends BeanPath<IssueHistory.Pk> {

    private static final long serialVersionUID = 1160371084L;

    public static final QIssueHistory_Pk pk = new QIssueHistory_Pk("pk");

    public final DateTimePath<java.time.LocalDateTime> historyDate = createDateTime("historyDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> residentSerialNumber = createNumber("residentSerialNumber", Long.class);

    public QIssueHistory_Pk(String variable) {
        super(IssueHistory.Pk.class, forVariable(variable));
    }

    public QIssueHistory_Pk(Path<? extends IssueHistory.Pk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIssueHistory_Pk(PathMetadata metadata) {
        super(IssueHistory.Pk.class, metadata);
    }

}

