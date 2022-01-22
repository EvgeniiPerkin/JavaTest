package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Message;
import com.example.demo.repositories.MessageRepo;

@Controller
public class MainController {
	@Autowired
	private MessageRepo messageRepo;
	
	@GetMapping("/")
	public String greeting(Map<String, Object> model) {
		return "greeting";
	}
	
	@GetMapping("/main")
	public String main(Map<String, Object> model) {
		Iterable<Message> messages = messageRepo.findAll();
		
		model.put("messages", messages);
		return "main";
	}
	
	@PostMapping("/main")
	public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
		Message msg = new Message(text, tag);
		
		messageRepo.save(msg);

		Iterable<Message> messages = messageRepo.findAll();
		
		model.put("messages", messages);
		
		return "main";
	}
	
	@PostMapping("filter")
	public String filer(@RequestParam String filter, Map<String, Object> model) {
		Iterable<Message> msgs;
		
		if (filter != null && !filter.isEmpty()) {
			msgs = messageRepo.findByTag(filter);
		}else {
			msgs = messageRepo.findAll();
		}
		
		model.put("messages", msgs);
		return "main";
	}
}
