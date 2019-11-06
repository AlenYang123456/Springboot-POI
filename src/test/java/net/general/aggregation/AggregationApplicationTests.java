package net.general.aggregation;

import lombok.extern.slf4j.Slf4j;
import net.general.aggregation.utils.IdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@SpringBootTest
class AggregationApplicationTests {

	@Autowired
	private IdGenerator idGenerator;

	@Test
	public void testBatchId() {
		for (int i = 0; i < 100; i++) {
			String batchId = idGenerator.batchId(1001, 100);
			log.info("批次号: {}", batchId);
		}
	}

	@Test
	public void testSimpleUUID() {
		for (int i = 0; i < 100; i++) {
			String simpleUUID = idGenerator.simpleUUID();
			log.info("simpleUUID: {}", simpleUUID);
		}
	}

	@Test
	public void testRandomUUID() {
		for (int i = 0; i < 100; i++) {
			String randomUUID = idGenerator.randomUUID();
			log.info("randomUUID: {}", randomUUID);
		}
	}

	@Test
	public void testObjectID() {
		for (int i = 0; i < 100; i++) {
			String objectId = idGenerator.objectId();
			log.info("objectId: {}", objectId);
		}
	}

	@Test
	public void testSnowflakeId() {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 20; i++) {
			executorService.execute(() -> {
				log.info("分布式 ID: {}", idGenerator.snowflakeId());
			});
		}
		executorService.shutdown();
	}

}
