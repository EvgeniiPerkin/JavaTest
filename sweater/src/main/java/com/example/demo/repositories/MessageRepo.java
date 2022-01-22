package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Integer>{
	List<Message> findByTag(String text);
}
