package com.sakura.service;

import com.sakura.enity.Paper;
import com.sakura.mapper.PaperMapper;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaperServiceImpl implements PaperService{

    private final PaperMapper paperMapper;

    @Override
    public Paper getUrl(Long id) {
        return paperMapper.getUrl(id);
    }
}
