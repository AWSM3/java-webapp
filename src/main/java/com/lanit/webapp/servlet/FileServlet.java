package com.lanit.webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@WebServlet(name = "FileServlet", urlPatterns = {"/file/*"})
public class FileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getRequestURI().replace("/file/", "");
        String mimeType = Files.probeContentType(new File(filename).toPath());

        try (InputStream fileStream = getClass().getClassLoader().getResourceAsStream(filename)) {
            ServletOutputStream output = response.getOutputStream();

            if (fileStream == null) {
                response.setContentType("text/plain");
                response.getWriter().write("File not found");
            } else {
                response.setContentType(mimeType);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileStream.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            }
        }
    }
}
