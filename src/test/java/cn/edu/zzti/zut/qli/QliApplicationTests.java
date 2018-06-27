package cn.edu.zzti.zut.qli;

import cn.edu.zzti.zut.qli.config.WechatConfig;
import cn.edu.zzti.zut.qli.model.request.WxRequest;
import cn.edu.zzti.zut.qli.model.response.WxTextResponse;
import cn.edu.zzti.zut.qli.utils.CryptUtils;
import cn.edu.zzti.zut.qli.utils.XmlUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QliApplicationTests {

    @Autowired
    private WechatConfig config;

    @Test
    public void Bean2Xml() {
        WxTextResponse response = new WxTextResponse();
        response.setContent("你<>好");
        System.out.println(XmlUtils.bean2Xml(response));
    }

    @Test
    public void Xml2Bean() {
        String xml = "<xml>\n" +
                "    <ToUserName><![CDATA[gh_360d5c8dd50a]]></ToUserName>\n" +
                "    <FromUserName><![CDATA[o4-nPt9jHLEHiHzBAp5b6LKfmstg]]></FromUserName>\n" +
                "    <CreateTime>1530016902</CreateTime>\n" +
                "    <MsgType><![CDATA[text]]></MsgType>\n" +
                "    <Content><![CDATA[你好]]></Content>\n" +
                "    <MsgId>6571372556844412649</MsgId>\n" +
                "    <Encrypt><![CDATA[0QV0+15a4ptSFFxsPp/jn3U/L1JohlB8ut4CarnP5hp7jQSyO8XWM8Rb7JuQA1NEngHEYvlRU7tw3n5hbqh4EnUqGZ4uAgA7fiolFz1cPYU8ofXDRqynPOu8Gl/HoItOLTSXsdDLHoB/0DL3F31x0YLmrVDpOjPXq4jPaejRHX/oM1xbddW+eJS/Dvo1pNMkRsd7EL/0CJzUfp9GT2yCIOc1QgmmzhGFjQMkwVnzE+DJV13OWyP6F6JCOhN4X2UNGr0d7HFTAROjWa5WLz3cN+OTwmVG6b4A7LtNawxF0iHXD9EjFsOan2Pvu0INHXPBd4LoUeQNRq3W+e94aWu493JshJEyPJkF/oL+Yag4RSAUCuauDsXd89x8FdA6zXVAGpf6FMWXD2OGj2LrkMAZ/ldImaP/wcozI/Tr/mp1SZo=]]></Encrypt>\n" +
                "</xml>";
        WxRequest request = XmlUtils.xml2Bean(WxRequest.class, xml);
        System.out.println(request.getContent());
    }
}
