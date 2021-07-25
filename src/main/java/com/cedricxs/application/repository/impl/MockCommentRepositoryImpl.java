package com.cedricxs.application.repository.impl;

import com.alibaba.fastjson.JSON;
import com.cedricxs.application.db.MockDataBase;
import com.cedricxs.application.po.CommentPO;
import com.cedricxs.application.repository.CommentRepository;
import com.cedricxs.application.utils.RedisKeyBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Repository("mockCommentRepository")
@Profile("local")
public class MockCommentRepositoryImpl implements CommentRepository {

    private static final String TABLE_NAME = "comment";

    @Resource
    private MockDataBase mockDataBase;

    @Override
    public boolean save(CommentPO commentPO) {
        return mockDataBase.set(TABLE_NAME, RedisKeyBuilder.buildCommentPoKey(commentPO), JSON.toJSONString(commentPO));
    }

    @Override
    public List<CommentPO> getAll() {
        return Optional.ofNullable(mockDataBase.getAll(TABLE_NAME))
                .orElseGet(ArrayList::new)
                .stream()
                .map(strings -> JSON.parseObject(strings, CommentPO.class))
                .collect(Collectors.toList());
    }
}
