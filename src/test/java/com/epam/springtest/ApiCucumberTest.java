package com.epam.springtest;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/** JUnit Platform suite entry point for running API Cucumber features. */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/api")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.epam.springtest")
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "pretty,summary,html:target/cucumber-api.html")
public class ApiCucumberTest {}
