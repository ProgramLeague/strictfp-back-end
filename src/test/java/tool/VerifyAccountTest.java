package tool;

import org.jetbrains.annotations.TestOnly;
import org.junit.Test;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class VerifyAccountTest {
	@Test
	public void test() {
		System.out.println(VerifyAccount.getInstance().verityGitHubAccount("Ray-Eldath"));
		System.out.println(VerifyAccount.getInstance().verityZhihuAccount("ice1000"));
	}
}
