package com.myself.persistence.mapper.system;

import org.apache.ibatis.annotations.Mapper;

import com.myself.persistence.entity.system.PrivilegeEntity;
import com.myself.persistence.mapper.AbstractMapper;

/**
 * @author zhanghong
 *
 */
@Mapper
public interface PrivilegeMapper extends AbstractMapper<PrivilegeEntity, Long> {

}
