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

    int insMakeDm(DmInsDto dto);
    int insMakeDmUser(DmInsDto dto);
    DmSelVo selDm(DmInsDto dto);

    Integer selCheckDm(DmInsDto dto); //null이 넘어올 수 있기 때문에 객체로 받아준다 int의 랩퍼클래스
}
