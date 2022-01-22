package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Message;
import com.example.demo.repositories.MessageRepo;

@Controller
public class GreetingController {
	@Autowired
	private MessageRepo messageGepo;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, 
			Map<String, Object> model) {
		model.put("name", name);
		return "greeting";
	}
	
	@GetMapping()
	public String main(Map<String, Object> model) {
		Iterable<Message> messages = messageGepo.findAll();
		
		model.put("messages", messages);
		return "main";
	}
	
	@PostMapping
	public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
		Message msg = new Message(text, tag);
		
		messageGepo.save(msg);

		Iterable<Message> messages = messageGepo.findAll();
		
		model.put("messages", messages);
		
		return "main";
	}
}
