package com.green.greengram3.dm;

import com.green.greengram3.dm.model.DmMsgInsSelDto;
import com.green.greengram3.dm.model.DmMsgSelVo;
import com.green.greengram3.dm.model.DmUserInsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    int insDm(DmUserInsDto dto);

    int insDmUser(DmUserInsDto dto);
    List<DmMsgSelVo> selDmMsgAll(DmMsgInsSelDto dto);
}
