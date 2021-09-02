package com.sakura.service;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.sakura.enity.SakuraOrder;
import com.sakura.mapper.OrderMapper;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@DubboService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService{

    private final OrderMapper orderMapper;
    private final IdGenerator idGenerator;

    @ShardingTransactionType(value = TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public SakuraOrder selectOrder(Long id, Long projectId) {
        SakuraOrder orderById = orderMapper.getOrderById(id, projectId);
        orderById.setOrderId(idGenerator.generateId().longValue());
        orderById.setProjectId(orderById.getOrderId());
        orderMapper.insert(orderById);
        int a = 1/0; //使用了分布式事务 报错会回滚
        return orderById;
    }
}
