package edu.gatech.oad.fullhouse.findmystuff.test;

import java.util.List;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.model.Session;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.pres.LoginPresenter;
import edu.gatech.oad.fullhouse.findmystuff.pres.LookupUserPresenter;
import edu.gatech.oad.fullhouse.findmystuff.view.LoginActivity;
import edu.gatech.oad.fullhouse.findmystuff.view.LookupUserActivity;

public class LoginPresenterTest extends
		ActivityInstrumentationTestCase2<LoginActivity> {

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
			fail("getUserByEmail should not be called");
			return null;
		}

		public List<User> getUsers() {
			fail("getUsers should not be called");
			return null;
		}

		public void updateUser(User user) {
		}

		public void deleteUser(User user) {
			fail("deleteUser should not be called");
		}

	}

	public LoginPresenterTest() {
		super(LoginActivity.class);
	}

	private User getTestUser() {
		User testUser = new User();
		testUser.setUsername("test");
		testUser.setName("Test User");
		testUser.setPassword("password");
		return testUser;
	}

	public void testLoginUserNotFound() throws Throwable {
		LoginActivity activity = getActivity();
		assertNotNull(activity);
		User testUser = getTestUser();
		final LoginPresenter presenter = new LoginPresenter(activity,
				new TestUserAccessor(testUser));
		runTestOnUiThread(new Runnable() {

			public void run() {
				presenter.login("not_test", "password");
			}

		});
		Thread.sleep(1000);
		assertEquals(View.VISIBLE, getActivity().findViewById(R.id.textViewPasswordError)
				.getVisibility());
	}
	
	public void testPasswordIncorrect() throws Throwable {
		LoginActivity activity = getActivity();
		assertNotNull(activity);
		User testUser = getTestUser();
		assertEquals(0, testUser.getLoginAttempts());
		final LoginPresenter presenter = new LoginPresenter(activity,
				new TestUserAccessor(testUser));
		runTestOnUiThread(new Runnable() {

			public void run() {
				presenter.login("test", "not_password");
			}

		});
		Thread.sleep(1000);
		assertEquals(View.VISIBLE, getActivity().findViewById(R.id.textViewPasswordError)
				.getVisibility());
		assertEquals(1, testUser.getLoginAttempts());
	}
	
	public void testUserLocked() throws Throwable {
		LoginActivity activity = getActivity();
		assertNotNull(activity);
		User testUser = getTestUser();
		final LoginPresenter presenter = new LoginPresenter(activity,
				new TestUserAccessor(testUser));
		for (int i = 0; i < 3; i++) {
			runTestOnUiThread(new Runnable() {
		
					public void run() {
						presenter.login("test", "not_password");
					}
		
			});
			Thread.sleep(1000);
		}
		assertTrue(testUser.isLocked());
		runTestOnUiThread(new Runnable() {
			
			public void run() {
				presenter.login("test", "not_password");
			}

		});
		Thread.sleep(1000);
		assertEquals(View.VISIBLE, getActivity().findViewById(R.id.textViewLockedError)
				.getVisibility());
	}
	
//	public void testLoginSuccess() throws Throwable {
//		LoginActivity activity = getActivity();
//		assertNotNull(activity);
//		User testUser = getTestUser();
//		final LoginPresenter presenter = new LoginPresenter(activity,
//				new TestUserAccessor(testUser));
//		runTestOnUiThread(new Runnable() {
//			
//			public void run() {
//				presenter.login("test", "password");
//			}
//
//		});
//		Thread.sleep(1000);
//		assertEquals(View.VISIBLE, getActivity().findViewById(R.id.textViewSuccess)
//				.getVisibility());
//		assertEquals(testUser, Session.instance().getLoggedInUser());
//	}
}
