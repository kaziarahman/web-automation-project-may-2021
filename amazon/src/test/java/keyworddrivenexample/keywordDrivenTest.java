package keyworddrivenexample;

import org.testng.annotations.Test;

public class keywordDrivenTest {


    public class KeyWordDriverTest {

        @Test
        public void keywordtest() {
            EventCase eventCase = new EventCase();
            eventCase.functionEventCase("goToSignInPage");
            eventCase.functionEventCase("goToCreateAccountPage");
        }
    }
}
