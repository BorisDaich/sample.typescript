package sample.typescript;

import java.util.ArrayList;
import java.util.Collection;

public class Task {

	public String taskId;
	public String taskName;
	public String taskDescr;
	public Collection<UserRef> relevantUsers = new ArrayList<>();
	public UserRef createdBy;

	public Task() {
		super();
	}

	public Task(String taskId, String taskName, String taskDescr, User createdBy) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescr = taskDescr;
		this.createdBy = new UserRef(createdBy);
	}

	public static class UserRef implements DBref {
		public String userId;
		public String name;
		public String family;
		public int age;

		public UserRef() {
			super();
		}

		public UserRef(User u) {
			this();
			this.userId = u.id;
			this.name = u.name;
			this.family = u.family;
			this.age = u.age;
		}

		@Override
		public String getId() {
			return userId;
		}

		@Override
		public String getType() {
			return "User";
		}
	}

}
