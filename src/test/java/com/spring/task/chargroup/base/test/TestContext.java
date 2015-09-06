package com.spring.task.chargroup.base.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sapan.Saxena
 * Application Context for tests.  
 * Provides access to required Spring beans declared in the base package within @ComponentScan annotation
 *
 */
@Configuration
@ComponentScan(basePackages={
                "com.spring.task.chargroup.service.impl"
})
public class TestContext {
}
