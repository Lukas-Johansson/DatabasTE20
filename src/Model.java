import javax.swing.*;
import java.sql.*;

public class Model {

    int forumId;
    String forumContent;
    String forumTitel;
    Timestamp forumcreatedAt;
    int userId;
    String usersName;
    String usersPassword;

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getForumContent() {
        return forumContent;
    }

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }

    public String getForumTitel() {
        return forumTitel;
    }

    public void setForumTitel(String forumTitel) {
        this.forumTitel = forumTitel;
    }

    public Timestamp getForumcreatedAt() {
        return forumcreatedAt;
    }

    public void setForumcreatedAt(Timestamp forumcreatedAt) {
        this.forumcreatedAt = forumcreatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersPassword() {
        return usersPassword;
    }

    public void setUsersPassword(String usersPassword) {
        this.usersPassword = usersPassword;
    }


    public static void main(String[] args) {
        Connection conn = null;


        // Set up connection to database
        try {
            /*conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop"+
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    user,password);
*/
            conn = DriverManager.getConnection("jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLoginData.user, DatabaseLoginData.password);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "SELECT lj04forum.*, lj04users.name FROM lj04forum JOIN lj04users ON lj04forum.authorId = lj04users.id";
            ResultSet result = stmt.executeQuery(SQLQuery);


            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }

            while (result.next()) {
                String output = "";
                output += result.getInt("id") + ", " +
                        result.getString("content") + ", " +
                        result.getString("title") + ", " +
                        result.getTimestamp("createdAt") + ", " +
                        result.getString("name");
                System.out.println(output);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
