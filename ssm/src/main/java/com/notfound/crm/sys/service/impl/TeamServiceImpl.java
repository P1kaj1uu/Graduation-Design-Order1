package com.notfound.crm.sys.service.impl;

import com.notfound.crm.common.mapper.BaseMapper;
import com.notfound.crm.common.service.impl.BaseServiceImpl;
import com.notfound.crm.sys.form.TeamForm;
import com.notfound.crm.sys.mapper.TeamMapper;
import com.notfound.crm.sys.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl extends BaseServiceImpl<TeamForm> implements ITeamService {
    @Autowired
    private TeamMapper teamMapper;
    public TeamServiceImpl(TeamMapper teamMapper) {
        super(teamMapper);
    }
}
