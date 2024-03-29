package chat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;


@RestController
public class ChatController {
	@Autowired
    private ChatMessageRepository chatMessageRepository;
	private int x = 10;

    @GetMapping(value="/chat", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ChatMessage> getAllMessages() {
        return chatMessageRepository.findByChannel("Channel1");
    }
    
	@Scheduled(fixedRate = 3000)
	private void savePerson() {
		System.out.println("add new chat message "+x);
		chatMessageRepository.save(new ChatMessage(x + "", "Chat messages " + x+" id", "Channel1")).block();
		x++;
	}

}
