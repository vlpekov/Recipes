package com.vso.controlers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.database.utilities.ConnectorDB;

@WebServlet("/uploadImage")
@MultipartConfig(maxFileSize = 16177216)
public class UploadImage extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int result = 0;
		Connection connectionDB = null;
		Part part = request.getPart("image");

		if (part != null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connectionDB = ConnectorDB.getInstance().getConnection();
				PreparedStatement ps = connectionDB
						.prepareStatement("INSERT INTO `recipes_site`.`images` (`image`) values (?)");

				InputStream is = part.getInputStream();
				ps.setBlob(1, is);
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (connectionDB != null) {
					try {
						connectionDB.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		if (result > 0) {
			System.out.println("Усепешно качен файл");
		} else {
			System.out.println("Грешка при качване на файла");
		}
	}
}
