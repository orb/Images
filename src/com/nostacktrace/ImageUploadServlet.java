package com.nostacktrace;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nostacktrace.images.ImageManager;

@WebServlet("/upload")
@MultipartConfig
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void flashMessage(HttpServletRequest request, String flashMessage) {
		request.getSession().setAttribute("flash", flashMessage);
	}

	private boolean imageTypeSupported(String contentType) {
		System.out.println("X " + contentType);
		return "image/png".equals(contentType) || "image/jpeg".equals(contentType);
	}

	protected void close(InputStream stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException ignored) {
			}
		}
	}

	private void handlePart(HttpServletRequest request, Part imagePart) {
		if (imagePart == null) {
			flashMessage(request, "Sorry, no file sent.");
			return;
		}

		String filename = imagePart.getSubmittedFileName();
		String contentType = imagePart.getContentType();

		if (!imageTypeSupported(contentType)) {
			flashMessage(request, "I don't know how to handle that image type");
			return;
		}

		InputStream contentStream = null;
		try {
			contentStream = imagePart.getInputStream();

			ImageManager manager = new ImageManager();
			if (!manager.addImage(filename, contentType, contentStream)) {
				flashMessage(request, "Sorry, I didn't manage to save that file");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
			flashMessage(request, "Hmm... I seem to have lost that upload.");
			return;

		} finally {
			close(contentStream);
		}

		flashMessage(request, "Thanks for the image, I'll add that to the list!");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		handlePart(request, request.getPart("newImage"));
		response.sendRedirect(request.getContextPath());
	}
}
