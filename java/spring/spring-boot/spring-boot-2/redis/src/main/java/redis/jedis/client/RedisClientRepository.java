package redis.jedis.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisClientRepository {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public Object getName() {
		String dcUser = redisTemplate.opsForValue().get("datacloud_user.G240NS43YC54WXQ5-G36E4B578EC3M44K");

		return dcUser;
	}
}