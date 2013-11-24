
import com.csong.hibernate.Session;
import com.csong.hibernate.Student;

public class StudentTest {

	public static void main(String[] args) throws Exception{
		Student s = new Student();
		s.setId(2);
		s.setName("song");
		s.setAge(33);

		Session session = new Session();
		session.save(s);
	}
}
