package com.spring.task.chargroup.base.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sapan.Saxena
 * Class BaseText without any methods.
 * This class declares Context configuration classes and instructs to use Test runner based on Spring Junits implementation 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes={
        TestContext.class

} )
public class BaseTest {

}
