package tool;

import org.junit.Test;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class VerifyAccountTest {
	@Test
	public void test() {
		System.out.println(VerifyAccount.getInstance().verifyGitHubAccount("Ray-Eldath"));
		System.out.println(VerifyAccount.getInstance().verifyZhihuAccount("ice1000"));
		System.out.println(VerifyAccount.getInstance().verifyStackOverFlowImportance("VonC"));
	}
}
