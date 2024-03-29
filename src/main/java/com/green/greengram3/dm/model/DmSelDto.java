package com.green.greengram3.dm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram3.common.Const;
import lombok.Data;

@Data
public class DmSelDto {
    private int page;
    private int loginedIuser;
    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount = Const.DM_MSG_COUNT_PER_PAGE;

    public void setPage(int page){
        this.startIdx = (page -1)*this.rowCount;
    }
}
