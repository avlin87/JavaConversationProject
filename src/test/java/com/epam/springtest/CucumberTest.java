package com.epam.springtest;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

/**
 * JUnit Platform suite entry point for running Cucumber features.
 *
 * <p>Configured to:
 *
 * <ul>
 *   <li>Use the Cucumber engine
 *   <li>Load feature files from {@code src/test/resources/features}
 *   <li>Bind step definitions from {@code com.epam.springtest}
 *   <li>Produce reports (pretty, summary, HTML)
 * </ul>
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/ui")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.epam.springtest")
public class CucumberTest {
}
