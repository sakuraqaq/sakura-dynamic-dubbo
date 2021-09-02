package com.sakura.service;

import com.sakura.enity.SakuraOrder;

public interface OrderService {

    SakuraOrder selectOrder(Long id, Long projectId);
}
