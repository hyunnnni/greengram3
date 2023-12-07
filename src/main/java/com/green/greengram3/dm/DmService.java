package com.green.greengram3.dm;

import com.green.greengram3.common.Const;
import com.green.greengram3.dm.model.DmMsgInsSelDto;
import com.green.greengram3.dm.model.DmMsgSelVo;
import com.green.greengram3.dm.model.DmUserInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DmService {
    private final DmMapper mapper;

    public List<DmMsgSelVo> getMsgAll(DmMsgInsSelDto dto){
        dto.setRowCount(Const.FEED_COUNT_PER_PAGE);
        dto.setStartIdx((dto.getPage()-1)*dto.getRowCount());
        DmUserInsDto udto = DmUserInsDto.builder().build();
        if(dto.getPage() == 0){

        }
        return mapper.selDmMsgAll(dto);
    }
}
