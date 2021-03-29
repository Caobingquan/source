package generate;

import generate.OpsArticle;

public interface OpsArticleDao {
    int deleteByPrimaryKey(String id);

    int insert(OpsArticle record);

    int insertSelective(OpsArticle record);

    OpsArticle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OpsArticle record);

    int updateByPrimaryKey(OpsArticle record);
}