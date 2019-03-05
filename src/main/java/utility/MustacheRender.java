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

    private static final String TEMPLATE_DIRECTORY = "messageboard";
    private MustacheFactory mustacheFactory;

    // Default constructor
    public MustacheRender() {
        this(TEMPLATE_DIRECTORY);
    }

    public MustacheRender(String templateDirectory) {
        mustacheFactory = new DefaultMustacheFactory(templateDirectory);
    }


    public String getCompiledTemplate(String template, Object model) {
        StringWriter writer = new StringWriter();

        try {
            Mustache mustache = mustacheFactory.compile(template);
            mustache.execute(writer, model).flush();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return writer.toString();
    }

}

