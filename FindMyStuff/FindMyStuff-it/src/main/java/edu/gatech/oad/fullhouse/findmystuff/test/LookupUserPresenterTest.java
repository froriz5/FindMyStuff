package edu.gatech.oad.fullhouse.findmystuff.test;

import java.util.List;

import android.os.Handler;
import android.os.Looper;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.pres.LookupUserPresenter;
import edu.gatech.oad.fullhouse.findmystuff.view.LookupUserActivity;

public class LookupUserPresenterTest extends
		ActivityInstrumentationTestCase2<LookupUserActivity> {

	private void assertErrorVisibility(int vis) {
		assertEquals(vis, getActivity().findViewById(R.id.notFoundError)
				.getVisibility());
	}

	private void assertUserDisplayed(User testUser) {
		assertEquals(testUser.getUsername(), ((TextView) getActivity()
				.findViewById(R.id.usernameDisplay)).getText());
		assertEquals(testUser.getName(), ((TextView) getActivity()
				.findViewById(R.id.nameDisplay)).getText());
		assertEquals(testUser.getEmail(), ((TextView) getActivity()
				.findViewById(R.id.emailDisplay)).getText());
	}

	private class TestUserAccessor implements UserAccessor {

		private User testUser;

		public TestUserAccessor(User testUser) {
			this.testUser = testUser;
		}

		public void addUser(User user) {
			fail("addUser should not be called");
		}

		public User getUserByUsername(String username) {
			if (this.testUser.getUsername().equals(username)) {
				return this.testUser;
			} else {
				return null;
			}
		}

		public User getUserByEmail(String email) {
			if (this.testUser.getEmail().equals(email)) {
				return this.testUser;
			} else {
				return null;
			}
		}

		public List<User> getUsers() {
			fail("getUsers should not be called");
			return null;
		}

		public void updateUser(User user) {
			fail("updateUser should not be called");
		}

		public void deleteUser(User user) {
			fail("deleteUser should not be called");
		}

	}

	public LookupUserPresenterTest() {
		super(LookupUserActivity.class);
	}

	/**
	 * @return
	 */
	private User getTestUser() {
		User testUser = new User();
		testUser.setUsername("test");
		testUser.setEmail("test@email.com");
		testUser.setName("Test User");
		testUser.setAdmin(true);
		return testUser;
	}

	public void testLookupUserNotFound() throws Throwable {
		LookupUserActivity activity = getActivity();
		assertNotNull(activity);
		User testUser = getTestUser();
		final LookupUserPresenter presenter = new LookupUserPresenter(activity,
				new TestUserAccessor(testUser));
		runTestOnUiThread(new Runnable() {

			public void run() {
				presenter.lookupUser("not_test");
			}

		});
		Thread.sleep(1000);
		assertErrorVisibility(View.VISIBLE);
	}

	public void testLookupUser() throws Throwable {
		LookupUserActivity activity = getActivity();
		assertNotNull(activity);
		User testUser = getTestUser();
		final LookupUserPresenter presenter = new LookupUserPresenter(activity,
				new TestUserAccessor(testUser));
		runTestOnUiThread(new Runnable() {

			public void run() {
				presenter.lookupUser("test");
			}

		});
		Thread.sleep(1000);
		assertErrorVisibility(View.GONE);
		assertUserDisplayed(testUser);
	}
}
