package edu.gatech.oad.fullhouse.findmystuff.test;

import java.util.List;

import LookupUserPresenterTest.IncidentAccessor;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.model.Session;
import edu.gatech.oad.fullhouse.findmystuff.pres.AddIncidentPresenter;
import edu.gatech.oad.fullhouse.findmystuff.view.AddIncidentActivity;

public class AddIncidentPresenterTest extends ActivityInstrumentationTestCase2<LoginActivity> {
	
	private Incident testIncident;
	
	private void assertErrorVisibility(int vis) {
		assertEquals(vis, getActivity().findViewById(R.id.notFoundError)
				.getVisibility());
    }
	
	public AddIncidentPresenterTest(){
		super(AddIncidentActivity.class);
	}
	
	private void assertIncidentDisplayed(Incident testIncident) {
		assertEquals(testIncident.getIncident_date(), ((TextView) getActivity()
				.findViewById(R.id.addIncidentDate)).getText());
		assertEquals(testIncident.getLocation(), ((TextView) getActivity()
				.findViewById(R.id.addIncidentLocation)).getText());
		
	}
	
	private class TestIncidentAccessor implements IncidentAccessor {

		private Incident testIncident;

		public TestIncidentAccessor(Incident testIncident) {
			this.testIncident = testIncident;
		}

		public void addIncident(Incident incident) {
			fail("addIncident should not be called");
		}

		public Incident getIncidentsByUser(User user) {
			if (this.testIncident.getUser_id().equals(user.getId())) {
				return this.testIncident;
			} else {
				return null;
			}
		}


		public void updateIncident(Incident incident) {
			fail("updateIncident should not be called");
		}

		public void deleteIncident(Incident incident) {
			fail("deleteIncident should not be called");
		}

	}
	
	private Incident getTestIncident() {
		Incident testIncident = new Incident();
		testIncident.setIncident_date("2010-03-12");
		testIncident.setLocation("test place");
		testIncident.setTitle("Test Title");
		
		return testIncident;
	}
	
	public void testAddIncident() throws Throwable {
		AddIncidentActivity activity = getActivity();
		assertNotNull(activity);
		Incident testIncident = getTestIncident();
		final AddIncidentPresenter presenter = new AddIncidentPresenter(activity);
		runTestOnUiThread(new Runnable() {

			public void run() {
				presenter.addIncident(testIncident);
			}

		});
		Thread.sleep(1000);
		assertErrorVisibility(View.GONE);
		assertIncidentrDisplayed(testIncident);
	}
	
	
}
