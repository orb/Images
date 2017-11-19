package com.nostacktrace.images;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nostacktrace.DataManager;

public class ImageManager extends DataManager {

	public List<Image> allImages() {
		List<Image> images = new ArrayList<>();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = Database.connection();
			st = conn.createStatement();
			rs = st.executeQuery("select id, name, content_type from Images");

			while (rs.next()) {
				images.add(new Image(rs.getInt("id"), rs.getString("name"), rs.getString("content_type")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(conn);
		}

		return images;
	}

	public boolean addImage(String filename, String contentType, InputStream contentInputStream) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = Database.connection();
			st = conn.prepareStatement("INSERT INTO images (name,content_type,content) values (?, ?, ?)");
			st.setString(1, filename);
			st.setString(2, contentType);
			st.setBinaryStream(3, contentInputStream);

			st.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(conn);
		}

		return false;
	}

	public Image imageById(int imageId) {
		Image image = null;

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = Database.connection();
			st = conn.prepareStatement("select id, name, content_type, content from images where id = ?");
			st.setInt(1, imageId);

			rs = st.executeQuery();
			if (rs.next()) {
			    image = new Image(rs.getInt("id"),
			    		rs.getString("name"),
			    		rs.getString("content_type"),
			    		rs.getBinaryStream("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(conn);
		}

		return image;
	}
}
