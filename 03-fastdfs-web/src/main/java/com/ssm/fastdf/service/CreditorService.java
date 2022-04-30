package com.ssm.fastdf.service;

import com.ssm.fastdf.model.CreditorInfo;

import java.util.List;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/4/30 9:36
 */
public interface CreditorService {
    List<CreditorInfo> selectAll();

    CreditorInfo selectById(Integer id);

    void updateFileInfo(CreditorInfo creditorInfo);

    void deleteFileById(Integer id);
}
