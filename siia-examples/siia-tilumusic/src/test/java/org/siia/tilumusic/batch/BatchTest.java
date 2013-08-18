package org.siia.tilumusic.batch;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:org/siia/tilumusic/batch/batch-config.xml"})
public class BatchTest {

	@Autowired
	private org.springframework.batch.core.launch.support.SimpleJobLauncher jobLauncher;

	@Test
	public void test() throws Exception {
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addString("input.file.name", "payment.input");
		Job job = new SimpleJob("importCalendars");
		System.out.println(job.getName() );
		System.out.println(job.isRestartable());
		
		Assert.notNull(jobLauncher);
		JobExecution execution = jobLauncher.run(job,
				jobParametersBuilder.toJobParameters());
	}

}
