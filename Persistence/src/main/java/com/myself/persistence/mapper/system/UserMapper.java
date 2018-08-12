/**
 * 
 */
package com.myself.persistence.mapper.system;

import org.apache.ibatis.annotations.Mapper;

import com.myself.persistence.entity.system.UserEntity;
import com.myself.persistence.mapper.AbstractMapper;

/**
 * @author zhanghong
 *
 */
@Mapper
public interface UserMapper extends AbstractMapper<UserEntity, Long> {

}
