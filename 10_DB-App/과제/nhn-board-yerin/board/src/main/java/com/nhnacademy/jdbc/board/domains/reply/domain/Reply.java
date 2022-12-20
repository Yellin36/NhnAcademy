package com.nhnacademy.jdbc.board.domains.reply.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Reply {
    private final long id;
    private final long replyId;
    private final long parentId;
    private final long bundleId;
    private final int bundleOrder;
}
