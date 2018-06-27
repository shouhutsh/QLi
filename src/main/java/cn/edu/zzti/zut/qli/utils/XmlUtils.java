package cn.edu.zzti.zut.qli.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.Writer;

public final class XmlUtils {

    public static <T> T xml2Bean(Class<T> clazz, String source) {
        XStream xstream = getInstance();
        xstream.processAnnotations(clazz);
        xstream.processAnnotations(ObjectUtils.getInnerClasses(clazz));
        return (T) xstream.fromXML(source);
    }

    public static String bean2Xml(Object object) {
        Class clazz = object.getClass();

        XStream xstream = getInstance();
        xstream.processAnnotations(clazz);
        xstream.processAnnotations(ObjectUtils.getInnerClasses(clazz));
        return xstream.toXML(object);
    }

    public static XStream getInstance() {
        XStream xstream = new XStream(new PureJavaReflectionProvider(), new XppDriver() {

            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out, getNameCoder()) {
                    protected String PREFIX_CDATA = "<![CDATA[";
                    protected String SUFFIX_CDATA = "]]>";
                    protected String PREFIX_MEDIA_ID = "<MediaId>";
                    protected String SUFFIX_MEDIA_ID = "</MediaId>";

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (text.startsWith(this.PREFIX_CDATA) && text.endsWith(this.SUFFIX_CDATA)) {
                            writer.write(text);
                        } else if (text.startsWith(this.PREFIX_MEDIA_ID) && text.endsWith(this.SUFFIX_MEDIA_ID)) {
                            writer.write(text);
                        } else {
                            super.writeText(writer, text);
                        }

                    }

                    @Override
                    public String encodeNode(String name) {
                        return name;//防止将_转换成__
                    }
                };
            }
        });

        xstream.ignoreUnknownElements();
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        return xstream;
    }
}
