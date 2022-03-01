package com.optravis.logvidmi.excercise;

import com.optravis.logvidmi.excercise.ui.controller.ComputeIntersectionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@SpringBootApplication
public class ExerciseApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(ExerciseApplication.class);

	private final ComputeIntersectionController computeIntersectionController;

	public ExerciseApplication(ComputeIntersectionController computeIntersectionController) {
		this.computeIntersectionController = computeIntersectionController;
	}


	public static void main(String[] args) {
		LOG.info("Starting the application.");

		SpringApplication.run(ExerciseApplication.class, args);

		LOG.info("Application finished.");
	}

	@Override
	public void run(String... args) throws Exception {
		CommandLine commandLine = new CommandLine(computeIntersectionController);
		commandLine.execute(args);
	}
}
