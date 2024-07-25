package uta.cse3310;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import net.freeutils.httpserver.HTTPServer;
import net.freeutils.httpserver.HTTPServer.ContextHandler;
import net.freeutils.httpserver.HTTPServer.Request;
import net.freeutils.httpserver.HTTPServer.Response;
import net.freeutils.httpserver.HTTPServer.VirtualHost;

public class HttpServer {
    private static final String HTML = "HTML";
    int port = 9003;
    String dirname = HTML;

    public HttpServer(int portNum, String dirName) {
        System.out.println("Creating HTTP server on port " + portNum);
        port = portNum;
        dirname = dirName;
    }

    public void start() {
        System.out.println("In HTTP server start");
        try {
            File dir = new File(dirname);
            System.out.println("Looking for HTML directory at: " + dir.getAbsolutePath());

            if (!dir.exists() || !dir.canRead()) {
                throw new FileNotFoundException(dir.getAbsolutePath());
            }

            // set up server
            HTTPServer server = new HTTPServer(port);
            VirtualHost host = server.getVirtualHost(null); // default host
            host.setAllowGeneratedIndex(true); // with directory index pages

            // Add a context handler for the root path to serve index.html
            host.addContext("/", new ContextHandler() {
                @Override
                public int serve(Request req, Response resp) throws IOException {
                    System.out.println("Received request for: " + req.getPath());
                    File file;
                    if (req.getPath().equals("/") || req.getPath().equals("/index.html")) {
                        file = new File(dir, "index.html");
                        System.out.println("Serving file: " + file.getAbsolutePath());
                    } else {
                        file = new File(dir, req.getPath().substring(1));
                        System.out.println("Serving file: " + file.getAbsolutePath());
                    }

                    if (file.exists() && file.canRead()) {
                        resp.getHeaders().add("Content-Type", getMimeType(file.getName()));
                        try (FileInputStream fis = new FileInputStream(file);
                             OutputStream os = resp.getOutputStream()) {
                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = fis.read(buffer)) != -1) {
                                os.write(buffer, 0, bytesRead);
                            }
                        }
                        return 0;
                    } else {
                        System.out.println("File not found: " + file.getAbsolutePath());
                        resp.send(404, "File not found");
                        return 1;
                    }
                }

                private String getMimeType(String fileName) {
                    if (fileName.endsWith(".html") || fileName.endsWith(".htm")) {
                        return "text/html";
                    } else if (fileName.endsWith(".css")) {
                        return "text/css";
                    } else if (fileName.endsWith(".js")) {
                        return "application/javascript";
                    } else {
                        return "application/octet-stream";
                    }
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
            System.out.println("HttpServer is listening on Port " + port);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
