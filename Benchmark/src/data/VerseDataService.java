package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import beans.Verse;

@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class VerseDataService implements DataAccessInterface<Verse>{
	
	public VerseDataService() {}

	@Override
	public Verse findByWord(String word) {

		Connection conn = null;
		String sql = "SELECT `Book`, `Chapter`, `VerseNumber` FROM Verses WHERE `Verse` LIKE ? LIMIT 1";
		Verse verse = null;
		
		String likeWord = "%" + word + "%";
		
		try
		{
			conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, likeWord);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				verse =new Verse(rs.getString("Book"), rs.getString("Chapter"), rs.getString("VerseNumber"));
			}
			
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return verse;
	}
	
	@Override
	public int findWordOccurence(String word) {

		Connection conn = null;
		String sql = "SELECT * FROM Verses WHERE `Verse` LIKE ?";
		Verse verse = null;
		int frequency = 0;
		
		String likeWord = "%" + word + "%";
		
		try
		{
			conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, likeWord);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				
				verse =new Verse(rs.getString("Verse"));
				
				for (String verseWord : verse.getVerse().replaceAll("[^a-zA-Z ]", "").split("\\s+"))
				{
					if (word.equals(verseWord) || (word + "s").equals(verseWord))
					{
						frequency++;

					}
				}
			}
			
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return frequency;
		
	}
	

	@Override
	public Verse findFullVerse(String bookName, String chapter, String verseNumber) {
		Connection conn = null;
		Verse verses = new Verse();
		String sql = "SELECT * FROM `Verses` WHERE `Book` = ? AND `Chapter` = ? AND `VerseNumber` = ?";
		
		
		try
		{
			conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, bookName);
			ps.setObject(2, chapter);
			ps.setObject(3, verseNumber);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				verses =new Verse(rs.getString("Verse"));
			}
			
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return verses;
	}
		
	}