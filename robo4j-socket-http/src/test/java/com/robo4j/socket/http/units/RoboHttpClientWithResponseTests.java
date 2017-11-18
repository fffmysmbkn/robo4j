/*
 * Copyright (c) 2014, 2017, Marcus Hirt, Miroslav Wengner
 *
 * Robo4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Robo4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Robo4J. If not, see <http://www.gnu.org/licenses/>.
 */

package com.robo4j.socket.http.units;

import com.robo4j.RoboBuilder;
import com.robo4j.RoboContext;
import com.robo4j.RoboReference;
import com.robo4j.util.SystemUtil;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

/**
 * testing http method GET with response
 *
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */
public class RoboHttpClientWithResponseTests {

	@Ignore
	@Test
	public void simpleRoboSystemGetRequestTest() throws Exception {

		RoboBuilder builderProducer = new RoboBuilder();
		InputStream clientConfigInputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("robo_client_request_producer_text.xml");
		builderProducer.add(clientConfigInputStream);
		RoboContext producerSystem = builderProducer.build();

		RoboBuilder builderConsumer = new RoboBuilder();
		InputStream serverConfigInputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("robo_client_request_consumer_text.xml");
		builderConsumer.add(serverConfigInputStream);
		RoboContext consumerSystem = builderConsumer.build();


		consumerSystem.start();
		producerSystem.start();

		System.out.println("consumer: State after start:");
		System.out.println(SystemUtil.printStateReport(consumerSystem));

		System.out.println("producer: State after start:");
		System.out.println(SystemUtil.printStateReport(producerSystem));


		RoboReference<Integer> descriptorProducer = producerSystem.getReference("descriptorProducer");
		descriptorProducer.sendMessage(1);

		System.out.println("Press Key...");
		System.in.read();

		producerSystem.shutdown();
		consumerSystem.shutdown();


	}

}
