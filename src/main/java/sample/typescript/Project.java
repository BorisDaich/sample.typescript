package sample.typescript;

import java.util.ArrayList;
import java.util.Collection;

public class Project {
	public String id;
	public String projectName;
	public UserRef createdBy;

	public Collection<TaskRef> tasks = new ArrayList<>();

	public Project() {
		super();
	}

	public Project(String projectId, String projectName, UserRef createdBy) {
		super();
		this.id = projectId;
		this.projectName = projectName;
		this.createdBy = createdBy;
	}

	public static class TaskRef implements DBref {
		public String taskId;
		public String taskName;

		public TaskRef() {
			super();
		}

		public TaskRef(Task t) {
			this();
			this.taskId = t.taskId;
			this.taskName = t.taskName;
		}

		@Override
		public String getId() {
			return taskId;
		}

		@Override
		public String getType() {
			return "Task";
		}

	}

	public static class UserRef implements DBref {
		public String userId;
		public String fullName;

		public UserRef() {
			super();
		}

		public UserRef(User u) {
			this();
			this.fullName = u.family + " " + u.name;
			this.userId = u.id;
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
