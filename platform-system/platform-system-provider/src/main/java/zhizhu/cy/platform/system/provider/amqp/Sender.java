package zhizhu.cy.platform.system.provider.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class Sender {

//	@Autowired
    private RabbitTemplate rabbitTemplate;

//	@Scheduled(fixedDelay = 10000L)
	public void send() {
		this.rabbitTemplate.convertAndSend("foo", "hello");
	}

}