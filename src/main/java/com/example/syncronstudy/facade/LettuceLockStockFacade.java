package com.example.syncronstudy.facade;

import com.example.syncronstudy.repository.RedisLockRepository;
import com.example.syncronstudy.service.StockService;
import org.springframework.stereotype.Component;

@Component
public class LettuceLockStockFacade {

    private final RedisLockRepository redisLockRepository;

    private final StockService stockService;

    public LettuceLockStockFacade(RedisLockRepository redisLockRepository, StockService stockService) {
        this.redisLockRepository = redisLockRepository;
        this.stockService = stockService;
    }

    public void decrease(Long id, Long quantity) throws InterruptedException {

        //spin lock 기법, 루프를 통해 계속 확인함
        while(!redisLockRepository.lock(id)) {
            Thread.sleep(100);
        }

        try {
            stockService.decrease(id,quantity);
        } finally {
            redisLockRepository.unlock(id);
        }
    }
}
