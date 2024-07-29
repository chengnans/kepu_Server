package com.kj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kj.dto.AdminInformationDTO;
import com.kj.dto.AdminInformationSaveDTO;
import com.kj.dto.AdminInformationUpdateDTO;
import com.kj.entity.AdminInformation;
import com.kj.enums.AdminRole;
import com.kj.exception.HintException;
import com.kj.mapper.AdminInformationMapper;
import com.kj.service.AdminInformationService;
import com.kj.util.HashUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 破晓
 * @date 2022-01-23 16:32
 */
@Service
public class AdminInformationServiceImpl extends ServiceImpl<AdminInformationMapper, AdminInformation> implements AdminInformationService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void checkPassword(String username, String password) {
        int count = count(new QueryWrapper<AdminInformation>().eq(USERNAME, username).eq(PASSWORD, HashUtils.MD5(username, password)));
        if (count < 1) {
            throw new HintException("密码错误");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveAdminInformation(AdminInformationSaveDTO dto) {
        int count = count(new QueryWrapper<AdminInformation>().eq(USERNAME, dto.getUsername()));
        if (count > 0) {
            throw new HintException("用户名已经存在");
        }
        dto.setPassword(HashUtils.MD5(dto.getUsername(), dto.getPassword()));
        return save(modelMapper.map(dto, AdminInformation.class));
    }

    @Override
    public boolean removeAdminInformationById(Integer id) {
        int count = count(new QueryWrapper<AdminInformation>().eq(ID, id));
        if (count < 1) {
            throw new HintException("管理员不存在");
        }
        return removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateAdminInformation(AdminInformationUpdateDTO dto) {
        int count = count(new QueryWrapper<AdminInformation>().eq(USERNAME, dto.getUsername()));
        if (count < 1) {
            throw new HintException("此用户名不存在");
        }
        String password = HashUtils.MD5(dto.getUsername(), dto.getPassword());
        return update(new UpdateWrapper<AdminInformation>().set(PASSWORD, password).eq(USERNAME, dto.getUsername()));
    }

    @Override
    public AdminInformationDTO getAdminInformationByUsername(String username) {
        AdminInformation adminInformation = getOne(new QueryWrapper<AdminInformation>().eq(USERNAME, username));
        if (adminInformation != null) {
            return modelMapper.map(adminInformation, AdminInformationDTO.class);
        }
        return null;
    }

    @Override
    public List<AdminInformationDTO> getAdminInformationList() {
        List<AdminInformation> list = list(new QueryWrapper<AdminInformation>().select(ID, USERNAME).eq(ROLE, AdminRole.GENERAL_ADMIN));
        return modelMapper.map(list, new TypeToken<List<AdminInformationDTO>>(){}.getType());
    }
}
