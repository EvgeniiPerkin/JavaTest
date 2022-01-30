package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Long>{
	List<Message> findByTag(String tag);
}
