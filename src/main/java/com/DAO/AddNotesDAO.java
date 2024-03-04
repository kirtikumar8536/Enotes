package com.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;

import com.User.*;

public class AddNotesDAO {
	private Connection con;

	public AddNotesDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean AddNotes(String title, String content, int uid) {
		boolean status = false;
		try {
			PreparedStatement ps = con.prepareStatement("insert into addnotes(title,content,uid) values (?,?,?)");
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, uid);// check the concept
			int i = ps.executeUpdate();
			System.out.println(i);
			if (i == 1) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	public List<AddNotes> getData(int id) {
		AddNotes notes = null;
		List<AddNotes> list = new ArrayList<AddNotes>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from addnotes where uid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				notes = new AddNotes();

				notes.setId(rs.getInt(1));
				notes.setTitle(rs.getString(2));
				notes.setContent(rs.getString(3));
				notes.setPdate(rs.getTimestamp(4));
				list.add(notes);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public AddNotes getDataById(int noteId) {
		AddNotes notes = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from addnotes where id=?");
			ps.setInt(1, noteId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				notes = new AddNotes();

				notes.setId(rs.getInt(1));
				notes.setTitle(rs.getString(2));
				notes.setContent(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return notes;
	}

	public boolean NotesUpdate(int id, String title, String content) {
		boolean status = false;
		try {
			PreparedStatement ps = con.prepareStatement("update addnotes set title=?,content=? where id=?");
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				status = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean NotesDelete(int noteid) {
		boolean status = false;
		try {
			PreparedStatement ps = con.prepareStatement("Delete from addnotes where id=? ");
			ps.setInt(1, noteid);
			int i = ps.executeUpdate();
			if (i == 1) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
