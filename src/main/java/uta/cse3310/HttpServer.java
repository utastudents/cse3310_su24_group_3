package uta.cse3310;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.freeutils.httpserver.HTTPServer;
import net.freeutils.httpserver.HTTPServer.ContextHandler;
import net.freeutils.httpserver.HTTPServer.FileContextHandler;
import net.freeutils.httpserver.HTTPServer.Request;
import net.freeutils.httpserver.HTTPServer.Response;
import net.freeutils.httpserver.HTTPServer.VirtualHost;

public class HttpServer {
    private static final String HTML = "./html";
    int port = 9003;
    String dirname = HTML;

    public HttpServer(int portNum, String dirName) {
        System.out.println("Creating HTTP server on port " + portNum);
        port = portNum;
        dirname = dirName;
    }

    public void start() {
        System.out.println("Starting HTTP server");
        try {
            File dir = new File(dirname);
            if (!dir.canRead()) throw new FileNotFoundException(dir.getAbsolutePath());

            HTTPServer server = new HTTPServer(port);
            VirtualHost host = server.getVirtualHost(null); // default host
            host.setAllowGeneratedIndex(true); // with directory index pages
            host.addContext("/", new FileContextHandler(dir) {
                @Override
                public int serve(Request req, Response resp) throws IOException {
                    String path = req.getPath().toString();
                    if ("/".equals(path)) {
                        resp.getHeaders().add("Location", "/index.html");
                        resp.send(302, "Found");
                        return 0;
                    }
                    return super.serve(req, resp);
                }
            });
            host.addContext("/api/time", new ContextHandler() {
                public int serve(Request req, Response resp) throws IOException {
                    long now = System.currentTimeMillis();
                    resp.getHeaders().add("Content-Type", "text/plain");
                    resp.send(200, String.format("%tF %<tT", now));
                    return 0;
                }
            });
            server.start();
            System.out.println("HTTP Server is listening on Port " + port);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
