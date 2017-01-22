package test.tool;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class VerifyAccountTest {
	@Test
	public void testVerifyAccount() {
		// test Zhihu
		assertEquals(true, VerifyAccount.getInstance().verifyZhihuAccount("ice1000"));
		assertEquals(false, VerifyAccount.getInstance().verifyZhihuAccount("BIASjgguay8723"));
		assertEquals(true, VerifyAccount.getInstance().verifyZhihuImportance("ice1000"));
		// test GitHub
		assertEquals(true, VerifyAccount.getInstance().verifyGitHubAccount("Ray-Eldath"));
		assertEquals(false, VerifyAccount.getInstance().verifyGitHubAccount("TUILIJhd2084%^&*shc"));
		// ha ? ==我看看。。不会真有这个User吧。。。那就Bug了。我的锅，我看一眼
		// FIXME 你觉得我们需要实现一个verifyGitHubImportance吗？ ——Eldath haola1
		// test StackOverFlow
		assertEquals(true, VerifyAccount.getInstance().verifyStackOverFlowAccount("VonC"));
		assertEquals(false,VerifyAccount.getInstance().verifyStackOverFlowAccount("a4Y456&456#$%^"));
		assertEquals(true,VerifyAccount.getInstance().verifyStackOverFlowImportance("VonC"));
	}
}
