package com.green.greengram3.dm;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import com.green.greengram3.user.UserMapper;
import com.green.greengram3.user.model.UserSelEntity;
import com.green.greengram3.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DmService {
    private final DmMapper mapper;
    private final UserMapper userMapper;

    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto){

        return mapper.selDmMsgAll(dto);
    }

    public List<DmSelVo> getDmAll(DmSelDto dto){
        return mapper.selDmAll(dto);
    }

    public ResVo postDmMsg(DmMsgInsDto dto){
        int result =  mapper.insDmMsg(dto);
        return new ResVo(dto.getSeq());
    }

    public ResVo delDmMsg(DmMsgDelDto dto){
        int result = mapper.delDmMsg(dto);
        return new ResVo(result);
    }


    public DmSelVo postDm(DmInsDto dto) {
        Integer result = mapper.selCheckDm(dto);

        if (result != null) {
            DmSelDto sdto = new DmSelDto();
            sdto.setLoginedIuser(dto.getLoginedIuser());
            List<DmSelVo> voList = mapper.selDmAll(sdto);

            for(DmSelVo vo : voList){
                if(vo.getOtherPersonIuser() == dto.getOtherPersonIuser()){
                    return vo;
                }
            }
        }

        mapper.insMakeDm(dto);
        mapper.insMakeDmUser(dto);

        UserSigninDto sdto = new UserSigninDto();
        sdto.setIuser(dto.getOtherPersonIuser());
        UserSelEntity entity = userMapper.selUser(sdto);//여기도 null이 들어올 수 있다 예외처리,,,


        return DmSelVo.builder()
                .idm(dto.getIdm())
                .otherPersonIuser(entity.getIuser())
                .otherPersonNm(entity.getNm())
                .otherPersonPic(entity.getPic())
                .build();
    }
}
