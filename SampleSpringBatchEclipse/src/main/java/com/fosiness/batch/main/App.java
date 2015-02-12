package com.fosiness.batch.main;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {
	
	public static void main(String[] args) {

		App obj = new App();
		obj.run();

	}
	
	private void run() {

		String[] springConfig = { "launch-context.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

		/*JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("userVerificationEmailJob");

		try {

			JobParameters param = new JobParametersBuilder().addString("age", "20").toJobParameters();
			//JobParameters param = new JobParametersBuilder().addString("name", "user_c").toJobParameters();
			long starttime=System.currentTimeMillis();
			System.out.println("starttime :: "+starttime);
			JobExecution execution = jobLauncher.run(job, param);
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());
			
			long endtime=System.currentTimeMillis();
			System.out.println("endtime :: "+endtime);
			System.out.println((endtime-starttime));

		} catch (Exception e) {
			e.printStackTrace();

		}
*/
		System.out.println("Done");

	}

}
