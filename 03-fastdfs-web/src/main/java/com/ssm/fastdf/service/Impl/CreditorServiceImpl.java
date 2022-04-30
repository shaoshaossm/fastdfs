package com.ssm.fastdf.service.Impl;

import com.ssm.fastdf.service.CreditorService;
import com.ssm.fastdf.mapper.CreditorInfoMapper;
import com.ssm.fastdf.model.CreditorInfo;
import com.ssm.fastdf.utils.FastDFSUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/4/30 9:36
 */
@Service
public class CreditorServiceImpl implements CreditorService {
    @Resource
    private CreditorInfoMapper creditorInfoMapper;
    @Override
    public List<CreditorInfo> selectAll() {
        List<CreditorInfo> list=creditorInfoMapper.selectAll();
        return list;
    }

    @Override
    public CreditorInfo selectById(Integer id) {
        return creditorInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateFileInfo(CreditorInfo creditorInfo) {
        creditorInfoMapper.updateByPrimaryKeySelective(creditorInfo);
    }

    @Override
    public void deleteFileById(Integer id) {
        CreditorInfo creditorInfo=creditorInfoMapper.selectByPrimaryKey(id);
        FastDFSUtil.delete(creditorInfo.getGroupName(),creditorInfo.getRemoteFilePath());
        creditorInfo.setRemoteFilePath("");
        creditorInfo.setGroupName("");
        creditorInfo.setOldFilename("");
        creditorInfo.setFileType("");
        creditorInfo.setFileSize(0L);
        creditorInfoMapper.updateByPrimaryKeySelective(creditorInfo);
    }
}
