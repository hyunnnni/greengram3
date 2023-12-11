package com.green.greengram3.dm;

import com.green.greengram3.dm.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    int insDm(DmUserInsDto dto);

    int insDmUser(DmUserInsDto dto);

    int insDmMsg(DmMsgInsDto dto);
    List<DmMsgSelVo> selDmMsgAll(DmMsgSelDto dto);

    List<DmSelVo> selDmAll(DmSelDto dto);

    int delDmMsg(DmMsgDelDto dto);

}
