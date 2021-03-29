package generate;

import generate.OpsMedia;

public interface OpsMediaDao {
    int deleteByPrimaryKey(String id);

    int insert(OpsMedia record);

    int insertSelective(OpsMedia record);

    OpsMedia selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OpsMedia record);

    int updateByPrimaryKey(OpsMedia record);
}