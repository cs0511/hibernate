import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.csong.hibernate.Teacher;

public class TeacherTest {

	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("chensong");
		t.setTitle("middle");

		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
