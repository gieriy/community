package com.zhenjiehan.community.dao;

import com.zhenjiehan.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    /**
     * 当userId不为 0 时可查询某位用户的某页帖子
     * 当userId为 0 时查询某页帖子进行页面展示(首页)
     *
     * @param userId 用户id
     * @param offset 分页起始
     * @param limit  分页每页条数
     * @return 查出某页帖子集合
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * 当userId不为 0 时可查询某位用户的帖子数量
     * 当userId为 0 时查询所有帖子数量
     *
     * @param userId 用户id
     * @return 帖子数量
     */
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);
}
