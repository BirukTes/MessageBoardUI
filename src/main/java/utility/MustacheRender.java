package utility;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.StringWriter;

public class MustacheRender {

    private String templateName = "";
//    private String className;

    public MustacheRender(String templateName) {
//        this.className = className;
        this.templateName = templateName;
    }

    private String getHTML(Class className) {
        StringWriter writer = new StringWriter();

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("/messageboard/" + templateName);
        mustache.execute(writer, new className()).flush();
        String html = writer.toString();
        return html;
    }

}

