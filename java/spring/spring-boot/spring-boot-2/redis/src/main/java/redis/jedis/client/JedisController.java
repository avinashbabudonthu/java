package redis.jedis.client;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JedisController {

	@Autowired
	private RedisClientRepository redisClientRepository;

	@GetMapping(value = "/names", produces = TEXT_PLAIN_VALUE)
	public String getName() {
		return redisClientRepository.getName().toString();
	}
}