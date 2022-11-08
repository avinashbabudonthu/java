package junit.practice.test.suite;

import junit.practice.before.after.annotations.BeforeAfterJunitPractice;
import junit.practice.beforeclass.afterclass.annotations.BeforeClassAfterClassJunitPractice;
import junit.practice.hello.world.HelloWorldJunitPractice;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { HelloWorldJunitPractice.class, BeforeAfterJunitPractice.class, BeforeClassAfterClassJunitPractice.class })
public class TestSuiteJunitPractice {
}