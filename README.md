Hello Spring Batch Sample
=========================

## Running the Sample

    $ mvn clean install

Run the application using the Maven Exec Plugin:

    $ mvn exec:java

Run the executable Jar File

    $ java -jar target/hello-1.0.0.BUILD-SNAPSHOT-shaded.jar META-INF/spring/batch-context.xml helloSpringBatchJob

You should see the following output:

	Aug 18, 2013 11:29:15 PM org.springframework.batch.core.launch.support.SimpleJobLauncher$1 run
	INFO: Job: [FlowJob: [name=helloSpringBatchJob]] launched with the following parameters: [{}]
	Aug 18, 2013 11:29:15 PM org.springframework.batch.core.job.SimpleStepHandler handleStep
	INFO: Executing step: [helloSpringBatchStep]
	Hello Spring Batch!
	Aug 18, 2013 11:29:15 PM org.springframework.batch.core.launch.support.SimpleJobLauncher$1 run
	INFO: Job: [FlowJob: [name=helloSpringBatchJob]] completed with the following parameters: [{}] and the following status: [COMPLETED]

## Providing Job Parameters

    $ java -jar target/hello-1.0.0.BUILD-SNAPSHOT-shaded.jar META-INF/spring/batch-context.xml helloSpringBatchJob "param1=Atlanta Jug" "schedule.date(date)=2013/08/20"

You should see the following output:

	Aug 18, 2013 11:31:14 PM org.springframework.batch.core.launch.support.SimpleJobLauncher$1 run
	INFO: Job: [FlowJob: [name=helloSpringBatchJob]] launched with the following parameters: [{schedule.date=1376971200000, param1=Atlanta Jug}]
	Aug 18, 2013 11:31:14 PM org.springframework.batch.core.job.SimpleStepHandler handleStep
	INFO: Executing step: [helloSpringBatchStep]
	Hello Spring Batch!
	------------------------------------------------
	The following 2 Job Parameter(s) is/are present:
	------------------------------------------------
	Parameter name: schedule.date; isIdentifying: true; type: DATE; value: Tue Aug 20 00:00:00 EDT 2013
	Parameter name: param1; isIdentifying: true; type: STRING; value: Atlanta Jug
	------------------------------------------------
	Aug 18, 2013 11:31:14 PM org.springframework.batch.core.launch.support.SimpleJobLauncher$1 run
	INFO: Job: [FlowJob: [name=helloSpringBatchJob]] completed with the following parameters: [{schedule.date=1376971200000, param1=Atlanta Jug}] and the following status: [COMPLETED]

## Credits

This sample was heavily inspired by *Michael R. Lange's* sample at:

* https://github.com/langmi/spring-batch-tutorials/tree/master/hello-world-java

Originally, I started out doing a fork but moved code around quite a bit, simplified (removed) things, updated dependencies etc. Ultimately, only the Junit Test is close to the original. Also, I adopted the Maven-Shade plugin usage, which is awesome. Anyway, please check out his project as it also provides a wonderful tutorial.





