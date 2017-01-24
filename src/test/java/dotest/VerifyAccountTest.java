package dotest;

import org.junit.Test;
import tool.VerifyAccount;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class VerifyAccountTest {
	@Test(timeout = 70000)
	public void testVerifyAccount() {
		// test Zhihu
		System.out.println("VerifyAccountTest start");
		assertEquals(true, VerifyAccount.getInstance().verifyZhihuAccount("ice1000"));
		assertEquals(false, VerifyAccount.getInstance().verifyZhihuAccount("fu-qian-yi-55"));
		assertEquals(true, VerifyAccount.getInstance().verifyZhihuImportance("ice1000"));
		System.out.println("└─Finish test Zhihu");
		// test GitHub
		assertEquals(true, VerifyAccount.getInstance().verifyGitHubAccount("Ray-Eldath"));
		assertEquals(false, VerifyAccount.getInstance().verifyGitHubAccount("TUILIJhd2084%^&*shc"));
		System.out.println("└─Finish test Github");
		// FIXME 你觉得我们需要实现一个verifyGitHubImportance吗？ ——Eldath
		// test StackOverFlow
		assertEquals(true, VerifyAccount.getInstance().verifyStackOverFlowAccount("VonC"));
		assertEquals(false,VerifyAccount.getInstance().verifyStackOverFlowAccount("a4Y456&456#$%^"));
		assertEquals(true,VerifyAccount.getInstance().verifyStackOverFlowImportance("VonC"));
		System.out.println("└─Finish VerifyAccountTest");
	}
}
