package sample.typescript;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {

		User u1 = new User("u1", "name1", "family1", 11, "11111111");
		User u2 = new User("u2", "name2", "family2", 22, "22222222");

		Project p1 = new Project("p1", "proj1", new Project.UserRef(u1));
		Project p2 = new Project("p2", "proj2", new Project.UserRef(u2));

		Task t1 = new Task("t1", "task1", "descr1", u1);
		t1.relevantUsers.add(new Task.UserRef(u1));
		t1.relevantUsers.add(new Task.UserRef(u2));

		p1.tasks.add(new Project.TaskRef(t1));

		u1.projects.add(new User.ProjectRef(p1));
		
		Gson g = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		
		System.out.println("Project p1 :\n" + g.toJson(p1));
		
		System.out.println("=========================");
		System.out.println("Task t1 :\n" + g.toJson(t1));
		
		System.out.println("=========================");
		System.out.println("User u1 :\n" + g.toJson(u1));
		System.out.println("=========================");
		System.out.println("User u2 :\n" + g.toJson(u2));
		
	}

}
