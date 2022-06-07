package basic.authentication.authorization.util;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrimaryKeyGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		try {
			return String.valueOf(Math.abs(System.nanoTime() + new Random().nextLong()));
		} catch (Exception e) {
			log.error(ErrorsEnum.ERROR_GENERATING_PRIMARY_KEY_GENERATING_USING_UUID.getMessage(), e);
			return String.valueOf(UUID.randomUUID().timestamp());
		}
	}
}
