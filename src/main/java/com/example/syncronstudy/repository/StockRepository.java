package com.example.syncronstudy.repository;

import com.example.syncronstudy.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
