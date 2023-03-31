import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Model {

    ArrayList<Integer> forumId = new ArrayList<>();
    ArrayList<String> forumContent = new ArrayList<>();
    ArrayList<String> forumTitel = new ArrayList<>();
    ArrayList<Timestamp> forumcreatedAt = new ArrayList<>();
    ArrayList<Integer> userId = new ArrayList<>();
    ArrayList<String> usersName = new ArrayList<>();
    ArrayList<String> usersPassword = new ArrayList<>();
    ArrayList<Integer> forumdId = new ArrayList<>();

    public ArrayList<Integer> getForumId() {
        return forumId;
    }

    public void setForumId(ArrayList<Integer> forumId) {
        this.forumId = forumId;
    }

    public ArrayList<String> getForumContent() {
        return forumContent;
    }

    public void setForumContent(ArrayList<String> forumContent) {
        this.forumContent = forumContent;
    }

    public ArrayList<String> getForumTitel() {
        return forumTitel;
    }

    public void setForumTitel(ArrayList<String> forumTitel) {
        this.forumTitel = forumTitel;
    }

    public ArrayList<Timestamp> getForumcreatedAt() {
        return forumcreatedAt;
    }

    public void setForumcreatedAt(ArrayList<Timestamp> forumcreatedAt) {
        this.forumcreatedAt = forumcreatedAt;
    }

    public ArrayList<Integer> getUserId() {
        return userId;
    }

    public void setUserId(ArrayList<Integer> userId) {
        this.userId = userId;
    }

    public ArrayList<String> getUsersName() {
        return usersName;
    }

    public void setUsersName(ArrayList<String> usersName) {
        this.usersName = usersName;
    }

    public ArrayList<String> getUsersPassword() {
        return usersPassword;
    }

    public void setUsersPassword(ArrayList<String> usersPassword) {
        this.usersPassword = usersPassword;
    }

    public ArrayList<Integer> getForumdId() {
        return forumdId;
    }

    public void setForumdId(ArrayList<Integer> forumdId) {
        this.forumdId = forumdId;
    }

    public void forum() {

        Connection conn = null;
        try {
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
            for (int i = 1; i <= numCols; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }

            int i = 0;

            while (result.next()) {
                forumdId.add(result.getInt("id"));
                forumContent.add(result.getString("content"));
                forumTitel.add(result.getString("title"));
                forumcreatedAt.add(result.getTimestamp("createdAt"));
                usersName.add(result.getString("name"));
                i++;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printarrays() {
        for (int i = 0; i < forumdId.size(); i++) {
            System.out.println(forumTitel.get(i) + forumContent.get(i) + forumcreatedAt.get(i) + usersName.get(i));
        }
    }

    public static void main(String[] args) {
        Model main = new Model();
        Connection conn = null;
        main.forum();
        main.printarrays();

    }}
