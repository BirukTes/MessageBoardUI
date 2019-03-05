package utility;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;

public class MustacheRender {

    @SuppressWarnings("unused")
    static final Logger LOGGER = LoggerFactory.getLogger(MustacheRender.class);

    private static final String DEFAULT_TEMPLATE = "template.mustache";
    private MustacheFactory mustacheFactory;

    // Default constructor
    public MustacheRender() {
        this(DEFAULT_TEMPLATE);
    }

    public MustacheRender(String template) {
        mustacheFactory = new DefaultMustacheFactory(template);
    }


    public String getHTML(String template, Object model) {
        StringWriter writer = new StringWriter();

        try {
            Mustache mustache = mustacheFactory.compile("/messageboard/" + template);
            mustache.execute(writer, model).flush();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return writer.toString();
    }

}

