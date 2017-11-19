package com.nostacktrace.images;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class ImageDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void sendNotFound(HttpServletResponse response) {
		response.setStatus(404);
	}

	private Image loadImage(Integer imageId) {
		if (imageId != null) {
			ImageManager manager = new ImageManager();
			return manager.imageById(imageId);
		} else {
			return null;
		}
	}
	
	private Integer parseInt(String value) {
		Integer id = null;
		try {
			id = Integer.parseInt(value);
		} catch (Exception ignored) {
		}
		return id;
	}

	private void copyIO(InputStream contentStream, ServletOutputStream outputStream) throws IOException {
		try {
			byte[] buffer = new byte[32 * 1024];

			while (true) {
				int numread = contentStream.read(buffer);
				if (numread < 1)
					break;
				outputStream.write(buffer, 0, numread);
			}
		} finally {
			contentStream.close();
		}
	}

	private boolean respondWithImage(HttpServletResponse response, Image image) {
		if (image != null) {
			try {
				response.setStatus(200);
				response.setContentType(image.getContentType());
				copyIO(image.getContentStream(), response.getOutputStream());

				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer imageId = parseInt(request.getParameter("id"));
		Image image = loadImage(imageId);

		if (!respondWithImage(response, image)) {
			sendNotFound(response);
		}
	}
}
