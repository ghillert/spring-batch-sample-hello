package org.springframework.batch.samples.hello;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Michael R. Lange <michael.r.lange@langmi.de>
 * @author Gunnar Hillert
 */
@ContextConfiguration(locations = {"classpath:META-INF/spring/batch-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloSpringBatchTest {

	@Autowired
	private Job job;

	@Autowired
	private JobLauncher jobLauncher;

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void startSpringBatchJob() throws Exception {

		final JobExecution jobExecution = jobLauncher.run(job, new JobParameters());

		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
		assertEquals("Hello Spring Batch!\n", outContent.toString());
	}
}

