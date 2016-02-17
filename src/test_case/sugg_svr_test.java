package test_case;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import utils.http_client;

public class sugg_svr_test {
	@Test
	public void test_case01() throws UnsupportedEncodingException, UnsupportedOperationException, IOException {
		System.out.println("This is first Test Case");
		String expect_str = "window.sogou.sug([\"liudehua\",[\"刘德华\",\"刘德华电影全集\",\"刘德华演唱会\",\"刘德华电影全集国语\",\"刘德华电影\",\"刘德华歌曲\",\"刘德华 咱们屯里的人\",\"刘德华老婆\",\"刘德华因获奖最多获世界纪录\",\"刘德华女儿\"],[\"0;0;1;0\",\"1;0;0;0\",\"2;0;0;0\",\"3;0;0;0\",\"4;0;0;0\",\"5;0;1;0\",\"6;0;0;0\",\"7;0;2;0\",\"8;0;0;0\",\"9;0;2;0\"],[\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"P_A_PERSON_4\",\"\",\"P_A_PERSON_1\"],[\"0\"],\"\",\"suglabId_1\"],-1);\n";
		String url = "http://10.134.15.20:8080/sugg/ajaj_json.jsp?key=liudehua&suguuid=0&ip=36.110.147.198&iploc=10.134.107.103&ad_type=1&type=websugg&webfront=websugg&abtestid=7&suid=3&yyid=4&pid=sogou&policyno=7&mfp=8&hs=9&mp=0";
		String result_str = http_client.send_get_request(url);
		assertEquals(result_str, expect_str);
	}
}
