package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Integer>{

}
