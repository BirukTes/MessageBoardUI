package servlet;

import messageboard.MessageBoard;
import utility.MustacheRender;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageBoardServlet extends BaseServlet {
private MessageBoard messageBoard;

    public MessageBoardServlet() {
        messageBoard = new MessageBoard("simple test");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String html = new MustacheRender("MessageBoard.mustache", M)
        issue(PLAIN_TEXT_UTF_8, HttpServletResponse.SC_OK, toPrint.getBytes(CHARSET_UTF8), response);
    }
}
