
package edu.gatech.oad.fullhouse.findmystuff.test;

import java.util.List;

import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.dao.UserAccessor;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.pres.RegisterPresenter;
import edu.gatech.oad.fullhouse.findmystuff.view.RegisterActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;


public class RegisterPresenterTest extends ActivityInstrumentationTestCase2<RegisterActivity> {

	public RegisterPresenterTest() {
		super(RegisterActivity.class);
	}
	
	
	private class TestUserAccessor implements UserAccessor {

        private User testUser;
        private boolean userCreated = false;

        public TestUserAccessor(User testUser) {
            this.testUser = testUser;
        }

        public void addUser(User user) {
            userCreated= true;
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
	
	private User getTestUser() {
        User testUser = new User();
        testUser.setUsername("test");
        testUser.setEmail("test@email.com");
        testUser.setName("Test User");
        testUser.setAdmin(false);
        return testUser;
    }
	
	private void assertUsernameErrorVisibility(int vis) {
        assertEquals(vis, getActivity().findViewById(R.id.registerUsernameError).getVisibility());
    }
	
	private void assertEmailErrorVisibility(int vis) {
        assertEquals(vis, getActivity().findViewById(R.id.registerEmailError).getVisibility());
    }
	
	private void assertEmailFormatErrorVisibility(int vis) {
        assertEquals(vis, getActivity().findViewById(R.id.registerEmailFormatError).getVisibility());
    }
	
	private void assertPasswordMismatchErrorVisibility(int vis) {
        assertEquals(vis, getActivity().findViewById(R.id.registerPasswordMismatchError).getVisibility());
    }
	
	private void assertUserCreated(TestUserAccessor accessor) {
        assertTrue(accessor.userCreated);
    }
	
	private void assertUserNotCreated(TestUserAccessor accessor) {
        assertFalse(accessor.userCreated);
    }
	
	/**
	 * Tests if registerUsernameError is displayed when user enters a duplicate username
	 * 
	 * @throws Throwable
	 */
	public void testRegisterUsernameError() throws Throwable {
	    RegisterActivity activity = getActivity();
	    assertNotNull(activity);
	    final User testUser = getTestUser();
	    TestUserAccessor accessor = new TestUserAccessor(testUser);
        final RegisterPresenter presenter = new RegisterPresenter(activity, accessor);
	    runTestOnUiThread(new Runnable() {

            public void run() {
            	presenter.checkRegInfo(testUser.getUsername(), "myPassword", "myPassword", "myName", 
                		"myLocation", "myEmail@email.com", "myPhone");
                
            }
	        
	    });
	    Thread.sleep(1000);
	    assertUsernameErrorVisibility(View.VISIBLE);
	    assertUserNotCreated(accessor);
	}
	
	/**
	 * Tests if registerEmailError is displayed when user enters a duplicate email address
	 * 
	 * @throws Throwable
	 */
	public void testRegisterEmailError() throws Throwable {
	    RegisterActivity activity = getActivity();
	    assertNotNull(activity);
	    final User testUser = getTestUser();
	    TestUserAccessor accessor = new TestUserAccessor(testUser);
        final RegisterPresenter presenter = new RegisterPresenter(activity, accessor);
	    runTestOnUiThread(new Runnable() {

            public void run() {
            	presenter.checkRegInfo("myUsername", "myPassword", "myPassword", "myName", 
                		"myLocation", testUser.getEmail(), "myPhone");
                
            }
	        
	    });
	    Thread.sleep(1000);
	    assertEmailErrorVisibility(View.VISIBLE);
	    assertUserNotCreated(accessor);
	}

	/**
	 * Tests if registerEmailFormatError is displayed when user enters an invalid email address
	 * 
	 * @throws Throwable
	 */
	public void testRegisterEmailFormatError() throws Throwable {
        RegisterActivity activity = getActivity();
        assertNotNull(activity);
        final User testUser = getTestUser();
        TestUserAccessor accessor = new TestUserAccessor(testUser);
        final RegisterPresenter presenter = new RegisterPresenter(activity, accessor);
        runTestOnUiThread(new Runnable() {

            public void run() {
            	presenter.checkRegInfo("myUsername", "myPassword", "myPassword", "myName", 
                		"myLocation", "myEmail", "myPhone");
            }
            
        });
        Thread.sleep(1000);
        assertEmailFormatErrorVisibility(View.VISIBLE);
        assertUserNotCreated(accessor);
	}

	/**
	 * Tests if registerPasswordMismatchError is displayed when user enters two different passwords
	 * 
	 * @throws Throwable
	 */
	public void testRegisterPasswordMismatchError() throws Throwable {
        RegisterActivity activity = getActivity();
        assertNotNull(activity);
        final User testUser = getTestUser();
        TestUserAccessor accessor = new TestUserAccessor(testUser);
        final RegisterPresenter presenter = new RegisterPresenter(activity, accessor);
        runTestOnUiThread(new Runnable() {

            public void run() {
                presenter.checkRegInfo("myUsername", "myPassword", "differentPassword", "myName", 
                		"myLocation", "myEmail@email.com", "myPhone");
            }
            
        });
        Thread.sleep(1000);
        assertPasswordMismatchErrorVisibility(View.VISIBLE);
        assertUserNotCreated(accessor);
	}
	
	/**
	 * Tests if User is created successfully when user enters valid information
	 * 
	 * @throws Throwable
	 */
	public void testRegisterUserSuccess() throws Throwable {
        RegisterActivity activity = getActivity();
        assertNotNull(activity);
        final User testUser = getTestUser();
        TestUserAccessor accessor = new TestUserAccessor(testUser);
        final RegisterPresenter presenter = new RegisterPresenter(activity, accessor);
        runTestOnUiThread(new Runnable() {

            public void run() {
                presenter.checkRegInfo("myUsername", "myPassword", "myPassword", "myName", 
                		"myLocation", "myEmail@email.com", "myPhone");
            }
            
        });
        Thread.sleep(1000);
        assertUserCreated(accessor);
	}
}
