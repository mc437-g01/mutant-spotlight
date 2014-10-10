package br.unicamp.ic.mc437.g1;

import org.junit.*;
import org.junit.runner.*;
import org.slf4j.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.support.*;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {MainTestConfiguration.class})
public class WelcomeControllerTest {

    private static final Logger log = LoggerFactory.getLogger(WelcomeControllerTest.class);

    @Before
    public void setup() {
        log.debug("Setup test");
    }

    @After
    public void tearDown() {
        log.debug("Tear down");
    }

    @Test
    public void test() {
        log.debug("bla");
    }
}
