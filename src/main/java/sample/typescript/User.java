package sample.typescript;

import java.util.ArrayList;
import java.util.Collection;

public class User {
	public String id;
	public String name;
	public String family;
	public int age;
	public String phone;

	public Collection<ProjectRef> projects = new ArrayList<>();

	public User() {
		super();
	}

	public User(String userId, String name, String family, int age, String phone) {
		super();
		this.id = userId;
		this.name = name;
		this.family = family;
		this.age = age;
		this.phone = phone;
	}

	public static class ProjectRef implements DBref{
		public String projectId;
		public String projectName;

		public ProjectRef() {
			super();
		}

		public ProjectRef(Project p) {
			this();
			this.projectId = p.id;
			this.projectName = p.projectName;
		}

		@Override
		public String getId() {
			return projectId;
		}

		@Override
		public String getType() {
			return "Project";
		}
	}
}
