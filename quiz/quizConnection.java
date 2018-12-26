import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class quizConnection {
    private Connection db;
    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<String> quizInfos () {
        ArrayList<String> quizInfos = new ArrayList<String>();
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/JSP");
            this.db = ds.getConnection();
            this.ps = db.prepareStatement("SELECT * FROM quiz WHERE id=?");
            ps.setInt(1,1);
            rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

    return quizInfos;
    }

}
